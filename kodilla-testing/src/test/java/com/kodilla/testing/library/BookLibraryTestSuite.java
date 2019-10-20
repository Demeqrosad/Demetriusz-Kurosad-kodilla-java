package com.kodilla.testing.library;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BookLibraryTestSuite
{
    @Test
    public void testListBooksInHandsOfBorrowedNone()
    {
        // Given
        int borrowedBooks = 0;
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary testLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser testUser = new LibraryUser("John", "Tester", "99102001234");
        List<Book> expResult = generateListOfNBooks(borrowedBooks);
        when(libraryDatabaseMock.listBooksInHandsOf(testUser)).thenReturn(expResult);
        //When
        List<Book> actResult = testLibrary.listBooksInHandsOf(testUser);
        //Then
        Assert.assertEquals(expResult, actResult);
        Assert.assertTrue(borrowedBooks == actResult.size());
    }
    @Test
    public void testListBooksInHandsOfBorrowedOne()
    {
        // Given
        int borrowedBooks = 1;
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary testLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser testUser = new LibraryUser("John", "Tester", "99102001234");
        List<Book> expResult = generateListOfNBooks(borrowedBooks);
        when(libraryDatabaseMock.listBooksInHandsOf(testUser)).thenReturn(expResult);
        //When
        List<Book> actResult = testLibrary.listBooksInHandsOf(testUser);
        //Then
        Assert.assertEquals(expResult, actResult);
        Assert.assertTrue(borrowedBooks == actResult.size());
    }
    @Test
    public void testListBooksInHandsOfBorrowedFive()
    {
        // Given
        int borrowedBooks = 5;
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary testLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser testUser = new LibraryUser("John", "Tester", "99102001234");
        List<Book> expResult = generateListOfNBooks(borrowedBooks);
        when(libraryDatabaseMock.listBooksInHandsOf(testUser)).thenReturn(expResult);
        //When
        List<Book> actResult = testLibrary.listBooksInHandsOf(testUser);
        //Then
        Assert.assertEquals(expResult, actResult);
        Assert.assertTrue(borrowedBooks == actResult.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity)
    {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++)
        {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
}
