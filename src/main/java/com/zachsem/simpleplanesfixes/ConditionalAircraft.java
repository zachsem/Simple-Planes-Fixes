package com.zachsem.simpleplanesfixes;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class ConditionalAircraft {
    private static final String[] AIRCRAFT_SUFFIXES = {
        "_plane", "_large_plane", "_helicopter", "_mega_plane"
    };

    private static final String[] BOP_WOODS = {
        "cherry", "fir", "hellbark", "jacaranda", "mahogany",
        "magic", "palm", "redwood", "umbran", "willow", "dead"
    };

    private static final String[] BYG_WOODS = {
        "aspen", "baobab", "blue_enchanted", "cherry", "cika", "cypress",
        "ebony", "fir", "green_enchanted", "holly", "jacaranda", "mahogany",
        "mangrove", "maple", "pine", "rainbow_eucalyptus", "redwood", "skyris",
        "willow", "witch_hazel", "zelkova"
    };

    private ConditionalAircraft() {
    }

    static boolean itemExists(String namespace, String path) {
        return ForgeRegistries.ITEMS.containsKey(new ResourceLocation(namespace, path));
    }

    private static void addFamily(List<String> hidden, String materialName) {
        for (String suffix : AIRCRAFT_SUFFIXES) {
            hidden.add(materialName + suffix);
        }
    }

    private static boolean bopFamilyUsable(String wood) {
        if ("dead".equals(wood)) {
            return itemExists("biomesoplenty", "dead_boat")
                && itemExists("biomesoplenty", "dead_stairs")
                && itemExists("biomesoplenty", "dead_planks");
        }

        return itemExists("biomesoplenty", "boat_" + wood)
            && itemExists("biomesoplenty", wood + "_stairs")
            && itemExists("biomesoplenty", "planks_0")
            && (itemExists("biomesoplenty", "wood_slab_0")
                || itemExists("biomesoplenty", "wood_slab_1"));
    }

    private static boolean fruitTreesFamilyUsable(String wood) {
        return itemExists("fruittrees", wood + "_planks")
            && itemExists("fruittrees", wood + "_slab")
            && itemExists("fruittrees", wood + "_stairs")
            && itemExists("fruittrees", wood + "_boat");
    }

    private static boolean bygFamilyUsable(String wood) {
        return itemExists("byg", wood + "_planks")
            && itemExists("byg", wood + "_slab")
            && itemExists("byg", wood + "_stairs")
            && itemExists("byg", wood + "_boat");
    }

    private static boolean futureMcNetherWoodUsable(String wood) {
        return itemExists("futuremc", wood + "_planks")
            && itemExists("futuremc", wood + "_slab")
            && itemExists("futuremc", wood + "_stairs")
            && itemExists("futuremc", "netherite_ingot");
    }

    static List<String> getHiddenAircraftIds() {
        List<String> hidden = new ArrayList<String>();

        for (String wood : BOP_WOODS) {
            if (!bopFamilyUsable(wood)) {
                addFamily(hidden, "bop_" + wood);
            }
        }

        for (String wood : new String[] {"cherry", "citrus"}) {
            if (!fruitTreesFamilyUsable(wood)) {
                addFamily(hidden, "ft_" + wood);
            }
        }

        for (String wood : BYG_WOODS) {
            if (!bygFamilyUsable(wood)) {
                addFamily(hidden, "byg_" + wood);
            }
        }

        for (String wood : new String[] {"crimson", "warped"}) {
            if (!futureMcNetherWoodUsable(wood)) {
                addFamily(hidden, wood);
            }
        }

        return Collections.unmodifiableList(hidden);
    }

    static Item getSimplePlanesItem(String path) {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation("simpleplanes", path));
    }

    private static void removeCreativeTab(Item item) {
        // This addon is distributed as a normal Forge mod, but these test jars are
        // compiled outside ForgeGradle. Minecraft member names differ between a
        // development workspace (MCP) and a production 1.12 client (SRG), so use
        // reflection for this one Minecraft method instead of baking in an
        // unmapped member reference.
        for (String methodName : new String[] {"setCreativeTab", "func_77637_a"}) {
            try {
                Method method = Item.class.getMethod(methodName, CreativeTabs.class);
                method.invoke(item, new Object[] {null});
                return;
            } catch (ReflectiveOperationException ignored) {
                // Try the other 1.12 name.
            }
        }
    }

    static void hideUnusableFromCreativeTabs() {
        for (String path : getHiddenAircraftIds()) {
            Item item = getSimplePlanesItem(path);
            if (item != null) {
                removeCreativeTab(item);
            }
        }
    }
}
