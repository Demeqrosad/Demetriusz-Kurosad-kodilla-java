package com.kodilla.patterns.prototype.library;

import java.time.LocalDate;

public final class Book
{
    private final String title;
    private final String author;
    private final LocalDate publicationDate;

    public Book(final String title, final String author, final LocalDate publicationDate)
    {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public LocalDate getPublicationDate()
    {
        return this.publicationDate;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "title='" + this.title + '\'' +
                ", author='" + this.author + '\'' +
                ", publicationDate=" + this.publicationDate +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Book book = (Book) o;

        return getTitle().equals(book.getTitle());
    }

    @Override
    public int hashCode()
    {
        return getTitle().hashCode();
    }
}