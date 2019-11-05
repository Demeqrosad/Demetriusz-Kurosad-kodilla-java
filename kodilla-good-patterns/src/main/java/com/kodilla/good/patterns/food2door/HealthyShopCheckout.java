package com.kodilla.good.patterns.food2door;

public class HealthyShopCheckout implements VendorCheckout
{
    @Override
    public boolean process()
    {
        System.out.println("Thank you for buying in HealthyShop.");
        return true;
    }
}
