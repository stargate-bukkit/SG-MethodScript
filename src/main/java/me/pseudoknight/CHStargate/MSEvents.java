package me.pseudoknight.CHStargate;

import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.MSVersion;
import com.laytonsmith.core.constructs.CArray;
import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.events.AbstractEvent;
import com.laytonsmith.core.events.BindableEvent;
import com.laytonsmith.core.events.Driver;
import com.laytonsmith.core.events.Prefilters;
import com.laytonsmith.core.exceptions.EventException;
import com.laytonsmith.core.exceptions.PrefilterNonMatchException;
import com.laytonsmith.core.natives.interfaces.Mixed;
import me.pseudoknight.CHStargate.abstraction.MSStargateAccessEvent;
import me.pseudoknight.CHStargate.abstraction.MSStargateDestroyEvent;
import me.pseudoknight.CHStargate.abstraction.MSStargateOpenEvent;
import net.TheDgtl.Stargate.network.portal.Portal;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class MSEvents {

	protected static abstract class StargateEvent extends AbstractEvent {
		@Override
		public Driver driver() {
			return Driver.EXTENSION;
		}

		@Override
		public MSVersion since() {
			return MSVersion.V3_3_1;
		}

		@Override
		public BindableEvent convert(CArray manualObject, Target t) {
			return null;
		}
	}

	@api
	public static class stargate_destroy extends StargateEvent {

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

	@api
	public static class stargate_access extends StargateEvent {

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
			Portal portal = e.getPortal();
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

	@api
	public static class stargate_open extends StargateEvent {

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

}
