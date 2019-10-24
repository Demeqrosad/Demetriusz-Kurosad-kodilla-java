package com.kodilla.stream.immutable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ForumUser
{
    private final String username;
    private final String realName;
    private final List<ForumUser> friends;
    private final LocalDate birthDate;

    public ForumUser(final String username, final String realName,
                     final ArrayList<ForumUser> friends, final LocalDate birthDate)
    {
        this.username = username;
        this.realName = realName;
        this.friends = new ArrayList<>(friends);
        this.birthDate = birthDate;
    }

    public String getUsername()
    {
        return this.username;
    }
    public String getRealName()
    {
        return this.realName;
    }
    public List<ForumUser> getFriends()
    {
        return new ArrayList<>(this.friends);
    }
    public LocalDate getBirthDate()
    {
        return LocalDate.parse(this.birthDate.toString());
    }
}
