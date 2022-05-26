package me.pseudoknight.CHStargate.abstraction.Stargate;

import com.laytonsmith.abstraction.Implementation;
import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.bukkit.entities.BukkitMCEntity;
import com.laytonsmith.annotations.abstraction;

import me.pseudoknight.CHStargate.abstraction.MSStargateDestroyEvent;
import me.pseudoknight.CHStargate.abstraction.Stargate.BukkitStargateEvent;
import net.TheDgtl.Stargate.event.StargateDestroyEvent;

@abstraction(type = Implementation.Type.BUKKIT)
public class BukkitStargateDestroyEvent extends BukkitStargateEvent implements MSStargateDestroyEvent {

	private final StargateDestroyEvent e;

	public BukkitStargateDestroyEvent(StargateDestroyEvent event) {
		super(event);
		e = event;
	}

	@Override
	public MCEntity getActor() {
		return new BukkitMCEntity(e.getEntity());
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
	public String getDenyReason() {
		return e.getDenyReason();
	}

	@Override
	public void setDenyReason(String denyReason) {
		e.setDenyReason(denyReason);
	}

	@Override
	public int getCost() {
		return e.getCost();
	}

	@Override
	public void setCost(int cost) {
		e.setCost(cost);
	}

}