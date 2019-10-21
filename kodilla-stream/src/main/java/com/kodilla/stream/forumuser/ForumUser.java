package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Period;

public class ForumUser
{
    final private int userID;
    final private String username;
    final private char userSex;
    final private LocalDate birthDate;
    final private int userPostsNumber;

    public ForumUser(final int userID, final String username, final char userSex,
                     final LocalDate birthDate, final int userPostsNumber)
    {
        this.userID = userID;
        this.username = username;
        this.userSex = userSex;
        this.birthDate = birthDate;
        this.userPostsNumber = userPostsNumber;
    }

    public int getAge()
    {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
    //Getters
    public int getUserID()
    {
        return userID;
    }
    public String getUsername()
    {
        return username;
    }
    public char getUserSex()
    {
        return userSex;
    }
    public LocalDate getBirthDate()
    {
        return birthDate;
    }
    public int getUserPostsNumber()
    {
        return userPostsNumber;
    }

    @Override
    public String toString()
    {
        return "ForumUser{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", userSex=" + userSex +
                ", birthDate=" + birthDate +
                ", userPostsNumber=" + userPostsNumber +
                ", userAge=" + getAge() +
                '}';
    }
}
