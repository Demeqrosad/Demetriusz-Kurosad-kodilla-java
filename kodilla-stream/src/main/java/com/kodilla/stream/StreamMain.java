package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import java.util.Map;
import java.util.stream.Collectors;

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

        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<\n","\n>>"));

        System.out.println(theResultStringOfBooks);
    }
}
