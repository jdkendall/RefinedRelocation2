package net.blay09.mods.refinedrelocation.network;

import net.blay09.mods.refinedrelocation.RefinedRelocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import javax.annotation.Nullable;

public class HandlerOpenGui implements IMessageHandler<MessageOpenGui, IMessage> {

	@Override
	@Nullable
	public IMessage onMessage(final MessageOpenGui message, final MessageContext ctx) {
		RefinedRelocation.proxy.addScheduledTask(new Runnable() {
			@Override
			public void run() {
				if(ctx.side == Side.CLIENT) {
					RefinedRelocation.proxy.openGui(NetworkHandler.getClientPlayerEntity(), message);
				} else {
					RefinedRelocation.proxy.openGui(ctx.getServerHandler().playerEntity, message);
				}
			}
		});
		return null;
	}

}
