package com.kodilla.good.patterns.challenges;

public class Licence implements Product
{
    private final String productName;

    public Licence(final String productName)
    {
        this.productName = productName;
    }

    @Override
    public String getProductName()
    {
        return this.productName;
    }
}
