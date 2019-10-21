package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum
{
    private final List<ForumUser> userList = new ArrayList<ForumUser>();

    public List<ForumUser> getUserList()
    {
        userList.add(new ForumUser(1,"User1",'M',
                LocalDate.of(2000,3,14), 3));
        userList.add(new ForumUser(2,"User2",'F',
                LocalDate.of(1998,7,23), 2));
        userList.add(new ForumUser(3,"User3",'F',
                LocalDate.of(2000,9,6), 0));
        userList.add(new ForumUser(4,"User4",'M',
                LocalDate.of(1997,2,21), 1));
        userList.add(new ForumUser(5,"User5",'M',
                LocalDate.of(1995,11,3), 0));
        userList.add(new ForumUser(6,"User6",'F',
                LocalDate.of(1998,9,10), 2));
        return new ArrayList<>(userList);
    }
}
