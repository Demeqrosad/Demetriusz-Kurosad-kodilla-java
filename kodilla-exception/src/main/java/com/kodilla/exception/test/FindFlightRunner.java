package com.kodilla.exception.test;

public class FindFlightRunner
{
    public static void main(String[] args)
    {
        FlightDatabase flightDatabase = new FlightDatabase();
        Flight myFlight = new Flight("London", "Madrid");
        try
        {
            if(flightDatabase.findFlight(myFlight))
            {
                System.out.println("Yes, there is a direct flight to " + myFlight.getArrivalAirport()
                        + " from " +myFlight.getDepartureAirport());
            }
            else
            {
                System.out.println("There is no direct flight to " + myFlight.getArrivalAirport()
                        + " from " + myFlight.getDepartureAirport());
            }
        }
        catch (RouteNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
