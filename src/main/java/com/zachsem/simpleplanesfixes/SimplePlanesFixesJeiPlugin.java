package com.zachsem.simpleplanesfixes;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@JEIPlugin
public final class SimplePlanesFixesJeiPlugin implements IModPlugin {
    public SimplePlanesFixesJeiPlugin() {
    }

    @Override
    public void register(IModRegistry registry) {
        IIngredientBlacklist blacklist = registry.getJeiHelpers().getIngredientBlacklist();

        for (String path : ConditionalAircraft.getHiddenAircraftIds()) {
            Item item = ConditionalAircraft.getSimplePlanesItem(path);
            if (item != null) {
                blacklist.addIngredientToBlacklist(new ItemStack(item));
            }
        }
    }
}
