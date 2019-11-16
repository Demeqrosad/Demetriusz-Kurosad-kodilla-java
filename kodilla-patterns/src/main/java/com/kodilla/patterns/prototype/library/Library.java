package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype
{
    private final String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public Set<Book> getBooks()
    {
        return this.books;
    }

    public Library shallowCopy() throws CloneNotSupportedException
    {
        return (Library)super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException
    {
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        clonedLibrary.getBooks().addAll(this.books);
        return clonedLibrary;
    }
}
