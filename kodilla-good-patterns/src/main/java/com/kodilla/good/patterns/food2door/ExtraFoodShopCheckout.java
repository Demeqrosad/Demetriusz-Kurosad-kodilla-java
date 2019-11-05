package com.kodilla.good.patterns.food2door;

public class ExtraFoodShopCheckout implements VendorCheckout
{
    @Override
    public boolean process()
    {
        System.out.println("Thank you for buying in ExtraFoodShop.");
        return true;
    }
}
