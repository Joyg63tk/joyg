
package net.joyg.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;

import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

@Mod.EventBusSubscriber
public class SacCmdCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("joyg").requires(s -> s.hasPermission(4)).then(Commands.literal("cast").then(Commands.literal("righteous_sacrifice").then(Commands.argument("name", EntityArgument.player())))));
	}
}
