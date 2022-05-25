package me.pseudoknight.CHStargate.abstraction;

import java.util.List;

import org.jetbrains.annotations.NotNull;

public interface MSStargateActivateEvent extends MSStargateEvent{
    List<String> getDestinations();
    void setDestinations(@NotNull List<String> destinations);
    String getDestination();
    void setDestination(String destination);
}
