# Changelog

## 1.1.2
- Fixes Junk Engine crafting on Forge 1.12.2.
- Repairs valid Biomes O' Plenty aircraft recipes using BOP 1.12.x registry IDs and metadata.
- Fixes BOP helicopter stair metadata.
- Adds conditional Crimson/Warped compatibility recipes when the required backported materials exist.
- Hides unusable optional-integration aircraft from JEI and the Simple Planes creative tab without unregistering them.
- Fixes production Forge registry compatibility in the conditional-integration code.

## 1.1.1
- Corrected production Forge registry access after the 1.1.0 test build exposed a mapped-name issue.

## 1.1.0
- Added conditional optional-integration visibility handling and Crimson/Warped compatibility support.

## 1.0.2
- Fixed BOP helicopter stair metadata.
- Normalized public author metadata to `zachsem`.

## 1.0.1
- Fixed Forge 1.12 mod construction by exposing a public no-argument constructor.
