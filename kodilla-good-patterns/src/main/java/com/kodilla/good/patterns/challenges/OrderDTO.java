package com.kodilla.good.patterns.challenges;

public class OrderDTO
{
    private final OrderRequest orderRequest;
    private final boolean isOrdered;

    public OrderDTO(final OrderRequest orderRequest, final boolean isOrdered)
    {
        this.orderRequest = orderRequest;
        this.isOrdered = isOrdered;
    }

    public OrderRequest getOrderRequest()
    {
        return this.orderRequest;
    }

    public boolean isOrdered()
    {
        return this.isOrdered;
    }
}
