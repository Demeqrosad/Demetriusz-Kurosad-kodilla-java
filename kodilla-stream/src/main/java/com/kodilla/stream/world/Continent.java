package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent
{
    final private String continentName;
    final private List<Country> countries;

    public Continent(final String continentName, final List<Country> countries)
    {
        this.continentName = continentName;
        this.countries = countries;
    }

    //Getters
    public List<Country> getCountries()
    {
        return new ArrayList<>(this.countries);
    }
    public String getContinentName()
    {
        return this.continentName;
    }
}
