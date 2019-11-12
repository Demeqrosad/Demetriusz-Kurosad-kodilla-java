package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public final class OnlineShopOrderService implements OrderService
{
    private final String orderServiceType = "Online shop order service";

    @Override
    public boolean order(Customer user, Product product, LocalDate date)
    {
        System.out.println("On " + date + ", " + user.getFirstName() + " has ordered "
                + product.getProductName() + ".");
        return true;
    }

    public String getOrderServiceType()
    {
        return this.orderServiceType;
    }
}
