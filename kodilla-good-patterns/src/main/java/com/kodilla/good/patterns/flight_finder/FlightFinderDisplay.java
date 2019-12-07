package com.kodilla.good.patterns.flight_finder;

public class FlightFinderDisplay
{
    private FlightDatabase flightDatabase = new FlightDatabase();
    private FlightFinder flightFinder;
    private Journey myJourney;

    public FlightFinderDisplay(Journey myJourney)
    {
        this.flightFinder = new FlightFinder(this.flightDatabase, myJourney);
        this.myJourney = myJourney;
    }

    public void displayDirect()
    {
        System.out.println("\nDirect flights:\n");
        if (flightFinder.getDirectFlights().size() > 0)
        {
            flightFinder.getDirectFlights().stream()
                    .forEach(System.out::println);
        }
        else
        {
            System.out.println("No flights found.");
        }
    }

    public void displayConnecting(int numberOfChanges)
    {

        System.out.println("\nConnecting flights:\n");
        if(flightFinder.getFlightsWithChanges(numberOfChanges).size()>0)
        {
            flightFinder.getFlightsWithChanges(numberOfChanges).stream()
                    .forEach(System.out::println);
        }
        else
        {
            System.out.println("No flights found.");
        }
    }

    public void displayDepartures(String airport)
    {
        System.out.println("\nDepartures from " + airport +":\n");
        if(this.flightDatabase.getFlightsFromCity(airport).size()>0)
        {
            this.flightDatabase.getFlightsFromCity(airport).stream()
                    .forEach(System.out::println);
        }
        else
        {
            System.out.println("No flights found.");
        }
    }

    public void displayArrivals(String airport)
    {
        System.out.println("\nArrivals to " + airport +":\n");
        if(this.flightDatabase.getFlightsToCity(airport).size()>0)
        {
            this.flightDatabase.getFlightsToCity(airport).stream()
                    .forEach(System.out::println);
        }
        else
        {
            System.out.println("No flights found.");
        }
    }
}
