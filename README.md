> !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!<br>
>            THIS VERSION IS **EXPERIMENTAL**.<br>
>       It is designed to work with **ALPHA** builds of SG<br><br>
>  SG alpha jars are distributed via [the tester program](https://discord.gg/mTaHuK6BVa).<br>
> !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!<br>

__**Important Links**__
- [Upstream](https://github.com/PseudoKnight/CHStargate/issues)
- [Stargate discord](https://discord.gg/mTaHuK6BVa).
- [MethodScript discord](https://discord.gg/Z7jpHed)
- [Support MethodScript](https://github.com/sponsors/LadyCailin)

## Dependencies
- [The most recent version of Stargate](https://dev.bukkit.org/projects/stargate/files)
- [The most revent version of CommandHelper](https://methodscript.com/docs/3.3.5//Download.html)

# Description
An addon for the Stargate-Bukkit plugin. Creates an interface for [CommandHelper](https://enginehub.org/commandhelper/) (part of [MethodScript](https://discord.gg/Z7jpHed)). 

## Features:
### Functions

* string **sg_get_owner_name(portalName, portalNetwork)** Returns the portal's owner's name.
* string **sg_get_owner_uuid(portalName, portalNetwork)** Returns the portal's owner's UUID.
* boolean **sg_set_owner(portalName, portalNetwork, owner)** Sets the portal's owner.
* array **sg_get_portal_info(portalName, portalNetwork)** Returns an array of data about a specific portal.

### Events
#### stargate_access
Fired when a player interacts with a stargate.

* returns: *boolean* `deny` (Whether access was denied or not.)
* data: `actorUUID` The entity requesting access; `portal`, the portal's name; `network`, the network this portal belongs to.

#### stargate_close
Fired when a stargate closes.

* returns: *null*
* data: `is_force`, Whether the portal's closure was forced; `portal`, the portal's name; `network`, the network this portal belongs to.

#### stargate_create
Fired when an entity tries to create a stargate (places a sign on a valid gate layout)

* returns: *boolean* `deny` (Whether creation was approved or not.)
* data: `actorUUID`, The entity attempting to create the portal; `portal`, the portal's name; `network`, the network this portal belongs to.
 
#### stargate_deactivate
Fired when a stargate is deactivated.

* returns: *null*
* data: `portal`, the portal's name; `network`, the network this portal belongs to.

#### stargate_destroy
Fired when an entity tries to break a stargate (tries to break a portal frame block)

* data: *boolean* `deny` (Whether destruction was approved or not.)
* data: `actorUUID`, The entity attempting to break the portal; `portal`, the portal's name; `network`, the network this portal belongs to.

#### stargate_close
Fired when a stargate opens.

* returns: *null*
* data: `actorUUID`, The entity that opened the portal; `portal`, the portal's name; `network`, the network this portal belongs to.

#### stargate_portal
Fired when a stargate teleports an entity

* returns: *null*
* data: `actorUUID`, The entity being teleported; `portal`, the responsible portal's name; `network`, the network of the responsible portal.

# Changes
[Version 4.0.0]
- Updated to stargate 1.0.0.4
  - Temporarily, updated to stargate 1.0.0.4-ALPHA until it gets merged.
- Updated to support all the new methods that come with it.
> ----------------- **THIS IS A BREAKING CHANGE** -----------------
- All legacy methods are renamed / significantly changed. 

[Version 3.0.2]
- Updated to stargate 0.8.0.2

[Version 3.0.0]
- Updated to commandHelper 3.3.4
- Updated to stargate 0.8.0.0 release
  - Added "sg_get_owner_name()"
  - Added "sg_get_owner_uuid()"
  - Added "sg_get_portal_info()"
  - Removed "sg_get_owner()"
 
[Version 2.0.0]
- Updated to commandHelper version `3.2.2-SNAPSHOT`
- added "stargate_open"
- removed "owner" mutable data

[Version 1.0.0]
 - Created interface
