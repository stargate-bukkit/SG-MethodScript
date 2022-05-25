package me.pseudoknight.CHStargate.abstraction.Stargate;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.bukkit.BukkitMCLocation;
import com.laytonsmith.abstraction.bukkit.entities.BukkitMCEntity;

import me.pseudoknight.CHStargate.abstraction.MSStargatePortalEvent;
import net.TheDgtl.Stargate.event.StargatePortalEvent;

public class BukkitStargatePortalEvent extends BukkitStargateEvent implements MSStargatePortalEvent{
    StargatePortalEvent event;
    public BukkitStargatePortalEvent(StargatePortalEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public MCEntity getActor() {
        return new BukkitMCEntity(event.getEntity());
    }

    @Override
    public MCLocation getExit() {
        Location loc = event.getExit();
        return new BukkitMCLocation(loc);
    }

    @Override
    public void setExit(MCLocation exitpoint) {
        World world = Bukkit.getServer().getWorld(exitpoint.getWorld().getName());
        event.setExit(new Location(world,exitpoint.getX(),exitpoint.getY(),exitpoint.getZ()));
    }

}
