package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain
{
    public static void main(String[] args)
    {
        Forum myForum = new Forum();
        Map<Integer, ForumUser> myForumUserList =  myForum.getUserList().stream()
                .filter(forumUser -> forumUser.getUserSex() == 'M')
                .filter(forumUser -> forumUser.getAge() >= 20)
                .filter(forumUser -> forumUser.getUserPostsNumber() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));
        myForumUserList.entrySet().stream()
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }
}
