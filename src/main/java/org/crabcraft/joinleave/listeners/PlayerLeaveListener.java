package org.crabcraft.joinleave.listeners;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.text.Text;

public class PlayerLeaveListener implements EventListener<ClientConnectionEvent.Disconnect> {

    private Logger logger;

    @Override
    public void handle(ClientConnectionEvent.Disconnect event) throws Exception {
        Player player = event.getTargetEntity();
        event.clearMessage();

        String playerLeaveBroadcast = String.format("%s has left the CrabCraft server! Come back soon!", player.getName());

        Sponge.getServer().getBroadcastChannel().send(Text.of(playerLeaveBroadcast));
    }
}
