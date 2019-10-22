package com.kodilla.stream.immutable;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class ForumUserTestSuite
{
    @Test
    public void testGetBirthDate()
    {
        //Given
        ForumUser user1 = new ForumUser("User1", "John", new ArrayList<>(), LocalDate.of(1998, 5, 17));
        LocalDate expResult = LocalDate.of(1998, 5, 17);
        //When
        LocalDate actResult = user1.getBirthDate();
        //Then
        System.out.println(expResult.toString() + " " + actResult.toString());
        Assert.assertEquals(expResult, actResult);
    }
}
