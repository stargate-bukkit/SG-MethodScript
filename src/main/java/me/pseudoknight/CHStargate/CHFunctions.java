package me.pseudoknight.CHStargate;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.abstraction.bukkit.BukkitMCLocation;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.MSVersion;
import com.laytonsmith.core.ObjectGenerator;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.constructs.CArray;
import com.laytonsmith.core.constructs.CBoolean;
import com.laytonsmith.core.constructs.CNull;
import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.Environment;
import com.laytonsmith.core.exceptions.CRE.CREFormatException;
import com.laytonsmith.core.exceptions.CRE.CRENotFoundException;
import com.laytonsmith.core.exceptions.CRE.CREThrowable;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.core.functions.AbstractFunction;
import com.laytonsmith.core.natives.interfaces.Mixed;

import net.TheDgtl.Stargate.gate.GateAPI;
import net.TheDgtl.Stargate.gate.structure.GateStructureType;
import net.TheDgtl.Stargate.network.Network;
import net.TheDgtl.Stargate.network.portal.BlockLocation;
import net.TheDgtl.Stargate.network.portal.Portal;
import net.TheDgtl.Stargate.network.portal.PortalFlag;
import net.TheDgtl.Stargate.network.portal.PortalPosition;
import net.TheDgtl.Stargate.network.portal.RealPortal;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class CHFunctions {
	public static String docs() {
		return "These functions allow you to interface with Stargate portals.";
	}

	protected static abstract class StargateFunction extends AbstractFunction {
		@Override
		public boolean isRestricted() {
			return true;
		}

		@Override
		public Boolean runAsync() {
			return false;
		}

		@Override
		public Class<? extends CREThrowable>[] thrown() {
			return new Class[]{CRENotFoundException.class};
		}
	}

	@api
	public static class sg_get_owner_name extends StargateFunction {
		@Override
		public String getName() {
			return "sg_get_owner_name";
		}

		@Override
		public String docs() {
			return "string {portalName, portalNetwork} Returns the portal's owner name."
					+ " Will return null if the portal does not have an owner."
					+ " Throws NotFoundException if a portal was not found by that name on the specified network.";
		}

		@Override
		public Integer[] numArgs() {
			return new Integer[]{2};
		}

		@Override
		public Mixed exec(Target t, Environment environment, Mixed... args) throws ConfigRuntimeException {
		    Network net = CHStargate.stargateAPI.getRegistry().getNetwork(args[1].val(), false);
            Portal portal = net.getPortal(args[0].val());
			String owner = "";
			if (portal != null) {
				owner = Bukkit.getOfflinePlayer(portal.getOwnerUUID()).getName();
			} else {
				throw new CRENotFoundException("Portal was not found.", t);
			}
			if(owner.equals("")) {
				return CNull.NULL;
			}
			return new CString(owner, t);
		}

		@Override
		public Version since() {
			return MSVersion.V3_3_4;
		}
	}

	@api
	public static class sg_get_owner_uuid extends StargateFunction {
		@Override
		public String getName() {
			return "sg_get_owner_uuid";
		}

		@Override
		public String docs() {
			return "string {portalName, portalNetwork} Returns the portal's owner UUID."
					+ " Will return null if there's no owner UUID for this portal."
					+ " being an unowned portal or a legacy portal stored with a player name."
					+ " Throws NotFoundException if a portal was not found by that name on the specified network.";
		}

		@Override
		public Integer[] numArgs() {
			return new Integer[]{2};
		}

		@Override
		public Mixed exec(Target t, Environment environment, Mixed... args) throws ConfigRuntimeException {
		    Network net = CHStargate.stargateAPI.getRegistry().getNetwork(args[1].val(), false);
			Portal portal = net.getPortal(args[0].val());
			UUID owner = null;
			if (portal != null) {
				owner = portal.getOwnerUUID();
			} else {
				throw new CRENotFoundException("Portal was not found.", t);
			}
			if(owner == null) {
				return CNull.NULL;
			}
			return new CString(owner.toString(), t);
		}

		@Override
		public Version since() {
			return MSVersion.V3_3_4;
		}
	}

	@api
	public static class sg_set_owner extends StargateFunction {
		@Override
		public String getName() {
			return "sg_set_owner";
		}

		@Override
		public String docs() {
			return "boolean {portalName, portalNetwork, owner} Sets the portal's owner name."
					+ " Accepts UUID or player name, though the former is preferred."
					+ " Throws NotFoundException if a portal was not found by that name on the specified network.";
		}

		@Override
		public Integer[] numArgs() {
			return new Integer[]{3};
		}

		@Override
		public Mixed exec(Target t, Environment environment, Mixed... args) throws ConfigRuntimeException {
		    Network net = CHStargate.stargateAPI.getRegistry().getNetwork(args[1].val(), false);
            Portal portal = net.getPortal(args[0].val());
			String owner = args[2].val();
			if (portal == null) {
				throw new CRENotFoundException("Portal was not found.", t);
			}
			if(owner.length() > 16) {
				try {
					portal.setOwner(UUID.fromString(owner));
				} catch(IllegalArgumentException ex) {
					throw new CREFormatException("Invalid UUID format.", t);
				}
			} else {
				portal.setOwner(Static.getServer().getOfflinePlayer(owner).getUniqueID());
			}
			return CBoolean.TRUE;
		}

		@Override
		public Version since() {
			return MSVersion.V3_3_1;
		}

		@Override
		public Class<? extends CREThrowable>[] thrown() {
			return new Class[]{CRENotFoundException.class, CREFormatException.class};
		}
	}

	@api
	public static class sg_get_portal_info extends StargateFunction {
		@Override
		public String getName() {
			return "sg_get_portal_info";
		}

		@Override
		public String docs() {
			return "array {portalName, portalNetwork} Gets an array of data about a specific Stargate portal."
					+ " Throws NotFoundException if a portal was not found by that name on the specified network.";
		}

		@Override
		public Integer[] numArgs() {
			return new Integer[]{2};
		}

		@Override
		public Mixed exec(Target t, Environment environment, Mixed... args) throws ConfigRuntimeException {
		    Network net = CHStargate.stargateAPI.getRegistry().getNetwork(args[1].val(), false);
            Portal portal = net.getPortal(args[0].val());
			if (portal == null) {
				throw new CRENotFoundException("Portal was not found.", t);
			}
			
			    

			CArray arr = CArray.GetAssociativeArray(t);

			Portal destination = portal.getDestination();
			if(destination == null) {
				arr.set("destination", CNull.NULL, t);
			} else {
				arr.set("destination", new CString(portal.getDestination().getName(), t), t);
			}

			

			CArray options = CArray.GetAssociativeArray(t);
			options.set("alwaysOn", CBoolean.get(portal.hasFlag(PortalFlag.ALWAYS_ON)), t);
			options.set("backwards", CBoolean.get(portal.hasFlag(PortalFlag.BACKWARDS)), t);
			options.set("free", CBoolean.get(portal.hasFlag(PortalFlag.FREE)), t);
			options.set("hidden", CBoolean.get(portal.hasFlag(PortalFlag.HIDDEN)), t);
			options.set("noNetwork", CBoolean.get(portal.hasFlag(PortalFlag.HIDE_NETWORK)), t);
			options.set("private", CBoolean.get(portal.hasFlag(PortalFlag.PRIVATE)), t);
			options.set("random", CBoolean.get(portal.hasFlag(PortalFlag.RANDOM)), t);
			options.set("show", CBoolean.get(portal.hasFlag(PortalFlag.FORCE_SHOW)), t);
			arr.set("options", options, t);

			UUID ownerUUID = portal.getOwnerUUID();
			if(ownerUUID == null) {
				arr.set("ownerUUID", CNull.NULL, t);
			} else {
				arr.set("ownerUUID", ownerUUID.toString(), t);
			}
			String ownerName = Bukkit.getOfflinePlayer(ownerUUID).getName();
			if(ownerName.equals("")) {
				arr.set("ownerName", CNull.NULL, t);
			} else {
				arr.set("ownerName", ownerName, t);
			}
			
			if(!(portal instanceof RealPortal)) {
	            return arr;
			}
			RealPortal realPortal = (RealPortal) portal;
			GateAPI gate = realPortal.getGate();
			List<PortalPosition> portalPositions = gate.getPortalPositions();
			//TODO does not support multiple signs / equivalent controlblocks
			for(PortalPosition portalPosition : portalPositions) {
			    Location loc = gate.getLocation(portalPosition.getPositionLocation());
			    arr.set(portalPosition.getPositionType().toString().toLowerCase(), ObjectGenerator.GetGenerator().location(new BukkitMCLocation(loc), false), t);
			}
			CArray frame = new CArray(t);
            for(BlockLocation b : gate.getLocations(GateStructureType.FRAME)) {
                frame.push(ObjectGenerator.GetGenerator().location(new BukkitMCLocation(new BukkitMCLocation(b.getLocation())), false), t);
            }
            arr.set("frame", frame, t);

            CArray entrance = new CArray(t);
            for(BlockLocation b : gate.getLocations(GateStructureType.IRIS)) {
                entrance.push(ObjectGenerator.GetGenerator().location(new BukkitMCLocation(new BukkitMCLocation(b.getLocation())), false), t);
            }
            arr.set("entrance", entrance, t);
			return arr;
		}

		@Override
		public Version since() {
			return MSVersion.V3_3_4;
		}
	}

}
