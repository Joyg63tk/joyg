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
import net.joyg.configuration.JoygCfgConfiguration;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class KarmadameTtProcedure {
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
		if (itemstack.getItem() == JoygModItems.KARMADAME.get()) {
			tooltip.add(Component.literal("Hold \u00A7eShift \u00A7fto show more"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("Your \u00A7cKarma \u00A7flevel is shown above your XP level"));
				tooltip.add(Component.literal("Your \u00A7cKarma \u00A7flevel increases your game difficulty but also grants rewards"));
				tooltip.add(Component.literal(("+\u00A76Looting \u00A7flvl per \u00A76" + new java.text.DecimalFormat("###").format((double) JoygCfgConfiguration.LOOTING.get()) + " \u00A7cKarma")));
				tooltip.add(Component.literal(("+\u00A73Fortune \u00A7flvl per \u00A73" + new java.text.DecimalFormat("###").format((double) JoygCfgConfiguration.FORTUNE.get()) + " \u00A7cKarma")));
				tooltip.add(Component.literal(("+\u00A7aLuck \u00A7flvl per \u00A7a" + new java.text.DecimalFormat("###").format((double) JoygCfgConfiguration.LUCK.get()) + " \u00A7cKarma")));
				tooltip.add(Component.literal(" "));
				tooltip.add(Component.literal(("You take \u00A7c" + new java.text.DecimalFormat("###").format((double) JoygCfgConfiguration.KARMADMG.get() * 100) + "% additional \u00A7cDamage \u00A7fper \u00A7cKarma \u00A7flvl")));
				tooltip.add(Component.literal("You have an increasing chance with each \u00A7cKarma \u00A7flvl to be inflicted with negative effects when you take damage"));
				tooltip.add(Component.literal(("-Slowness can be applied starting from \u00A7cKarma \u00A7flvl:" + new java.text.DecimalFormat("###").format((double) JoygCfgConfiguration.SLOWNESS.get()))));
				tooltip.add(Component.literal(("-Weakness can be applied starting from \u00A7cKarma \u00A7flvl:" + new java.text.DecimalFormat("###").format((double) JoygCfgConfiguration.WEAKNESS.get()))));
				tooltip.add(Component.literal(("-Poison can be applied starting from \u00A7cKarma \u00A7flvl:" + new java.text.DecimalFormat("###").format((double) JoygCfgConfiguration.POISON.get()))));
				tooltip.add(Component.literal(("-Bleed can be applied starting from \u00A7cKarma \u00A7flvl:" + new java.text.DecimalFormat("###").format((double) JoygCfgConfiguration.BLEED.get()))));
			}
		}
	}
}
