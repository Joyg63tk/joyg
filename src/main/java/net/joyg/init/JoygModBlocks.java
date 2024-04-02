
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.joyg.block.PortalBlock;
import net.joyg.JoygMod;

public class JoygModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, JoygMod.MODID);
	public static final RegistryObject<Block> PORTAL = REGISTRY.register("portal", () -> new PortalBlock());
}
