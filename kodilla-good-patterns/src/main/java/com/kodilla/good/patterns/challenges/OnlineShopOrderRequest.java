package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OnlineShopOrderRequest implements OrderRequest
{
    private final OnlineShopUser user;
    private final Product product;
    private final LocalDate date;

    public OnlineShopOrderRequest(final OnlineShopUser user, final Product product, final LocalDate date)
    {
        this.user = user;
        this.product = product;
        this.date = date;
    }

    @Override
    public Customer getCustomer()
    {
        return this.user;
    }

    @Override
    public Product getProduct()
    {
        return this.product;
    }

    @Override
    public LocalDate getDate()
    {
        return this.date;
    }
}
