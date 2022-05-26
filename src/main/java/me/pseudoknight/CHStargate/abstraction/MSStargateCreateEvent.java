package me.pseudoknight.CHStargate.abstraction;

import com.laytonsmith.abstraction.MCEntity;

public interface MSStargateCreateEvent extends MSStargateEvent{
    String getLine(int index);
    boolean getDeny();
    void setDeny(boolean deny);
    String getDenyReason();
    MCEntity getActor();
    void setDenyReason(String denyReason);
    int getCost();
    public void setCost(int cost);
}
