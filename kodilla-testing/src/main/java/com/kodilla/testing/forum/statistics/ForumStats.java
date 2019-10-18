package com.kodilla.testing.forum.statistics;

public class ForumStats
{
    private final int forumID;
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private int avrNumberOfPostsPerUser; //int, as double has no sense here
    private int avrNumberOfCommentsPerUser;
    private int avrNumberOfCommentsPerPost;

    public ForumStats(int forumID, Statistics statistics)
    {
        this.forumID = forumID;
        this.calculateAdvStatistics(statistics);
    }

    private void calculateAdvStatistics(Statistics statistics)
    {
        this.numberOfUsers = statistics.usersNames().size();
        this.numberOfPosts = statistics.postsCount();
        this.numberOfComments = statistics.commentsCount();
        if (this.numberOfUsers == 0)
        {
            this.avrNumberOfPostsPerUser = 0;
        }
        else
        {
            this.avrNumberOfPostsPerUser = (int) Math.round((double)this.numberOfPosts / (double)this.numberOfUsers);
        }
        if (this.numberOfUsers == 0)
        {
            this.avrNumberOfCommentsPerUser = 0;
        }
        else
        {
            this.avrNumberOfCommentsPerUser = (int) Math.round((double)this.numberOfComments / (double)this.numberOfUsers);
        }
        if (this.numberOfPosts == 0)
        {
            this.avrNumberOfCommentsPerPost = 0;
        }
        else
        {
            this.avrNumberOfCommentsPerPost = (int) Math.round((double)this.numberOfComments / (double)this.numberOfPosts);
        }
    }
    public void showStatistics()
    {
        System.out.println("ForumStats of forum ID = " + this.forumID
            + "\nNumber of users: " + this.numberOfUsers
            + "\nNumber of posts: " + this.numberOfPosts
            + "\nNumber of comments: " + this.numberOfComments
            + "\nAverage number of posts per user: " + this.avrNumberOfPostsPerUser
            + "\nAverage number of comments per user: " + this.avrNumberOfCommentsPerUser
            + "\nAverage number of comments per post: " + this.avrNumberOfCommentsPerPost);
    }

    //Getters
    public int getForumID()
    {
        return forumID;
    }

    public int getNumberOfUsers()
    {
        return numberOfUsers;
    }

    public int getNumberOfPosts()
    {
        return numberOfPosts;
    }

    public int getNumberOfComments()
    {
        return numberOfComments;
    }

    public int getAvrNumberOfPostsPerUser()
    {
        return avrNumberOfPostsPerUser;
    }

    public int getAvrNumberOfCommentsPerUser()
    {
        return avrNumberOfCommentsPerUser;
    }

    public int getAvrNumberOfCommentsPerPost()
    {
        return avrNumberOfCommentsPerPost;
    }
}
