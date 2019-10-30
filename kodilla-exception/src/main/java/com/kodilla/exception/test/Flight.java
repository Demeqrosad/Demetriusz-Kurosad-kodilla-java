package com.kodilla.exception.test;

public class Flight
{
    private final String departureAirport;
    private final String arrivalAirport;

    public Flight(final String departureAirport, final String arrivalAirport)
    {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport()
    {
        return this.departureAirport;
    }

    public String getArrivalAirport()
    {
        return this.arrivalAirport;
    }
}
