
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.joyg.item.KarmadameItem;
import net.joyg.item.DragonLeapItem;
import net.joyg.JoygMod;

public class JoygModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, JoygMod.MODID);
	public static final RegistryObject<Item> DRAGON_LEAP = REGISTRY.register("dragon_leap", () -> new DragonLeapItem());
	public static final RegistryObject<Item> KARMADAME = REGISTRY.register("karmadame", () -> new KarmadameItem());
}
