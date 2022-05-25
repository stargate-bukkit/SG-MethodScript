package me.pseudoknight.CHStargate.abstraction.Stargate;

import com.laytonsmith.abstraction.Implementation;
import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.bukkit.entities.BukkitMCEntity;
import com.laytonsmith.annotations.abstraction;

import me.pseudoknight.CHStargate.abstraction.MSStargateAccessEvent;
import net.TheDgtl.Stargate.event.StargateAccessEvent;

@abstraction(type = Implementation.Type.BUKKIT)
public class BukkitStargateAccessEvent extends BukkitStargateEvent implements MSStargateAccessEvent {

	private final StargateAccessEvent e;

	public BukkitStargateAccessEvent(StargateAccessEvent event) {
		super(event);
		e = event;
	}

	@Override
	public Object _GetObject() {
		return e;
	}

	@Override
	public boolean getDeny() {
		return e.getDeny();
	}

	@Override
	public void setDeny(boolean deny) {
		e.setDeny(deny);
	}

	@Override
	public MCEntity getActor() {
		return new BukkitMCEntity(e.getEntity());
	}

}