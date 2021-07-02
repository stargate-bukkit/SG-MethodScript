> !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!<br>
>  THIS ADDON IS **OUTDATED**.<br>DO __**NOT**__ USE IT WITH SG `0.10.4.0`+<br><br>
>                              No stable releases are available at this time.<br>
> !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!<br>

__**Important Links**__
- [Upstream](https://github.com/PseudoKnight/CHStargate/issues)
- [Stargate discord](https://discord.gg/mTaHuK6BVa).
- [MethodScript discord](https://discord.gg/Z7jpHed)
- [Support MethodScript](https://github.com/sponsors/LadyCailin)

# Description
An addon for the Stargate-Bukkit plugin. Creates an interface for [commandHelper](https://enginehub.org/commandhelper/) (part of [MethodScript](https://discord.gg/Z7jpHed)). 

#### Features:
- To be determined
##### Functions

* boolean **sg_set_owner(portalName, portalNetwork, owner)** Sets the portal's owner.
* string **sg_get_owner_name(portalName, portalNetwork)** Returns the portal's owner name.
* string **sg_get_owner_uuid(portalName, portalNetwork)** Returns the portal's owner UUID.
* array **sg_get_portal_info(portalName, portalNetwork)** Gets an array of data about a specific Stargate portal.

##### Events
###### stargate_access

Fired when a player interacts with a Stargate. Result determines access.

* prefilters: deny (boolean - Whether access was denied or not.)
* data: player, portal, network

###### stargate_destroy

Fired when a block of a Stargate portal is broken.

* prefilters: deny (boolean - Whether access was denied or not.)
* data: player, portal, network

###### stargate_open

Fired when a Stargate portal is opened.

* data: player, portal, network

## Dependencies
[The most recent version of Stargate](https://www.spigotmc.org/resources/stargate.87978/)

# Changes
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