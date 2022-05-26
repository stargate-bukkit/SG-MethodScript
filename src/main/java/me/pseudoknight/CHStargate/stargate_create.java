package me.pseudoknight.CHStargate;

import java.util.HashMap;
import java.util.Map;

import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.events.BindableEvent;
import com.laytonsmith.core.events.Prefilters;
import com.laytonsmith.core.exceptions.EventException;
import com.laytonsmith.core.exceptions.PrefilterNonMatchException;
import com.laytonsmith.core.natives.interfaces.Mixed;

import me.pseudoknight.CHStargate.abstraction.MSStargateCreateEvent;

public class stargate_create extends StargateEvent{
    @Override
    public String getName() {
        return "stargate_create";
    }
    
    @Override
    public String docs() {
        return "{deny: <boolean> Whether access was denied or not. }"
                + " Fired when a Stargate portal is created."
                + " {actorUUID: The entity that created the portal. | portal: The Stargate portal's name."
                + " | network: The Stargate network this portal belongs to.}"
                + "{} "
                + " {}";
    }

    @Override
    public Map<String, Mixed> evaluate(BindableEvent event) throws EventException {
        MSStargateCreateEvent e = (MSStargateCreateEvent) event;
        Map<String, Mixed> map = new HashMap<>();;
        map.put("actorUUID", new CString(e.getActor().getUniqueId().toString(),Target.UNKNOWN));
        map.put("portal", new CString(e.getPortal().getName(), Target.UNKNOWN));
        map.put("network", new CString(e.getPortal().getNetwork().getName(), Target.UNKNOWN));
        return null;
    }

    

    @Override
    public boolean matches(Map<String, Mixed> prefilter, BindableEvent event) throws PrefilterNonMatchException {
        Prefilters.match(prefilter,"deny", ((MSStargateCreateEvent) event).getDeny(),Prefilters.PrefilterType.BOOLEAN_MATCH);
        return true;
    }

    @Override
    public boolean modifyEvent(String key, Mixed value, BindableEvent event) {
        return false;
    }
    
}
