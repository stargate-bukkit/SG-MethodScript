package me.pseudoknight.CHStargate;

import java.util.HashMap;
import java.util.Map;

import com.laytonsmith.annotations.api;
import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.events.BindableEvent;
import com.laytonsmith.core.events.Prefilters;
import com.laytonsmith.core.exceptions.EventException;
import com.laytonsmith.core.exceptions.PrefilterNonMatchException;
import com.laytonsmith.core.natives.interfaces.Mixed;

import me.pseudoknight.CHStargate.abstraction.MSStargateDestroyEvent;

@api
public class stargate_destroy extends StargateEvent {

	@Override
	public String getName() {
		return "stargate_destroy";
	}

	@Override
	public String docs() {
		return "{deny: <boolean> Whether access was denied or not. }"
				+ " Fired when a block of a Stargate portal is broken."
				+ " {actorUUID: The entity that broke the block. | portal: The Stargate portal's name."
				+ " | network: The Stargate network this portal belongs to.}"
				+ "{} "
				+ " {}";
	}

	@Override
	public boolean matches(Map<String, Mixed> prefilter, BindableEvent e) throws PrefilterNonMatchException {
		Prefilters.match(prefilter, "deny", ((MSStargateDestroyEvent) e).getDeny(), Prefilters.PrefilterType.BOOLEAN_MATCH);
		return true;
	}

	@Override
	public Map<String, Mixed> evaluate(BindableEvent event) throws EventException {
		MSStargateDestroyEvent e = (MSStargateDestroyEvent) event;
		Map<String, Mixed> map = new HashMap<>();
		map.put("portal", new CString(e.getPortal().getName(), Target.UNKNOWN));
		map.put("network", new CString(e.getPortal().getNetwork().getName(), Target.UNKNOWN));
        map.put("actorUUID", new CString(e.getActor().getUniqueId().toString(), Target.UNKNOWN));
        return map;
	}

	@Override
	public boolean modifyEvent(String key, Mixed value, BindableEvent event) {
		return false;
	}

	@Override
	public void cancel(BindableEvent e, boolean state) {
		((MSStargateDestroyEvent) e).setDeny(state);
	}
}