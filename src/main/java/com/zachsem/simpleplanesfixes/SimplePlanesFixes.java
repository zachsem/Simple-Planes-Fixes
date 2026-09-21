package com.zachsem.simpleplanesfixes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(
    modid = SimplePlanesFixes.MODID,
    name = SimplePlanesFixes.NAME,
    version = SimplePlanesFixes.VERSION,
    dependencies = "required-after:simpleplanes@[3.0.1.7,3.0.1.8);after:biomesoplenty;after:futuremc;after:jei;",
    acceptedMinecraftVersions = "[1.12.2]",
    useMetadata = true
)
public final class SimplePlanesFixes {
    public static final String MODID = "simpleplanesfixes";
    public static final String NAME = "Simple Planes Fixes";
    public static final String VERSION = "1.1.2";

    public SimplePlanesFixes() {}

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        ConditionalAircraft.hideUnusableFromCreativeTabs();
    }
}
