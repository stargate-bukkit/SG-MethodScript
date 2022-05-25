package me.pseudoknight.CHStargate.abstraction;

public interface MSStargateCreateEvent extends MSStargateEvent{
    String getLine(int index);
    boolean geetDeny();
    void setDeny(boolean deny);
    String getDenyReason();
    void setDenyReason(String denyReason);
    int getCost();
    public void setCost(int cost);
}
