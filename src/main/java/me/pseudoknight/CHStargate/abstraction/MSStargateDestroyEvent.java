package me.pseudoknight.CHStargate.abstraction;

import com.laytonsmith.abstraction.MCEntity;

public interface MSStargateDestroyEvent extends MSStargateEvent {

	MCEntity getActor();
	boolean getDeny();
	void setDeny(boolean deny);
	String getDenyReason();
	void setDenyReason(String denyReason);
	int getCost();
	void setCost(int cost);

}
