package me.pseudoknight.CHStargate.abstraction;

import com.laytonsmith.abstraction.MCPlayer;

public interface CHStargateAccessEvent extends CHStargateEvent {

	boolean getDeny();
	void setDeny(boolean deny);
	MCPlayer getPlayer();

}