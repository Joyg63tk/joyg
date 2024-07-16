package net.joyg.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WandRepProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onEventTriggered(AnvilUpdateEvent event) {
		execute(event, event.getLeft(), event.getRight());
	}

	public static void execute(ItemStack leftItem, ItemStack rightItem) {
		execute(null, leftItem, rightItem);
	}

	private static void execute(@Nullable Event event, ItemStack leftItem, ItemStack rightItem) {
		ItemStack op = ItemStack.EMPTY;
		if (leftItem.is(ItemTags.create(new ResourceLocation("joyg:wands"))) && rightItem.getItem() == Items.AMETHYST_SHARD) {
			if (leftItem.isDamaged()) {
				if (rightItem.getCount() >= 1) {
					if (event instanceof AnvilUpdateEvent _anvil) {
						_anvil.setCost(1);
					}
					if (event instanceof AnvilUpdateEvent _anvil) {
						_anvil.setMaterialCost(1);
					}
					op = (leftItem.copy());
					op.setDamageValue((int) (leftItem.getDamageValue() - leftItem.getMaxDamage() / 3));
					if (event instanceof AnvilUpdateEvent _anvil) {
						_anvil.setOutput(op);
					}
				}
				if (leftItem.getDamageValue() >= leftItem.getMaxDamage() * 0.33 && rightItem.getCount() >= 2) {
					if (event instanceof AnvilUpdateEvent _anvil) {
						_anvil.setCost(2);
					}
					if (event instanceof AnvilUpdateEvent _anvil) {
						_anvil.setMaterialCost(2);
					}
					op = (leftItem.copy());
					op.setDamageValue((int) (leftItem.getDamageValue() - leftItem.getMaxDamage() * 0.66));
					if (event instanceof AnvilUpdateEvent _anvil) {
						_anvil.setOutput(op);
					}
				}
				if (leftItem.getDamageValue() >= leftItem.getMaxDamage() * 0.66 && rightItem.getCount() >= 3) {
					if (event instanceof AnvilUpdateEvent _anvil) {
						_anvil.setCost(3);
					}
					if (event instanceof AnvilUpdateEvent _anvil) {
						_anvil.setMaterialCost(3);
					}
					op = (leftItem.copy());
					op.setDamageValue(0);
					if (event instanceof AnvilUpdateEvent _anvil) {
						_anvil.setOutput(op);
					}
				}
			}
		}
	}
}
