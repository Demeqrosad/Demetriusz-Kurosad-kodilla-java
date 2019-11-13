package com.kodilla.good.patterns.flight_finder;

public final class PrivateFlight implements Flight
{
    private final String departureCity;
    private final String arrivalCity;

    public PrivateFlight(final String departureCity, final String arrivalCity)
    {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    @Override
    public String getDepartureCity()
    {
        return this.departureCity;
    }

    @Override
    public String getArrivalCity()
    {
        return this.arrivalCity;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || this.getClass() != o.getClass())
        {
            return false;
        }

        PrivateFlight that = (PrivateFlight) o;

        if (!this.getDepartureCity().equals(that.getDepartureCity()))
        {
            return false;
        }
        return this.getArrivalCity().equals(that.getArrivalCity());
    }

    @Override
    public int hashCode()
    {
        int result = this.getDepartureCity().hashCode();
        result = 31 * result + this.getArrivalCity().hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return this.departureCity + " -> " + this.arrivalCity;
    }
}
