package me.pseudoknight.CHStargate.abstraction.Stargate;

import me.pseudoknight.CHStargate.abstraction.MSStargateCloseEvent;
import net.TheDgtl.Stargate.event.StargateCloseEvent;

public class BukkitStargateCloseEvent extends BukkitStargateEvent implements MSStargateCloseEvent{
    StargateCloseEvent event;
    public BukkitStargateCloseEvent(StargateCloseEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public boolean getForce() {
        return event.getForce();
    }

    @Override
    public void setForce(boolean force) {
        event.setForce(force);
    }

}
