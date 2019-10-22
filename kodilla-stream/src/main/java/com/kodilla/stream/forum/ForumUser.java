package com.kodilla.stream.forum;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class ForumUser
{
    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    public ForumUser(final String username, final String realName, final String location)
    {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    public void addFriend(ForumUser user)
    {
        this.friends.add(user);
    }

    public boolean removeFriend(ForumUser user)
    {
        return this.friends.remove(user);
    }

    public Set<String> getLocationsOfFriends()
    {
        return this.friends.stream()
                .map(friend -> friend.getLocation())
                .collect(Collectors.toSet());
    }

    public Set<String> getLocationsOfFriendsOfFriends()
    {
        return this.friends.stream()
                .flatMap(user -> user.getFriends().stream())
                .filter(user -> user != this)
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }
    //Getters
    public String getUsername()
    {
        return this.username;
    }

    public String getRealName()
    {
        return this.realName;
    }

    public String getLocation()
    {
        return this.location;
    }

    public Set<ForumUser> getFriends()
    {
        return this.friends;
    }

    @Override
    public String toString()
    {
        return "ForumUser{" +
                "username='" + this.username + '\'' +
                ", realName='" + this.realName + '\'' +
                ", location='" + this.location + '\'' +
                ", friends=" + this.friends +
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

        ForumUser forumUser = (ForumUser) o;

        return this.getUsername().equals(forumUser.getUsername());
    }

    @Override
    public int hashCode()
    {
        return this.getUsername().hashCode();
    }
}
