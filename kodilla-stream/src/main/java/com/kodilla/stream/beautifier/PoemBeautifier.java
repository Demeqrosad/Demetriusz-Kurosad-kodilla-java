package com.kodilla.stream.beautifier;

public class PoemBeautifier
{
    public String beautify (String text, PoemDecorator decorator)
    {
        System.out.println("Text to decorate: " + text);
        String textDecorated = decorator.decorate(text);
        System.out.println("Final text: " + textDecorated);
        return textDecorated;
    }
}
