package me.pseudoknight.CHStargate.abstraction.Stargate;

import org.bukkit.entity.Entity;

import com.laytonsmith.abstraction.Implementation;
import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.bukkit.entities.BukkitMCEntity;
import com.laytonsmith.annotations.abstraction;

import me.pseudoknight.CHStargate.abstraction.MSStargateOpenEvent;
import net.TheDgtl.Stargate.event.StargateOpenEvent;

@abstraction(type = Implementation.Type.BUKKIT)
public class BukkitStargateOpenEvent extends BukkitStargateEvent implements MSStargateOpenEvent {

	private final StargateOpenEvent e;

	public BukkitStargateOpenEvent(StargateOpenEvent event) {
		super(event);
		e = event;
	}

	@Override
	public Object _GetObject() {
		return e;
	}

	@Override
	public MCEntity getActor() {
		Entity p = e.getEntity();
		if(p == null) {
			return null;
		}
		return new BukkitMCEntity(p);
	}

	@Override
	public boolean getForce() {
		return e.getForce();
	}

	@Override
	public void setForce(boolean force) {
		e.setForce(force);
	}

}