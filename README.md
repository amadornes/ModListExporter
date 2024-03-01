# Mod List Exporter

This mod creates a JSON file containing a list of all installed mods during startup.  
This file is intended to be used for displaying a list of mods on a website, or for any other purpose.

## Sample Webpage
A sample webpage is included in the `webpage` directory, which uses the `modlist.json` file in the
same directory to display a list of mods.

Note that you will need to provide the `modlist.json` file yourself, either by setting the `outputPath`
configuration option in the `modlistexporter-common.toml` file, or by establishing a symlink.
