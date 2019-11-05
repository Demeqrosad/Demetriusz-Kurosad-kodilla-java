package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class OrderInitializer
{
    public static List<SubOrder> retrieveOrder()
    {
        List<SubOrder> resultList = new ArrayList<>();
        resultList.add(new SubOrder("ExtraFoodShop", "EFSProduct1", 1.0));
        resultList.add(new SubOrder("HealthyShop", "HLFProduct2", 2.0));
        resultList.add(new SubOrder("GlutenFreeShop", "GFSProduct3", 3.0));
        return resultList;
    }
}
