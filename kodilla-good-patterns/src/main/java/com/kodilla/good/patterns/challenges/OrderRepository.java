package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public interface OrderRepository
{
    public void createOrder(Customer customer, Product product, LocalDate date);
}
