package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;

public class LibraryTestSuite
{
    @Test
    public void testGetBooks()
    {
        //Given
        Library theLibrary = new Library("Library One");
        for(int i=1; i<6; i++)
        {
            theLibrary.getBooks().add(new Book("Book" + i,"Author" + i,
                    LocalDate.of(2000 +i, i, i)));
        }
        Library theLibraryShallowCopy = null;
        Library theLibraryDeepCopy = null;
        try
        {
            theLibraryShallowCopy = theLibrary.shallowCopy();
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println(e);
        }
        try
        {
            theLibraryDeepCopy = theLibrary.deepCopy();
        }
        catch (CloneNotSupportedException e)
        {
            System.out.println(e);
        }
        //When
        theLibrary.getBooks().remove(theLibrary.getBooks().iterator().next());
        int actResultOrigin = theLibrary.getBooks().size();
        int actResultShallow = theLibraryShallowCopy.getBooks().size();
        int actResultDeep = theLibraryDeepCopy.getBooks().size();
        //Then
        Assert.assertEquals(4, actResultOrigin);
        Assert.assertEquals(4, actResultShallow);
        Assert.assertEquals(5, actResultDeep);
        Assert.assertEquals(theLibrary.getBooks(), theLibraryShallowCopy.getBooks());
        Assert.assertNotEquals(theLibrary.getBooks(), theLibraryDeepCopy.getBooks());
    }
}
