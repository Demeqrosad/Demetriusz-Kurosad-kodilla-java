package com.kodilla.good.patterns.food2door;

import java.util.List;

public class ApplicationRunner
{
    public static void main(String[] args)
    {
        List<SubOrder> subOrders = OrderInitializer.retrieveOrder();
        OrderProcessor orderProcessor = new OrderProcessor(subOrders);
        orderProcessor.confirmOrder();
    }
}
