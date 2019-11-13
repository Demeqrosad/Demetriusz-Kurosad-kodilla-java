package com.kodilla.good.patterns.flight_finder;

import java.util.*;

public final class PrivateJourney implements Journey
{
    private final LinkedList<Flight> journeyPlan;

    public PrivateJourney(final LinkedList<Flight> journeyPlan)
    {
        this.journeyPlan = journeyPlan;
    }

    @Override
    public String getInitialCity()
    {
        try
        {
            return this.journeyPlan.getFirst().getDepartureCity();
        }
        catch (NoSuchElementException e)
        {
            return "";
        }
    }

    @Override
    public String getDestinationCity()
    {
        try
        {
            return this.journeyPlan.getLast().getArrivalCity();
        }
        catch (NoSuchElementException e)
        {
            return "";
        }

    }

    @Override
    public boolean isLooped()
    {
        Set<String> listOfCities = new HashSet<>();
        for(Flight flight:this.journeyPlan)
        {
            listOfCities.add(flight.getDepartureCity());
            listOfCities.add(flight.getArrivalCity());
        }
        if(listOfCities.size()==this.journeyPlan.size()+1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public LinkedList<Flight> getFlights()
    {
        return new LinkedList<>(this.journeyPlan);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        PrivateJourney that = (PrivateJourney) o;

        return journeyPlan != null ? journeyPlan.equals(that.journeyPlan) : that.journeyPlan == null;
    }

    @Override
    public int hashCode()
    {
        return journeyPlan != null ? journeyPlan.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        try
        {
            String result =  this.journeyPlan.getFirst().getDepartureCity();
            Iterator<Flight> flightIterator = this.journeyPlan.iterator();
            while(flightIterator.hasNext())
            {
                result = result + " -> " + flightIterator.next().getArrivalCity();
            }
            return result;
        }
        catch (NoSuchElementException e)
        {
            return "";
        }

    }
}
