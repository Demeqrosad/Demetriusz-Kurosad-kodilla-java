package com.kodilla.good.patterns.flight_finder;

public class FlightFinderDisplay
{
    public static void displayDirect(Journey myJourney)
    {
        FlightDatabase flights = new FlightDatabase();
        FlightFinder flightFinder = new FlightFinder(flights, myJourney);

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

    public static void displayConnecting(Journey myJourney)
    {
        FlightDatabase flights = new FlightDatabase();
        FlightFinder flightFinder = new FlightFinder(flights, myJourney);

        System.out.println("\nConnecting flights:\n");
        if(flightFinder.getConnectingFlights().size()>0)
        {
            flightFinder.getConnectingFlights().stream()
                    .forEach(System.out::println);
        }
        else
        {
            System.out.println("No flights found.");
        }
    }

    public static void displayDepartures(String airport)
    {
        FlightDatabase flights = new FlightDatabase();

        System.out.println("\nDepartures from " + airport +":\n");
        if(flights.getFlightsFromCity(airport).size()>0)
        {
            flights.getFlightsFromCity(airport).stream()
                    .forEach(System.out::println);
        }
        else
        {
            System.out.println("No flights found.");
        }
    }

    public static void displayArrivals(String airport)
    {
        FlightDatabase flights = new FlightDatabase();

        System.out.println("\nArrivals to " + airport +":\n");
        if(flights.getFlightsToCity(airport).size()>0)
        {
            flights.getFlightsToCity(airport).stream()
                    .forEach(System.out::println);
        }
        else
        {
            System.out.println("No flights found.");
        }
    }
}
