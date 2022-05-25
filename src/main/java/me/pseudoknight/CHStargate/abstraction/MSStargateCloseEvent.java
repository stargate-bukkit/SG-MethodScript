package me.pseudoknight.CHStargate.abstraction;

public interface MSStargateCloseEvent extends MSStargateEvent {
    boolean getForce();
    void setForce(boolean force);
}
