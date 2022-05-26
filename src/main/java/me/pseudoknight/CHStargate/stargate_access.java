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

import me.pseudoknight.CHStargate.abstraction.MSStargateAccessEvent;
import net.TheDgtl.Stargate.network.portal.Portal;

@api
public class stargate_access extends StargateEvent {

	@Override
	public String getName() {
		return "stargate_access";
	}

	@Override
	public String docs() {
		return "{<boolean> deny: Whether access was denied or not. } "
				+ "Fired when a player interacts with a Stargate. Result determines access."
				+ " {actorUUID: The entity requesting access. | portal: The Stargate portal's name."
				+ " | network: The Stargate network this portal belongs to.}"
				+ "{} "
				+ "{} ";
	}

	@Override
	public boolean matches(Map<String, Mixed> prefilter, BindableEvent e) throws PrefilterNonMatchException {
		Prefilters.match(prefilter, "deny", ((MSStargateAccessEvent) e).getDeny(), Prefilters.PrefilterType.BOOLEAN_MATCH);
		return true;
	}

	@Override
	public Map<String, Mixed> evaluate(BindableEvent event) throws EventException {
		MSStargateAccessEvent e = (MSStargateAccessEvent) event;
		Map<String, Mixed> map = new HashMap<>();
		map.put("actorUUID", new CString(e.getActor().getUniqueId().toString(), Target.UNKNOWN));
		map.put("portal", new CString(e.getPortal().getName(), Target.UNKNOWN));
		map.put("network", new CString(e.getPortal().getNetwork().getName(), Target.UNKNOWN));
		return map;
	}

	@Override
	public boolean modifyEvent(String key, Mixed value, BindableEvent event) {
		return false;
	}

	@Override
	public void cancel(BindableEvent e, boolean state) {
		((MSStargateAccessEvent) e).setDeny(state);
	}
}