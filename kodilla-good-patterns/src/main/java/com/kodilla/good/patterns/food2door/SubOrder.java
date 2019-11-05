package com.kodilla.good.patterns.food2door;

public final class SubOrder
{
    private final String vendor;
    private final String product;
    private final double quantity;

    public SubOrder(final String vendor, final String product, final double quantity)
    {
        this.vendor = vendor;
        this.product = product;
        this.quantity = quantity;
    }

    public String getVendor()
    {
        return this.vendor;
    }

    public String getProduct()
    {
        return this.product;
    }

    public double getQuantity()
    {
        return this.quantity;
    }

    @Override
    public String toString()
    {
        return "Order of " + this.quantity + " unit/units of "
                + this.product + " from " + this.vendor;
    }
}
