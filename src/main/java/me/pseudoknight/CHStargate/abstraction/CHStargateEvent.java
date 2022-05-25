package me.pseudoknight.CHStargate.abstraction;

import com.laytonsmith.core.events.BindableEvent;

import net.TheDgtl.Stargate.network.portal.Portal;

public interface CHStargateEvent extends BindableEvent {

	Portal getPortal();

}