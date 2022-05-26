package me.pseudoknight.CHStargate;

import com.laytonsmith.core.MSVersion;
import com.laytonsmith.core.constructs.CArray;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.events.AbstractEvent;
import com.laytonsmith.core.events.BindableEvent;
import com.laytonsmith.core.events.Driver;

abstract class StargateEvent extends AbstractEvent {
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