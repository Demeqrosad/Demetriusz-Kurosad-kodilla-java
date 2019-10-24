package com.kodilla.stream.beautifier;

import org.junit.Assert;
import org.junit.Test;

public class PoemBeautifierTestSuite
{
    @Test
    public void testBeautify()
    {
        //Given
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String expResult1 = "ABCabcABC";
        String expResult2 = "I AM NOT SHOUTING!";
        String expResult3 = "repaper";
        String expResult4 = "trim me not";
        //When
        String actResult1 = poemBeautifier.beautify("abc", text -> "ABC" + text + "ABC");
        String actResult2 = poemBeautifier.beautify("i am not shouting!", text -> text.toUpperCase());
        String actResult3 = poemBeautifier.beautify("refer", text -> text.replace("f", "pap"));
        String actResult4 = poemBeautifier.beautify("  trim me not  ", text -> text.trim());
        //Then
        Assert.assertEquals(expResult1, actResult1);
        Assert.assertEquals(expResult2, actResult2);
        Assert.assertEquals(expResult3, actResult3);
        Assert.assertEquals(expResult4, actResult4);
    }
}
