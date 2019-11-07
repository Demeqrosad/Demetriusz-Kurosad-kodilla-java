package com.kodilla.good.patterns.food2door;

import java.util.List;

public class OrderProcessor
{
    private List<SubOrder> subOrders;

    public OrderProcessor(List<SubOrder> subOrders)
    {
        this.subOrders = subOrders;
    }

    public void confirmOrder()
    {
        for(SubOrder subOrder: this.subOrders)
        {
            String classToCreate = "com.kodilla.good.patterns.food2door." + subOrder.getVendor() + "Checkout";
            VendorCheckout checkout = VendorCheckoutCreator.create(classToCreate);
            if(checkout.process())
            {
                System.out.println(subOrder + " has been confirmed.");
            }
            else
            {
                System.out.println(subOrder + " has been canceled.");
            }
        }
    }

    public List<SubOrder> getSubOrders()
    {
        return this.subOrders;
    }
}
