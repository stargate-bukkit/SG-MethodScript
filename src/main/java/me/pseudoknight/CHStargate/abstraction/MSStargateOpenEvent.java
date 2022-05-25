package me.pseudoknight.CHStargate.abstraction;

import com.laytonsmith.abstraction.MCEntity;

public interface MSStargateOpenEvent extends MSStargateEvent {

	MCEntity getActor();
	boolean getForce();
	void setForce(boolean force);

}