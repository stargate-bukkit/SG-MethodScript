package me.pseudoknight.CHStargate;

import java.util.HashMap;
import java.util.Map;

import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.events.BindableEvent;
import com.laytonsmith.core.exceptions.EventException;
import com.laytonsmith.core.exceptions.PrefilterNonMatchException;
import com.laytonsmith.core.natives.interfaces.Mixed;

import me.pseudoknight.CHStargate.abstraction.MSStargatePortalEvent;

public class stargate_portal extends StargateEvent{
    @Override
    public String getName() {
        return "stargate_portal";
    }
    
    @Override
    public String docs() {
        return "{} "
                + "Fired when a entity teleports from a Stargate."
                + " {actorUUID: The entity teleporting. | portal: The Stargate portal's name."
                + " | network: The Stargate network this portal belongs to.}"
                + "{} "
                + "{} ";
    }

    @Override
    public Map<String, Mixed> evaluate(BindableEvent event) throws EventException {
        MSStargatePortalEvent e = (MSStargatePortalEvent) event;
        Map<String, Mixed> map = new HashMap<>();
        map.put("actorUUID", new CString(e.getActor().getUniqueId().toString(), Target.UNKNOWN));
        map.put("portal", new CString(e.getPortal().getName(), Target.UNKNOWN));
        map.put("network", new CString(e.getPortal().getNetwork().getName(), Target.UNKNOWN));
        return map;
    }

    

    @Override
    public boolean matches(Map<String, Mixed> prefilter, BindableEvent e) throws PrefilterNonMatchException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modifyEvent(String key, Mixed value, BindableEvent event) {
        // TODO Auto-generated method stub
        return false;
    }

}
