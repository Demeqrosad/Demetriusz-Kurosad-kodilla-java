package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite
{
    @Test
    public void testDefaultSharingStrategies()
    {
        //Given
        User john = new Millenials("John Smiley");
        User bill = new YGeneration("Bill Nightingale");
        User sam = new ZGeneration("Sam Shutter");
        String expResultJohn = "John Smiley is making post on Facebook";
        String expResultBill = "Bill Nightingale is making post on Twitter";
        String expResultSam = "Sam Shutter is making post on Snapchat";
        //When
        String actResultJohn = john.sharePost();
        String actResultBill = bill.sharePost();
        String actResultSam = sam.sharePost();
        //Then
        Assert.assertEquals(expResultJohn, actResultJohn);
        Assert.assertEquals(expResultBill, actResultBill);
        Assert.assertEquals(expResultSam, actResultSam);
    }

    @Test
    public void testIndividualSharingStrategy()
    {
        //Given
        User john = new Millenials("John Smiley");
        String expResult = "John Smiley is making post on Snapchat";
        //When
        john.setPreferredSocialMedium(new SnapchatPublisher());
        String actResult = john.sharePost();
        //Then
        Assert.assertEquals(expResult, actResult);
    }
}
