
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.joyg.enchantment.EmpowerEnchantment;
import net.joyg.JoygMod;

public class JoygModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, JoygMod.MODID);
	public static final RegistryObject<Enchantment> EMPOWER = REGISTRY.register("empower", () -> new EmpowerEnchantment());
}
