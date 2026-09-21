# Attribution and modification notice

This compatibility/fix mod was created in 2026 for Minecraft 1.12.2.

It does not redistribute Simple Planes or its optional integration mods. It supplies replacement recipe registrations and compatibility behavior from its own mod namespace so the original mod jars can remain untouched.

Simple Planes recipe behavior and recipe structures were referenced while preparing these fixes. The Simple Planes 1.12.2 source branch is GPL-3.0 licensed, so this patch mod is also released under GPL-3.0.

Targets przemykomo/simple-planes and its Biomes O' Plenty compatibility recipes. Biomes O' Plenty registry mappings were verified against the BOP 1.12.x-7.0.x source.

Version 1.0.1 fixes Forge 1.12 mod construction by exposing a public no-argument mod constructor.
Version 1.0.2 fixes BOP helicopter stair metadata for Forge 1.12 and normalizes public author metadata to `zachsem`.
Version 1.1.0 adds conditional JEI/creative visibility handling and conditional Crimson/Warped compatibility.
Version 1.1.1 replaces production-unsafe direct Minecraft registry member access with Forge registry access.
Version 1.1.2 fixes the Forge registry ABI signature used by the hand-built test jar.
