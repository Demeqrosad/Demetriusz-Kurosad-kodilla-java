package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.person.People;

public class StreamMain
{
    public static void main(String[] args)
    {
        /*PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("abc", text -> "ABC" + text + "ABC");
        poemBeautifier.beautify("i am not shouting!", text -> text.toUpperCase());
        poemBeautifier.beautify("refer", text -> text.replace("f", "pap"));
        poemBeautifier.beautify("  trim me not  ", text -> text.trim());*/

        /*System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);*/

        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);
    }
}
