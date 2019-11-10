package com.kodilla.good.patterns.flight_finder;

import java.util.LinkedList;

public interface Journey
{
    public String getInitialCity();
    public String getDestinationCity();
    public boolean isLooped();
    public LinkedList<Flight> getFlights();
}
