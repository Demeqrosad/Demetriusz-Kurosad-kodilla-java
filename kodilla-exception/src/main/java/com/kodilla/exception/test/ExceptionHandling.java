package com.kodilla.exception.test;

public class ExceptionHandling
{
    public static void main(String[] args)
    {
        SecondChallenge secondChallenge = new SecondChallenge();
        try
        {
            String result = secondChallenge.probablyIWillThrowException(2, 1.5);
            System.out.println(result);
        }
        catch (NumberFormatException e)
        {
            System.out.println("There is no way to put a String there as an argument: " + e);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("The x argument have to be <1,2) and the y argument not equal 1.5: " + e);
        }
        catch (RuntimeException e)
        {
            System.out.println("Other RuntimeException has occurred: " + e);
        }
        catch (Exception e)
        {
            System.out.println("Other Exception has occurred: " + e);
        }
        finally
        {
            System.out.println("The SecondChallenge method has been executed with exception handling");
        }
    }
}
