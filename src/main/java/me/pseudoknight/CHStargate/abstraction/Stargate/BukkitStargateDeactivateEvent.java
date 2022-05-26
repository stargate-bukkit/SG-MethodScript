package me.pseudoknight.CHStargate.abstraction.Stargate;

import com.laytonsmith.abstraction.MCEntity;

import me.pseudoknight.CHStargate.abstraction.MSStargateDeactivateEvent;
import net.TheDgtl.Stargate.event.StargateDeactivateEvent;

public class BukkitStargateDeactivateEvent extends BukkitStargateEvent implements MSStargateDeactivateEvent{
public BukkitStargateDeactivateEvent(StargateDeactivateEvent event) {
        super(event);
    }

}
