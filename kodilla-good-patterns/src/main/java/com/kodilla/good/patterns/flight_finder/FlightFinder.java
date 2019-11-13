package com.kodilla.good.patterns.flight_finder;

import java.util.*;
import java.util.stream.Collectors;

public class FlightFinder
{
    private FlightDatabase flightDatabase;
    private Journey journey;

    public FlightFinder(FlightDatabase flightDatabase, Journey journey)
    {
        this.flightDatabase = flightDatabase;
        this.journey = journey;
    }

    public LinkedList<Flight> getDirectFlights()
    {
        return new LinkedList<>(this.flightDatabase.getFlightsFromCity(this.journey.getInitialCity()).stream()
                .filter(f->f.getArrivalCity().equals(journey.getDestinationCity()))
                .collect(Collectors.toList()));
    }

    public LinkedList<Journey> getFlightsWithChanges(int numberOfChanges)
    {
        int numberOfFlights = this.flightDatabase.getFlights().size();
        int maxChanges = numberOfFlights - 1;
        if(numberOfChanges > maxChanges)
        {
            numberOfChanges = maxChanges;
        }
        LinkedList<Journey> resultListOfJourneys = new LinkedList<>();
        List<Flight> possibleFlights;
        Journey possibleJourney;
        Set<Journey> tempListOfJourneys = new HashSet<>();
        Set<Journey> builtListOfJourneys = new HashSet<>();
        LinkedList<Flight> tempListOfFlights = new LinkedList<>();
        for(int i=0;i<numberOfChanges+1;i++)
        {
            if(i==0)
            {
                for(Flight flight:flightDatabase.getFlightsFromCity(journey.getInitialCity()))
                {
                    tempListOfFlights.add(new PrivateFlight(flight.getDepartureCity(), flight.getArrivalCity()));
                    tempListOfJourneys.add(new PrivateJourney(new LinkedList<Flight>(tempListOfFlights)));
                    tempListOfFlights.clear();
                }
            }
            else
            {
                for(Journey tempJourney:tempListOfJourneys)
                {
                    possibleFlights = flightDatabase.getFlightsFromCity(tempJourney.getDestinationCity());
                    for(Flight possibleFlight:possibleFlights)
                    {
                        tempListOfFlights = tempJourney.getFlights();
                        tempListOfFlights.offer(possibleFlight);
                        possibleJourney = new PrivateJourney(new LinkedList<>(tempListOfFlights));
                        if(possibleJourney.isLooped())
                        {
                            continue;
                        }
                        else
                        {
                            builtListOfJourneys.add(possibleJourney);
                        }
                    }
                }
                tempListOfJourneys.clear();
                Set<Journey> newListOfJourneys = builtListOfJourneys.stream()
                        .filter(j -> j.getDestinationCity().equals(this.journey.getDestinationCity()))
                        .collect(Collectors.toSet());
                if(newListOfJourneys.size()>0)
                {
                    resultListOfJourneys.addAll(newListOfJourneys);
                }
                tempListOfJourneys.addAll(builtListOfJourneys);
                builtListOfJourneys.clear();
            }
        }
        return resultListOfJourneys;
    }
}
