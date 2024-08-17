
package sbs.ashie.thestoragedimension.network;

import sbs.ashie.thestoragedimension.world.inventory.CoreGUIMenu;
import sbs.ashie.thestoragedimension.procedures.EnterStorageWorldProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.FriendlyByteBuf;

import net.fabricmc.fabric.api.networking.v1.PacketSender;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class CoreGUIButtonMessage extends FriendlyByteBuf {
	public CoreGUIButtonMessage(int buttonID, int x, int y, int z) {
		super(Unpooled.buffer());
		writeInt(buttonID);
		writeInt(x);
		writeInt(y);
		writeInt(z);
	}

	public static void apply(MinecraftServer server, ServerPlayer entity, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
		int buttonID = buf.readInt();
		double x = buf.readInt();
		double y = buf.readInt();
		double z = buf.readInt();
		server.execute(() -> {
			Level world = entity.level();
			HashMap guistate = CoreGUIMenu.guistate;
			if (buttonID == 0) {

				EnterStorageWorldProcedure.execute(entity);
			}
		});
	}
}
