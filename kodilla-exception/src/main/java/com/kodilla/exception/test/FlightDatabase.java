package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FlightDatabase
{
    private final List<Flight> flights;

    public FlightDatabase()
    {
        flights = new ArrayList<>();
        flights.add(new Flight("London", "Berlin"));
        flights.add(new Flight("Paris", "Warsaw"));
        flights.add(new Flight("Berlin", "Rome"));
        flights.add(new Flight("London", "Paris"));
        flights.add(new Flight("Madrid", "London"));
        flights.add(new Flight("Warsaw", "London"));
    }

    private List<Flight> getFlights()
    {
        return new ArrayList<>(this.flights);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException
    {
        Map<String, Boolean> flightsFromAirport = new HashMap<>();
        this.flights.stream()
                .forEach(f -> flightsFromAirport.put(f.getArrivalAirport(),
                        f.getDepartureAirport().equals(flight.getDepartureAirport())));
        if(flightsFromAirport.entrySet().stream()
                .filter(k->k.getKey().equals(flight.getArrivalAirport()))
                .count() == 0)
        {
            throw new RouteNotFoundException("There is no way to get there!");
        }
        else if(flightsFromAirport.entrySet().stream()
                .filter(k->k.getKey().equals(flight.getArrivalAirport()))
                .filter(v->v.getValue()).count()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
