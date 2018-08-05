package org.crabcraft.joinleave;

import com.google.inject.Inject;
import org.crabcraft.joinleave.listeners.PlayerJoinListener;
import org.crabcraft.joinleave.listeners.PlayerLeaveListener;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.EventListener;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "joinleave",
        name = "JoinLeave",
        description = "Custom join/leave broadcasts and messages when players join/leave",
        version = "1.0.0",
        authors = {
                "Crablet"
        }
)
public class JoinLeave {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("CrabCraft - JoinLeave: Reporting for duty!");

        EventListener<ClientConnectionEvent.Join> playerJoinListener = new PlayerJoinListener();
        Sponge.getEventManager().registerListener(this, ClientConnectionEvent.Join.class, playerJoinListener);

        EventListener<ClientConnectionEvent.Disconnect> playerLeaveListener = new PlayerLeaveListener();
        Sponge.getEventManager().registerListener(this, ClientConnectionEvent.Disconnect.class, playerLeaveListener);
    }
}
