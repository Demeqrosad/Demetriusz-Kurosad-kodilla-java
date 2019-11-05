package com.kodilla.good.patterns.food2door;

public class GlutenFreeShopCheckout implements VendorCheckout
{
    @Override
    public boolean process()
    {
        System.out.println("Thank you for buying in GlutenFreeShop.");
        return true;
    }
}
