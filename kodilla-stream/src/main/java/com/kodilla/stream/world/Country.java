package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country
{
    final private String countryName;
    final private BigDecimal peopleQuantity;

    public Country(final String countryName, final BigDecimal peopleQuantity)
    {
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;
    }
    //Getters

    public String getCountryName()
    {
        return this.countryName;
    }

    public BigDecimal getPeopleQuantity()
    {
        return this.peopleQuantity;
    }
}
