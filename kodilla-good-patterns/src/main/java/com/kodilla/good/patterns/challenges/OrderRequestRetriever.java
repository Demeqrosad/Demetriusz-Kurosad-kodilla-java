package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderRequestRetriever
{
    public OnlineShopOrderRequest retrieve()
    {
        OnlineShopUser user = new OnlineShopUser("James", "Bond");
        Licence licence = new Licence("Licence 007");
        LocalDate date = LocalDate.of(1962, 10, 5);

        return new OnlineShopOrderRequest(user, licence, date);
    }
}
