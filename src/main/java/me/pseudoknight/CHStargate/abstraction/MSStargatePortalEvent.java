package me.pseudoknight.CHStargate.abstraction;

import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.MCLocation;

public interface MSStargatePortalEvent extends MSStargateEvent{
    MCEntity getActor();
    MCLocation getExit();
    void setExit(MCLocation exitpoint);
}
