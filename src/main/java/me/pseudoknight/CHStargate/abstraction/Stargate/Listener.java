package me.pseudoknight.CHStargate.abstraction.Stargate;

import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.events.EventUtils;
import com.laytonsmith.core.events.Driver;
import net.TheDgtl.Stargate.event.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class Listener implements org.bukkit.event.Listener {

	private static Listener sgl;

	public static void register() {
		if(sgl == null) {
			sgl = new Listener();
		}
		CommandHelperPlugin.self.registerEvents(sgl);
	}

	public static void unregister() {
		StargateDestroyEvent.getHandlerList().unregister(sgl);
		StargateAccessEvent.getHandlerList().unregister(sgl);
		StargateOpenEvent.getHandlerList().unregister(sgl);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onStargateDestroy(StargateDestroyEvent event) {
		EventUtils.TriggerListener(Driver.EXTENSION, "stargate_destroy", new BukkitStargateDestroyEvent(event));
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onStargateAccess(StargateAccessEvent event) {
		EventUtils.TriggerListener(Driver.EXTENSION, "stargate_access", new BukkitStargateAccessEvent(event));
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onStargateOpen(StargateOpenEvent event) {
		EventUtils.TriggerListener(Driver.EXTENSION, "stargate_open", new BukkitStargateOpenEvent(event));
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onStargateDeactivate(StargateDeactivateEvent event) {
	    EventUtils.TriggerListener(Driver.EXTENSION, "stargate_deactivate", new BukkitStargateDeactivateEvent(event));
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
    public void onStargateClose(StargateCloseEvent event) {
        EventUtils.TriggerListener(Driver.EXTENSION, "stargate_close", new BukkitStargateCloseEvent(event));
    }
	
	@EventHandler(priority = EventPriority.LOWEST)
    public void onStargateActivate(StargateActivateEvent event) {
        EventUtils.TriggerListener(Driver.EXTENSION, "stargate_activate", new BukkitStargateActivateEvent(event));
    }
	
	@EventHandler(priority = EventPriority.LOWEST)
    public void onStargatePortal(StargatePortalEvent event) {
        EventUtils.TriggerListener(Driver.EXTENSION, "stargate_portal", new BukkitStargatePortalEvent(event));
    }
	
	@EventHandler(priority = EventPriority.LOWEST)
    public void onStargateCreate(StargateCreateEvent event) {
        EventUtils.TriggerListener(Driver.EXTENSION, "stargate_create", new BukkitStargateCreateEvent(event));
    }

}
