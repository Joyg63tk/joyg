
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.joyg.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.joyg.JoygMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JoygModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JoygMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(JoygModItems.BRASS_BLASTER.get());
			tabData.accept(JoygModItems.TOTEM_WOOD.get());
			tabData.accept(JoygModItems.TOTEM_STONE.get());
			tabData.accept(JoygModItems.TOTEM_IRON.get());
			tabData.accept(JoygModItems.TOTEM_GOLD.get());
			tabData.accept(JoygModItems.TOTEM_DIAMOND.get());
			tabData.accept(JoygModItems.TOTEM_NETHERITE.get());
			tabData.accept(JoygModItems.TOTEM_SUNKING.get());
			tabData.accept(JoygModItems.TOTEM_FROSTSHAMAN.get());
			tabData.accept(JoygModItems.AMETHYST_FOCUS_IRON.get());
			tabData.accept(JoygModItems.AMETHYST_FOCUS_GOLD.get());
			tabData.accept(JoygModItems.AMETHYST_FOCUS_DIAMOND.get());
			tabData.accept(JoygModItems.AMETHYST_FOCUS_NETHERITE.get());
			tabData.accept(JoygModItems.WAND_WOOD.get());
			tabData.accept(JoygModItems.WAND_IRON.get());
			tabData.accept(JoygModItems.WAND_GOLD.get());
			tabData.accept(JoygModItems.WAND_DIAMOND.get());
			tabData.accept(JoygModItems.WAND_NETHERITE.get());
			tabData.accept(JoygModItems.AMETHYST_FOCUS_ETERNAL.get());
			tabData.accept(JoygModItems.AMETHYST_FOCUS_FALL.get());
			tabData.accept(JoygModItems.CHASE_ITEM_HELM.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(JoygModItems.PORTAL_SCROLL.get());
			tabData.accept(JoygModItems.FLASH_BOMB.get());
		}
	}
}
