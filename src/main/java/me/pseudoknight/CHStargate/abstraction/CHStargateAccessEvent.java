package me.pseudoknight.CHStargate.abstraction;

import com.laytonsmith.abstraction.MCEntity;

public interface CHStargateAccessEvent extends CHStargateEvent {

	boolean getDeny();
	void setDeny(boolean deny);
	MCEntity getActor();

}