package com.kodilla.good.patterns.flight_finder;

public class FlightFinderRunner
{
    public static void main(String[] args)
    {
        Journey myJourney = new PrivateJourney("Warszawa", "Gdańsk");
        FlightFinderDisplay.displayDirect(myJourney);
        FlightFinderDisplay.displayConnecting(myJourney);

        String myCity = "Gdańsk";
        FlightFinderDisplay.displayDepartures(myCity);
        FlightFinderDisplay.displayArrivals(myCity);
    }
}
