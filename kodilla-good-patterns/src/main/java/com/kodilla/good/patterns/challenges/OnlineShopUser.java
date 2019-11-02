package com.kodilla.good.patterns.challenges;

public class OnlineShopUser implements Customer
{
    private final String firstName;
    private final String lastName;

    public OnlineShopUser (final String firstName, final String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName()
    {
        return this.firstName;
    }
    @Override
    public String getLastName()
    {
        return this.lastName;
    }
}

