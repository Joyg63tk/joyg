package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.joyg.init.JoygModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class DragonLeapSpecialInformationProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == JoygModItems.DRAGON_LEAP.get()) {
			tooltip.add(Component.literal("\u00A76Martial Skill"));
			tooltip.add(Component.literal("Leap a great distance forward, slamming enemies in a small area when you land"));
			tooltip.add(Component.literal("Cost: 4 Food lvls"));
			tooltip.add(Component.literal("Hold \u00A7eShift \u00A7fto see Scaling Tags"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Scaling Tags:"));
				tooltip.add(Component.literal("-\u00A71Skill Effect Area \u00A7f Base Area multiplier from Skill: 4m"));
				tooltip.add(Component.literal("-\u00A7dSkill Cooldown Reduction \u00A7fBase Cooldown multiplier from Skill: 15s "));
				tooltip.add(Component.literal("-\u00A74Attack Damage \u00A7fBase Attack Damage multiplier from Skill: 1"));
			}
		}
	}
}
