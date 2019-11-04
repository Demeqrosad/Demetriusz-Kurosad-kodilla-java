package com.kodilla.good.patterns.flight_finder;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFinder
{
    FlightDatabase flights;
    Journey journey;

    public FlightFinder(FlightDatabase flights, Journey journey)
    {
        this.flights = flights;
        this.journey = journey;
    }

    public List<Flight> getDirectFlights()
    {
        List<Flight> resultSet = this.flights.getFlightsFromCity(journey.getInitialCity()).stream()
                .filter(f->f.getArrivalCity().equals(journey.getDestinationCity()))
                .collect(Collectors.toList());
        return resultSet;
    }

    public List<String> getConnectingFlights()
    {
        List<String> resultSet = this.flights.getFlightsFromCity(journey.getInitialCity()).stream()
                .map(f->f.getArrivalCity())
                .flatMap(a->this.flights.getFlightsFromCity(a).stream())
                .filter(f->f.getArrivalCity().equals(journey.getDestinationCity()))
                .map(f->"Flight from " + journey.getInitialCity() + " via " + f.getDepartureCity() + " to " + f.getArrivalCity() +".")
                .collect(Collectors.toList());
        return resultSet;
    }
}
