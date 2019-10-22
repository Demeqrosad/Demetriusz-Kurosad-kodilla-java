package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorldTestSuite
{
    @Test
    public void testGetPeopleQuantity()
    {
        //Given
        List<Country> testEuropeCountries = new ArrayList<>();
            testEuropeCountries.add(new Country("France", new BigDecimal("67654321")));
            testEuropeCountries.add(new Country("Germany", new BigDecimal("83210987")));
            testEuropeCountries.add(new Country("Poland", new BigDecimal("38432109")));
            testEuropeCountries.add(new Country("Italy", new BigDecimal("60321098")));
        List<Country> testAmericaCountries = new ArrayList<>();
            testAmericaCountries.add(new Country("Mexico", new BigDecimal("126543210")));
            testAmericaCountries.add(new Country("Brazil", new BigDecimal("210109876")));
            testAmericaCountries.add(new Country("Canada", new BigDecimal("37654321")));
            testAmericaCountries.add(new Country("Argentina", new BigDecimal("44987654")));
        List<Country> testAsiaCountries = new ArrayList<>();
            testAsiaCountries.add(new Country("China", new BigDecimal("1403543210")));
            testAsiaCountries.add(new Country("India", new BigDecimal("1324109876")));
            testAsiaCountries.add(new Country("Japan", new BigDecimal("126321098")));
            testAsiaCountries.add(new Country("Pakistan", new BigDecimal("212765432")));
        List<Country> testAfricaCountries = new ArrayList<>();
            testAfricaCountries.add(new Country("Egypt", new BigDecimal("94765432")));
            testAfricaCountries.add(new Country("Nigeria", new BigDecimal("200987654")));
        List<Continent> testWorldContinents = new ArrayList<>();
            testWorldContinents.add(new Continent("Europe", testEuropeCountries));
            testWorldContinents.add(new Continent("America", testAmericaCountries));
            testWorldContinents.add(new Continent("Asia", testAsiaCountries));
            testWorldContinents.add(new Continent("Africa", testAfricaCountries));
        World earth = new World(testWorldContinents);
        BigDecimal expResult = new BigDecimal("4031406278");
        //When
        BigDecimal actResult = earth.getPeopleQuantity();
        //Then
        Assert.assertEquals(expResult, actResult);
        Assert.assertTrue(earth.getContinents().size() == 4);
        Assert.assertTrue( earth.getContinents().stream()
        .flatMap(continent -> continent.getCountries().stream())
        .collect(Collectors.toList()).size() == 14);
    }
}
