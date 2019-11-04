package com.kodilla.good.patterns.flight_finder;

public final class PrivateJourney implements Journey
{
    private final String initialCity;
    private final String destinationCity;

    public PrivateJourney(final String initialCity, final String destinationCity)
    {
        this.initialCity = initialCity;
        this.destinationCity = destinationCity;
    }

    @Override
    public String getInitialCity()
    {
        return this.initialCity;
    }

    @Override
    public String getDestinationCity()
    {
        return this.destinationCity;
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

        PrivateJourney that = (PrivateJourney) o;

        if (!this.getInitialCity().equals(that.getInitialCity()))
        {
            return false;
        }
        return this.getDestinationCity().equals(that.getDestinationCity());
    }

    @Override
    public int hashCode()
    {
        int result = this.getInitialCity().hashCode();
        result = 31 * result + this.getDestinationCity().hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return "Journey from " + this.initialCity + " to " + this.destinationCity + ".";
    }
}
