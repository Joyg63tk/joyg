
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.joyg.world.inventory.LootbagslotsMenu;
import net.joyg.JoygMod;

public class JoygModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, JoygMod.MODID);
	public static final RegistryObject<MenuType<LootbagslotsMenu>> LOOTBAGSLOTS = REGISTRY.register("lootbagslots", () -> IForgeMenuType.create(LootbagslotsMenu::new));
}
