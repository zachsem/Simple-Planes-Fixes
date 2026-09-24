# Simple Planes Fixes

**Simple Planes Fixes** is an unofficial bug-fix and compatibility addon for **Simple Planes 3.0.1.7 on Minecraft 1.12.2**.

## Official download

Installable releases are published on **CurseForge**:

**[Download Simple Planes Fixes on CurseForge](https://www.curseforge.com/minecraft/mc-mods/simple-planes-fixes)**

> **Important:** GitHub's **Code → Download ZIP** option downloads the project source code, not the installable mod. Download the release `.jar` from CurseForge and place that file in your `mods` folder.

The original 1.12.2 release contains several broken crafting recipes and optional-mod integrations caused by incorrect item IDs, missing metadata, and aircraft being registered even when the material set they depend on is unavailable. This addon repairs those issues without replacing or modifying the original Simple Planes jar.

## What it fixes

### Biomes O' Plenty compatibility

- Repairs supported BOP **Plane, Large Plane, Cargo Plane, and Helicopter** recipes using the actual BOP 1.12.x registry names and metadata.
- Fixes the metadata requirement that prevented BOP helicopter recipes from loading.
- Hides unsupported BOP aircraft families, such as Dead Wood, when the required material set does not exist.

### Junk Engine recipe

- Repairs the Junk Engine recipe by supplying the explicit vanilla coal metadata required by Forge 1.12.2.

### Optional integration cleanup

Simple Planes 1.12.2 registers aircraft for optional integrations even when their required materials are unavailable. The addon hides those unusable aircraft from JEI and the Simple Planes creative tab while leaving the registry entries intact for save compatibility.

This includes inactive or unavailable:

- Fruit Trees (`ft_*`) aircraft
- Oh The Biomes You'll Go (`byg_*`) aircraft
- unsupported Biomes O' Plenty aircraft
- Crimson and Warped aircraft when the expected Future MC material set is unavailable

### Crimson and Warped compatibility

The addon contains conditional compatibility recipes for Crimson and Warped aircraft using the `futuremc` registry namespace. They are enabled only when the required Future MC planks, slabs, stairs, and Netherite ingot are actually registered. If a Future MC build does not provide that complete material set, the aircraft remain hidden instead of appearing as unusable entries.

## Requirements

**Required**

- Minecraft 1.12.2
- Forge for Minecraft 1.12.2 — tested with 14.23.5.2859
- Simple Planes 3.0.1.7

**Optional integrations**

- Biomes O' Plenty
- Future MC — compatibility activates only when the required `futuremc` Crimson/Warped materials are registered
- Just Enough Items (JEI)

JEI is optional. When present, the addon uses JEI's supported ingredient blacklist API to hide unavailable integration aircraft.

## Installation

1. Install **Simple Planes 3.0.1.7**.
2. Download the **Simple Planes Fixes** release `.jar` from CurseForge.
3. Place the jar in the same `mods` folder.
4. Install it on both client and server.

Do not remove or edit the original Simple Planes jar. This project is a compatibility layer and requires the original mod.

## Reporting bugs

Please use the GitHub **Issues** tab. For a useful report, include Minecraft/Forge versions, Simple Planes and fix versions, relevant integration versions, the affected aircraft registry ID when applicable, reproduction steps, and `latest.log` or the crash report.

## Building from source

This is a ForgeGradle 2.3 / Minecraft 1.12.2 project targeting Java 8.

## Scope

The goal is to restore functionality clearly intended by the original 1.12.2 release. The addon does not invent substitute recipes for integrations that are absent or incomplete.

## Credits

- **Simple Planes** — original 1.12.2 authors **adoxentor (adox123)** and **przemyk (przemykomo)**, plus contributors
- **Biomes O' Plenty**, **Future MC**, **JEI**, **Fruit Trees**, and **Oh The Biomes You'll Go** — respective authors and contributors
- **Simple Planes Fixes** — zachsem

This is an independent, unofficial compatibility project and is not an official Simple Planes release.

## License

GPL-3.0. See [`LICENSE`](LICENSE) and [`NOTICE.md`](NOTICE.md).
