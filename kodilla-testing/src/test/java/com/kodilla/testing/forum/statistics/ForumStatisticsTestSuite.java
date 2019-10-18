package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ForumStatisticsTestSuite
{
    @Test
    public void testPostsNumber0()
    {
        //Given
        ForumStats testForumStats;
        Statistics statisticsMock = mock(Statistics.class);
        List<String> testUsers = mock(ArrayList.class);
        int testNumberOfUsers = 12;
        int testNumberOfPosts = 0;
        int testNumberOfComments = 0;
        when(testUsers.size()).thenReturn(testNumberOfUsers);
        when(statisticsMock.usersNames()).thenReturn(testUsers);
        when(statisticsMock.postsCount()).thenReturn(testNumberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(testNumberOfComments);
        Integer[] expResult = {testNumberOfUsers,testNumberOfPosts,testNumberOfComments,
                (int)Math.round((double)testNumberOfPosts/(double)testNumberOfUsers),
                (int)Math.round((double)testNumberOfComments/(double)testNumberOfUsers),
                0};
        Integer[] actResult;
        testForumStats = new ForumStats(1, statisticsMock);
        System.out.println("Test Case: Posts number = 0");
        testForumStats.showStatistics();
        //When
        actResult = new Integer[]{testForumStats.getNumberOfUsers(),
                    testForumStats.getNumberOfPosts(),
                    testForumStats.getNumberOfComments(),
                    testForumStats.getAvrNumberOfPostsPerUser(),
                    testForumStats.getAvrNumberOfCommentsPerUser(),
                    testForumStats.getAvrNumberOfCommentsPerPost()};
        //Then
        Assert.assertEquals(expResult, actResult);
    }
    @Test
    public void testPostsNumber1000()
    {
        //Given
        ForumStats testForumStats;
        Statistics statisticsMock = mock(Statistics.class);
        List<String> testUsers = mock(ArrayList.class);
        int testNumberOfUsers = 60;
        int testNumberOfPosts = 1000;
        int testNumberOfComments = 2500;
        when(testUsers.size()).thenReturn(testNumberOfUsers);
        when(statisticsMock.usersNames()).thenReturn(testUsers);
        when(statisticsMock.postsCount()).thenReturn(testNumberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(testNumberOfComments);
        Integer[] expResult = {testNumberOfUsers,testNumberOfPosts,testNumberOfComments,
                (int)Math.round((double)testNumberOfPosts/(double)testNumberOfUsers),
                (int)Math.round((double)testNumberOfComments/(double)testNumberOfUsers),
                (int)Math.round((double)testNumberOfComments/(double)testNumberOfPosts)};
        Integer[] actResult;
        testForumStats = new ForumStats(2, statisticsMock);
        System.out.println("Test Case: Posts number = 1000");
        testForumStats.showStatistics();
        //When
        actResult = new Integer[]{testForumStats.getNumberOfUsers(),
                testForumStats.getNumberOfPosts(),
                testForumStats.getNumberOfComments(),
                testForumStats.getAvrNumberOfPostsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerPost()};
        //Then
        Assert.assertEquals(expResult, actResult);
    }
    @Test
    public void testCommentsNumber0()
    {
        //Given
        ForumStats testForumStats;
        Statistics statisticsMock = mock(Statistics.class);
        List<String> testUsers = mock(ArrayList.class);
        int testNumberOfUsers = 60;
        int testNumberOfPosts = 800;
        int testNumberOfComments = 0;
        when(testUsers.size()).thenReturn(testNumberOfUsers);
        when(statisticsMock.usersNames()).thenReturn(testUsers);
        when(statisticsMock.postsCount()).thenReturn(testNumberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(testNumberOfComments);
        Integer[] expResult = {testNumberOfUsers,testNumberOfPosts,testNumberOfComments,
                (int)Math.round((double)testNumberOfPosts/(double)testNumberOfUsers),
                (int)Math.round((double)testNumberOfComments/(double)testNumberOfUsers),
                (int)Math.round((double)testNumberOfComments/(double)testNumberOfPosts)};
        Integer[] actResult;
        testForumStats = new ForumStats(3, statisticsMock);
        System.out.println("Test Case: Comments number = 0");
        testForumStats.showStatistics();
        //When
        actResult = new Integer[]{testForumStats.getNumberOfUsers(),
                testForumStats.getNumberOfPosts(),
                testForumStats.getNumberOfComments(),
                testForumStats.getAvrNumberOfPostsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerPost()};
        //Then
        Assert.assertEquals(expResult, actResult);
    }
    @Test
    public void testCommentsNumberSmallerThenPosts()
    {
        //Given
        ForumStats testForumStats;
        Statistics statisticsMock = mock(Statistics.class);
        List<String> testUsers = mock(ArrayList.class);
        int testNumberOfUsers = 60;
        int testNumberOfPosts = 800;
        int testNumberOfComments = 600;
        when(testUsers.size()).thenReturn(testNumberOfUsers);
        when(statisticsMock.usersNames()).thenReturn(testUsers);
        when(statisticsMock.postsCount()).thenReturn(testNumberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(testNumberOfComments);
        Integer[] expResult = {testNumberOfUsers,testNumberOfPosts,testNumberOfComments,
                (int)Math.round((double)testNumberOfPosts/(double)testNumberOfUsers),
                (int)Math.round((double)testNumberOfComments/(double)testNumberOfUsers),
                (int)Math.round((double)testNumberOfComments/(double)testNumberOfPosts)};
        Integer[] actResult;
        testForumStats = new ForumStats(4, statisticsMock);
        System.out.println("Test Case: Comments number < posts number");
        testForumStats.showStatistics();
        //When
        actResult = new Integer[]{testForumStats.getNumberOfUsers(),
                testForumStats.getNumberOfPosts(),
                testForumStats.getNumberOfComments(),
                testForumStats.getAvrNumberOfPostsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerPost()};
        //Then
        Assert.assertEquals(expResult, actResult);
    }
    @Test
    public void testCommentsNumberGreaterThenPosts()
    {
        //Given
        ForumStats testForumStats;
        Statistics statisticsMock = mock(Statistics.class);
        List<String> testUsers = mock(ArrayList.class);
        int testNumberOfUsers = 60;
        int testNumberOfPosts = 800;
        int testNumberOfComments = 1000;
        when(testUsers.size()).thenReturn(testNumberOfUsers);
        when(statisticsMock.usersNames()).thenReturn(testUsers);
        when(statisticsMock.postsCount()).thenReturn(testNumberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(testNumberOfComments);
        Integer[] expResult = {testNumberOfUsers,testNumberOfPosts,testNumberOfComments,
                (int)Math.round((double)testNumberOfPosts/(double)testNumberOfUsers),
                (int)Math.round((double)testNumberOfComments/(double)testNumberOfUsers),
                (int)Math.round((double)testNumberOfComments/(double)testNumberOfPosts)};
        Integer[] actResult;
        testForumStats = new ForumStats(5, statisticsMock);
        System.out.println("Test Case: Comments number > posts number");
        testForumStats.showStatistics();
        //When
        actResult = new Integer[]{testForumStats.getNumberOfUsers(),
                testForumStats.getNumberOfPosts(),
                testForumStats.getNumberOfComments(),
                testForumStats.getAvrNumberOfPostsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerPost()};
        //Then
        Assert.assertEquals(expResult, actResult);
    }
    @Test
    public void testUsersNumber0()
    {
        //Given
        ForumStats testForumStats;
        Statistics statisticsMock = mock(Statistics.class);
        List<String> testUsers = mock(ArrayList.class);
        int testNumberOfUsers = 0;
        int testNumberOfPosts = 0;
        int testNumberOfComments = 0;
        when(testUsers.size()).thenReturn(testNumberOfUsers);
        when(statisticsMock.usersNames()).thenReturn(testUsers);
        when(statisticsMock.postsCount()).thenReturn(testNumberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(testNumberOfComments);
        Integer[] expResult = {testNumberOfUsers,testNumberOfPosts,testNumberOfComments,
                0,
                0,
                0};
        Integer[] actResult;
        testForumStats = new ForumStats(6, statisticsMock);
        System.out.println("Test Case: Users number = 0");
        testForumStats.showStatistics();
        //When
        actResult = new Integer[]{testForumStats.getNumberOfUsers(),
                testForumStats.getNumberOfPosts(),
                testForumStats.getNumberOfComments(),
                testForumStats.getAvrNumberOfPostsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerPost()};
        //Then
        Assert.assertEquals(expResult, actResult);
    }
    @Test
    public void testUsersNumber100()
    {
        //Given
        ForumStats testForumStats;
        Statistics statisticsMock = mock(Statistics.class);
        List<String> testUsers = mock(ArrayList.class);
        int testNumberOfUsers = 100;
        int testNumberOfPosts = 800;
        int testNumberOfComments = 1000;
        when(testUsers.size()).thenReturn(testNumberOfUsers);
        when(statisticsMock.usersNames()).thenReturn(testUsers);
        when(statisticsMock.postsCount()).thenReturn(testNumberOfPosts);
        when(statisticsMock.commentsCount()).thenReturn(testNumberOfComments);
        Integer[] expResult = {testNumberOfUsers,testNumberOfPosts,testNumberOfComments,
                (int)Math.round((double)testNumberOfPosts/(double)testNumberOfUsers),
                (int)Math.round((double)testNumberOfComments/(double)testNumberOfUsers),
                (int)Math.round((double)testNumberOfComments/(double)testNumberOfPosts)};
        Integer[] actResult;
        testForumStats = new ForumStats(7, statisticsMock);
        System.out.println("Test Case: Users number = 100");
        testForumStats.showStatistics();
        //When
        actResult = new Integer[]{testForumStats.getNumberOfUsers(),
                testForumStats.getNumberOfPosts(),
                testForumStats.getNumberOfComments(),
                testForumStats.getAvrNumberOfPostsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerUser(),
                testForumStats.getAvrNumberOfCommentsPerPost()};
        //Then
        Assert.assertEquals(expResult, actResult);
    }
}
