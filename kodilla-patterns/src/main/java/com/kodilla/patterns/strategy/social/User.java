package com.kodilla.patterns.strategy.social;

public class User
{
    private final String userName;
    protected SocialPublisher preferredSocialMedium;

    public User(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public SocialPublisher getPreferredSocialMedium()
    {
        return this.preferredSocialMedium;
    }

    public void setPreferredSocialMedium(SocialPublisher preferredSocialMedium)
    {
        this.preferredSocialMedium = preferredSocialMedium;
    }

    public String sharePost()
    {
        return this.getUserName() + this.getPreferredSocialMedium().share();
    }
}
