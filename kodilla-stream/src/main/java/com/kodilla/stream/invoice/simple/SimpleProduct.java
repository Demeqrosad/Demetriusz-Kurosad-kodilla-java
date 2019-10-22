package com.kodilla.stream.invoice.simple;

public final class SimpleProduct
{
    private final String productName;
    private final double productPrice;

    public SimpleProduct(final String productName, final double productPrice)
    {
        this.productName = productName;
        this.productPrice = productPrice;
    }
    //Getters
    public String getProductName()
    {
        return this.productName;
    }
    public double getProductPrice()
    {
        return this.productPrice;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        SimpleProduct that = (SimpleProduct) o;

        return this.getProductName().equals(that.getProductName());
    }
}
