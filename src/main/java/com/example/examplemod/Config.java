package com.example.examplemod;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = ModListExporter.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.ConfigValue<String> OUTPUT_PATH = BUILDER
            .comment("The path where the JSON file containing the mod list will be written to")
            .define("output_path", "modlist.json");

    private static final ModConfigSpec.ConfigValue<List<? extends String>> HIDDEN_MOD_IDS = BUILDER
            .comment("A list of mod IDs to be hidden from the mod list")
            .defineList("hidden_mod_ids", List.of("minecraft", "neoforge", ModListExporter.MODID), o -> o instanceof String);

    private static final ModConfigSpec.BooleanValue ATOMIC_MOVE = BUILDER
            .comment("Whether to replace the mod list file atomically (may not be supported on all systems)")
            .define("atomic_move", true);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static String outputPath;
    public static Set<String> hiddenModIds;
    public static boolean atomicMove;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        outputPath = OUTPUT_PATH.get();
        hiddenModIds = new HashSet<>(HIDDEN_MOD_IDS.get());
        atomicMove = ATOMIC_MOVE.get();
    }
}
