package me.pseudoknight.CHStargate;

import java.util.HashMap;
import java.util.Map;

import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.MSVersion;
import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.events.BindableEvent;
import com.laytonsmith.core.exceptions.EventException;
import com.laytonsmith.core.exceptions.PrefilterNonMatchException;
import com.laytonsmith.core.natives.interfaces.Mixed;

import me.pseudoknight.CHStargate.abstraction.MSStargateOpenEvent;

@api
public class stargate_open extends StargateEvent {

	@Override
	public String getName() {
		return "stargate_open";
	}

	@Override
	public String docs() {
		return "{} "
				+ "Fired when a Stargate portal is opened."
				+ " {actorUUID: The entity opening the portal, if one. | portal: The Stargate portal's name."
				+ " | network: The Stargate network this portal belongs to.}"
				+ "{} "
				+ "{} ";
	}

	@Override
	public boolean matches(Map<String, Mixed> prefilter, BindableEvent event) throws PrefilterNonMatchException {
		return true;
	}

	@Override
	public Map<String, Mixed> evaluate(BindableEvent event) throws EventException {
		MSStargateOpenEvent e = (MSStargateOpenEvent) event;
		Map<String, Mixed> map = new HashMap<>();
		MCEntity p = e.getActor();
		if(p != null) {
			map.put("actorUUID", new CString(e.getActor().getUniqueId().toString(), Target.UNKNOWN));
		}
		map.put("portal", new CString(e.getPortal().getName(), Target.UNKNOWN));
		map.put("network", new CString(e.getPortal().getNetwork().getName(), Target.UNKNOWN));
		return map;
	}

	@Override
	public boolean modifyEvent(String key, Mixed value, BindableEvent event) {
		return false;
	}

	@Override
	public MSVersion since() {
		return MSVersion.V3_3_2;
	}
}