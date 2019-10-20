package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain
{
    public static void main(String[] args)
    {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("abc",text -> "ABC" + text + "ABC");
        poemBeautifier.beautify("i am not shouting!",text -> text.toUpperCase());
        poemBeautifier.beautify("refer",text -> text.replace("f", "pap"));
        poemBeautifier.beautify("  trim me not  ",text -> text.trim());
    }
}
