
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.joyg.item.WandWoodItem;
import net.joyg.item.WandNetheriteItem;
import net.joyg.item.WandIronItem;
import net.joyg.item.WandGoldItem;
import net.joyg.item.WandDiamondItem;
import net.joyg.item.TotemWoodItem;
import net.joyg.item.TotemSunkingItem;
import net.joyg.item.TotemStoneItem;
import net.joyg.item.TotemNetheriteItem;
import net.joyg.item.TotemIronItem;
import net.joyg.item.TotemGoldItem;
import net.joyg.item.TotemFrostshamanItem;
import net.joyg.item.TotemDiamondItem;
import net.joyg.item.PortalScrollItem;
import net.joyg.item.KarmadameItem;
import net.joyg.item.GemStrenghtItem;
import net.joyg.item.GemRegenItem;
import net.joyg.item.FlashBombItem;
import net.joyg.item.BrassBlasterItem;
import net.joyg.item.AmethystFocusNetheriteItem;
import net.joyg.item.AmethystFocusIronItem;
import net.joyg.item.AmethystFocusGoldItem;
import net.joyg.item.AmethystFocusFallItem;
import net.joyg.item.AmethystFocusEternalItem;
import net.joyg.item.AmethystFocusDiamondItem;
import net.joyg.JoygMod;

public class JoygModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, JoygMod.MODID);
	public static final RegistryObject<Item> KARMADAME = REGISTRY.register("karmadame", () -> new KarmadameItem());
	public static final RegistryObject<Item> BRASS_BLASTER = REGISTRY.register("brass_blaster", () -> new BrassBlasterItem());
	public static final RegistryObject<Item> PORTAL_SCROLL = REGISTRY.register("portal_scroll", () -> new PortalScrollItem());
	public static final RegistryObject<Item> GEM_REGEN = REGISTRY.register("gem_regen", () -> new GemRegenItem());
	public static final RegistryObject<Item> GEM_STRENGHT = REGISTRY.register("gem_strenght", () -> new GemStrenghtItem());
	public static final RegistryObject<Item> TOTEM_WOOD = REGISTRY.register("totem_wood", () -> new TotemWoodItem());
	public static final RegistryObject<Item> TOTEM_STONE = REGISTRY.register("totem_stone", () -> new TotemStoneItem());
	public static final RegistryObject<Item> TOTEM_IRON = REGISTRY.register("totem_iron", () -> new TotemIronItem());
	public static final RegistryObject<Item> TOTEM_GOLD = REGISTRY.register("totem_gold", () -> new TotemGoldItem());
	public static final RegistryObject<Item> TOTEM_DIAMOND = REGISTRY.register("totem_diamond", () -> new TotemDiamondItem());
	public static final RegistryObject<Item> TOTEM_NETHERITE = REGISTRY.register("totem_netherite", () -> new TotemNetheriteItem());
	public static final RegistryObject<Item> TOTEM_SUNKING = REGISTRY.register("totem_sunking", () -> new TotemSunkingItem());
	public static final RegistryObject<Item> TOTEM_FROSTSHAMAN = REGISTRY.register("totem_frostshaman", () -> new TotemFrostshamanItem());
	public static final RegistryObject<Item> AMETHYST_FOCUS_IRON = REGISTRY.register("amethyst_focus_iron", () -> new AmethystFocusIronItem());
	public static final RegistryObject<Item> AMETHYST_FOCUS_GOLD = REGISTRY.register("amethyst_focus_gold", () -> new AmethystFocusGoldItem());
	public static final RegistryObject<Item> AMETHYST_FOCUS_DIAMOND = REGISTRY.register("amethyst_focus_diamond", () -> new AmethystFocusDiamondItem());
	public static final RegistryObject<Item> AMETHYST_FOCUS_NETHERITE = REGISTRY.register("amethyst_focus_netherite", () -> new AmethystFocusNetheriteItem());
	public static final RegistryObject<Item> WAND_WOOD = REGISTRY.register("wand_wood", () -> new WandWoodItem());
	public static final RegistryObject<Item> WAND_IRON = REGISTRY.register("wand_iron", () -> new WandIronItem());
	public static final RegistryObject<Item> WAND_GOLD = REGISTRY.register("wand_gold", () -> new WandGoldItem());
	public static final RegistryObject<Item> WAND_DIAMOND = REGISTRY.register("wand_diamond", () -> new WandDiamondItem());
	public static final RegistryObject<Item> WAND_NETHERITE = REGISTRY.register("wand_netherite", () -> new WandNetheriteItem());
	public static final RegistryObject<Item> AMETHYST_FOCUS_ETERNAL = REGISTRY.register("amethyst_focus_eternal", () -> new AmethystFocusEternalItem());
	public static final RegistryObject<Item> AMETHYST_FOCUS_FALL = REGISTRY.register("amethyst_focus_fall", () -> new AmethystFocusFallItem());
	public static final RegistryObject<Item> FLASH_BOMB = REGISTRY.register("flash_bomb", () -> new FlashBombItem());
}
