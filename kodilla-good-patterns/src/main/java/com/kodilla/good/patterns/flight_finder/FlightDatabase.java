package com.kodilla.good.patterns.flight_finder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class FlightDatabase
{
    private final Set<Flight> flights;

    public FlightDatabase()
    {
        this.flights = new HashSet<>();
        this.flights.add(new PrivateFlight("Warszawa", "Gdańsk"));
        this.flights.add(new PrivateFlight("Warszawa", "Poznań"));
        this.flights.add(new PrivateFlight("Warszawa", "Katowice"));
        this.flights.add(new PrivateFlight("Warszawa", "Wrocław"));
        this.flights.add(new PrivateFlight("Poznań", "Kraków"));
        this.flights.add(new PrivateFlight("Poznań", "Gdańsk"));
        this.flights.add(new PrivateFlight("Poznań", "Warszawa"));
        this.flights.add(new PrivateFlight("Wrocław", "Gdańsk"));
        this.flights.add(new PrivateFlight("Gdańsk", "Warszawa"));
        this.flights.add(new PrivateFlight("Gdańsk", "Kraków"));
        this.flights.add(new PrivateFlight("Katowice", "Warszawa"));
        this.flights.add(new PrivateFlight("Kraków", "Gdańsk"));
        this.flights.add(new PrivateFlight("Kraków", "Poznań"));
        this.flights.add(new PrivateFlight("Wrocław", "Warszawa"));
        this.flights.add(new PrivateFlight("Gdańsk", "Szczecin"));
        this.flights.add(new PrivateFlight("Szczecin", "Kraków"));
        this.flights.add(new PrivateFlight("Katowice", "Poznań"));
        this.flights.add(new PrivateFlight("Katowice", "Kraków"));
    }

    public Set<Flight> getFlights()
    {
        return new HashSet<>(this.flights);
    }

    public List<Flight> getFlightsFromCity(final String fromCity)
    {
        List<Flight> resultList;
        resultList = this.flights.stream()
                .filter(f->f.getDepartureCity().equals(fromCity))
                .collect(Collectors.toList());
        return resultList;
    }

    public List<Flight> getFlightsToCity(final String toCity)
    {
        List<Flight> resultList;
        resultList = this.flights.stream()
                .filter(f->f.getArrivalCity().equals(toCity))
                .collect(Collectors.toList());
        return resultList;
    }
}
