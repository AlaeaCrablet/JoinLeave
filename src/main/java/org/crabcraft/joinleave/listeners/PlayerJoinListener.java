package org.crabcraft.joinleave.listeners;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.text.Text;

public class PlayerJoinListener implements EventListener<ClientConnectionEvent.Join> {

    // private Logger logger;

    @Override
    public void handle(ClientConnectionEvent.Join event) throws Exception {
        Player player = event.getTargetEntity();
        event.clearMessage();

        String joinBroadcast = String.format("%s has joined the CrabCraft server! Welcome!", player.getName());
        String playerWelcome = String.format("Welcome to CrabCraft, %s!", player.getName());

        Sponge.getServer().getBroadcastChannel().send(Text.of(joinBroadcast));
        player.sendMessage(Text.of(playerWelcome));
    }
}
