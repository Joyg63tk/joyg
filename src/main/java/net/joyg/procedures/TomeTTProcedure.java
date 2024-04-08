package net.joyg.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class TomeTTProcedure {
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
		if (itemstack.is(ItemTags.create(new ResourceLocation("joyg:tomes")))) {
			if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).contains("leather")) {
				tooltip.add(Component.literal("10% increased Spell Damage while equipped in the Offhand"));
			}
			if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).contains("iron")) {
				tooltip.add(Component.literal("20% increased Spell Damage while equipped in the Offhand"));
			}
			if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).contains("gold")) {
				tooltip.add(Component.literal("30% increased Spell Damage while equipped in the Offhand"));
			}
			if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).contains("diamond")) {
				tooltip.add(Component.literal("40% increased Spell Damage while equipped in the Offhand"));
			}
			if ((ForgeRegistries.ITEMS.getKey(itemstack.getItem()).toString()).contains("netherite")) {
				tooltip.add(Component.literal("50% increased Spell Damage while equipped in the Offhand"));
			}
			tooltip.add(Component.literal("Melee Damage converted to Magic while weilding a Mace in your Mainhand"));
		}
	}
}
