package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public interface OrderRequest
{
    public Customer getCustomer();
    public Product getProduct();
    public LocalDate getDate();
}
