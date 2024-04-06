
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.joyg.item.WoodTotemItem;
import net.joyg.item.StoneTotemItem;
import net.joyg.item.PortalScrollItem;
import net.joyg.item.KarmadameItem;
import net.joyg.item.IronTotemItem;
import net.joyg.item.GemStrenghtItem;
import net.joyg.item.GemRegenItem;
import net.joyg.item.DragonLeapItem;
import net.joyg.item.BrassBlasterItem;
import net.joyg.JoygMod;

public class JoygModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, JoygMod.MODID);
	public static final RegistryObject<Item> DRAGON_LEAP = REGISTRY.register("dragon_leap", () -> new DragonLeapItem());
	public static final RegistryObject<Item> KARMADAME = REGISTRY.register("karmadame", () -> new KarmadameItem());
	public static final RegistryObject<Item> BRASS_BLASTER = REGISTRY.register("brass_blaster", () -> new BrassBlasterItem());
	public static final RegistryObject<Item> PORTAL_SCROLL = REGISTRY.register("portal_scroll", () -> new PortalScrollItem());
	public static final RegistryObject<Item> WOOD_TOTEM = REGISTRY.register("wood_totem", () -> new WoodTotemItem());
	public static final RegistryObject<Item> STONE_TOTEM = REGISTRY.register("stone_totem", () -> new StoneTotemItem());
	public static final RegistryObject<Item> IRON_TOTEM = REGISTRY.register("iron_totem", () -> new IronTotemItem());
	public static final RegistryObject<Item> GEM_REGEN = REGISTRY.register("gem_regen", () -> new GemRegenItem());
	public static final RegistryObject<Item> GEM_STRENGHT = REGISTRY.register("gem_strenght", () -> new GemStrenghtItem());
}
