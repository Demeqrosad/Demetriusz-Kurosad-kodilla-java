package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite
{
    @Test
    public void testConnect() throws SQLException
    {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException
    {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM Users";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next())
        {
            System.out.println(rs.getInt("UserID") + ", " +
                    rs.getString("firstName") + ", " +
                    rs.getString("lastName"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException
    {
        //Given
        DbManager dbManager = DbManager.getInstance();
        int expResult = 1;
        //When
        String sqlQuery = "SELECT CONCAT(U.firstName, \" \", U.lastName) AS user, COUNT(P.postID) AS numberOfPosts\n" +
                "FROM Users U INNER JOIN Posts P ON U.userID = P.userID\n" +
                "GROUP BY U.userID\n" +
                "HAVING COUNT(P.postID) > 1\n" +
                "ORDER BY U.lastName, U.firstName;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        //Then
        int actResult = 0;
        while (rs.next())
        {
            System.out.println(rs.getString("user") + ", " +
                    rs.getInt("numberOfPosts"));
            actResult++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(expResult, actResult);
    }
}
