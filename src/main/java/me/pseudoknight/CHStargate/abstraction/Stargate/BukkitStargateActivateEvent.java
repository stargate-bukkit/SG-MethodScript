package me.pseudoknight.CHStargate.abstraction.Stargate;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import me.pseudoknight.CHStargate.abstraction.MSStargateActivateEvent;
import net.TheDgtl.Stargate.event.StargateActivateEvent;

public class BukkitStargateActivateEvent extends BukkitStargateEvent implements MSStargateActivateEvent{
    StargateActivateEvent event;
    public BukkitStargateActivateEvent(StargateActivateEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public List<String> getDestinations() {
        return event.getDestinations();
    }

    @Override
    public void setDestinations(@NotNull List<String> destinations) {
        event.setDestinations(destinations);
    }

    @Override
    public String getDestination() {
        return event.getDestination();
    }

    @Override
    public void setDestination(String destination) {
        event.setDestination(destination);
    }
    
}
