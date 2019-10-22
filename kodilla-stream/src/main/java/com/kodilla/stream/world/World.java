package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World
{
    final private List<Continent> continents;

    public World(final List<Continent> continents)
    {
        this.continents = continents;
    }

    public BigDecimal getPeopleQuantity()
    {
        return this.continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }
    //Getters
    public List<Continent> getContinents()
    {
        return new ArrayList<>(this.continents);
    }
}
