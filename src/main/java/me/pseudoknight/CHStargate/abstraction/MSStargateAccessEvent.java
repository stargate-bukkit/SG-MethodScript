package me.pseudoknight.CHStargate.abstraction;

import com.laytonsmith.abstraction.MCEntity;

public interface MSStargateAccessEvent extends MSStargateEvent {

	boolean getDeny();
	void setDeny(boolean deny);
	MCEntity getActor();

}