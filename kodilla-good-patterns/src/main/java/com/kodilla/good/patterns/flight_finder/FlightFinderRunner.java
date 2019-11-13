package com.kodilla.good.patterns.flight_finder;

import java.util.LinkedList;
import java.util.List;

public class FlightFinderRunner
{
    public static void main(String[] args)
    {
        String myInitialCity = "Katowice";
        String myDestinationCity = "Kraków";
        LinkedList<Flight> myFlightPlan = new LinkedList<>();
        myFlightPlan.add(new PrivateFlight(myInitialCity,myDestinationCity));
        Journey myJourney = new PrivateJourney(myFlightPlan);
        FlightFinderDisplay flightFinderDisplay = new FlightFinderDisplay(myJourney);
        flightFinderDisplay.displayDirect();
        flightFinderDisplay.displayConnecting(25);

        String myCity = "Kraków";
        flightFinderDisplay.displayDepartures(myCity);
        flightFinderDisplay.displayArrivals(myCity);
    }
}
