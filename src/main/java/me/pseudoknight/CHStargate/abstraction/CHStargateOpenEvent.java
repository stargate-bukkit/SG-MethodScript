package me.pseudoknight.CHStargate.abstraction;

import com.laytonsmith.abstraction.MCEntity;

public interface CHStargateOpenEvent extends CHStargateEvent {

	MCEntity getActor();
	boolean getForce();
	void setForce(boolean force);

}