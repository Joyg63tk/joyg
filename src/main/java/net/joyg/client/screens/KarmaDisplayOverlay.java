
package net.joyg.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.joyg.procedures.NumberoffsetProcedure;
import net.joyg.procedures.Numberoffset3Procedure;
import net.joyg.procedures.Numberoffset2Procedure;
import net.joyg.procedures.KarmaOverlayNumProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class KarmaDisplayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			if (NumberoffsetProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						KarmaOverlayNumProcedure.execute(entity), w / 2 + -3, h - 50, -65536, false);
			if (Numberoffset2Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						KarmaOverlayNumProcedure.execute(entity), w / 2 + -6, h - 50, -65536, false);
			if (Numberoffset3Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						KarmaOverlayNumProcedure.execute(entity), w / 2 + -9, h - 50, -65536, false);
		}
	}
}
