package me.pseudoknight.CHStargate.abstraction.Stargate;

import com.laytonsmith.abstraction.Implementation;
import com.laytonsmith.annotations.abstraction;

import me.pseudoknight.CHStargate.abstraction.MSStargateEvent;
import net.TheDgtl.Stargate.event.StargateEvent;
import net.TheDgtl.Stargate.network.portal.Portal;

@abstraction(type = Implementation.Type.BUKKIT)
public class BukkitStargateEvent implements MSStargateEvent {

	private final StargateEvent e;

	public BukkitStargateEvent(StargateEvent event) {
		e = event;
	}

	@Override
	public Object _GetObject() {
		return e;
	}

	@Override
	public Portal getPortal() {
		return e.getPortal();
	}

}