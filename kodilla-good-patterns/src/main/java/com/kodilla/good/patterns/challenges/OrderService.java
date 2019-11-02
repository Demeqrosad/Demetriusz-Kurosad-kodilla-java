package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public interface OrderService
{
    public boolean order(Customer customer, Product product, LocalDate date);
}
