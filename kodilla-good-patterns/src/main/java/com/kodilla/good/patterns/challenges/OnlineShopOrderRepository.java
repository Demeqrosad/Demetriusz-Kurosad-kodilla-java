package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OnlineShopOrderRepository implements OrderRepository
{
    private final String orderRepositoryType;

    public OnlineShopOrderRepository()
    {
        this.orderRepositoryType = "Online shop order repository";
    }

    @Override
    public void createOrder(Customer customer, Product product, LocalDate date)
    {
        System.out.println("The order from "+ customer.getFirstName() + " "
                + customer.getLastName() + " on " + product.getProductName()
                + " placed on " + date + " has been registered.");
    }
    public String getOrderRepositoryType()
    {
        return orderRepositoryType;
    }


}
