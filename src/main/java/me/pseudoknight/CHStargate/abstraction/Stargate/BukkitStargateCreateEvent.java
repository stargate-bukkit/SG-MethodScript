package me.pseudoknight.CHStargate.abstraction.Stargate;

import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.bukkit.entities.BukkitMCEntity;

import me.pseudoknight.CHStargate.abstraction.MSStargateCreateEvent;
import net.TheDgtl.Stargate.event.StargateCreateEvent;

public class BukkitStargateCreateEvent extends BukkitStargateEvent implements MSStargateCreateEvent{
    StargateCreateEvent event;
    public BukkitStargateCreateEvent(StargateCreateEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public String getLine(int index) {
        return event.getLine(index);
    }

    @Override
    public boolean getDeny() {
        return event.getDeny();
    }

    @Override
    public void setDeny(boolean deny) {
        event.setDeny(deny);
    }

    @Override
    public String getDenyReason() {
        return event.getDenyReason();
    }

    @Override
    public void setDenyReason(String denyReason) {
        event.setDenyReason(denyReason);
    }

    @Override
    public int getCost() {
        return event.getCost();
    }

    @Override
    public void setCost(int cost) {
        event.setCost(cost);
    }

    @Override
    public MCEntity getActor() {
        return new BukkitMCEntity(event.getEntity());
    }

}
