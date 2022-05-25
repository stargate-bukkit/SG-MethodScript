package me.pseudoknight.CHStargate.abstraction;

import com.laytonsmith.core.events.BindableEvent;

import net.TheDgtl.Stargate.network.portal.Portal;

public interface MSStargateEvent extends BindableEvent {

	Portal getPortal();

}