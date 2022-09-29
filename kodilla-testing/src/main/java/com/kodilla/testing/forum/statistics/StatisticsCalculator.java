package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;

    private double avgPostsPerUsr;
    private double avgCommentsPerUsr;
    private double avgCommentsPerPost;

    private boolean advStatisticsCalculated;

    public StatisticsCalculator() {
        advStatisticsCalculated = false;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAvgPostsPerUsr() {
        return avgPostsPerUsr;
    }

    public double getAvgCommentsPerUsr() {
        return avgCommentsPerUsr;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }

    public boolean isAdvStatisticsCalculated() {
        return advStatisticsCalculated;
    }

    public void calculateAdvStatistics(Statistics statistics) {

        numberOfPosts = statistics.postsCount();
        numberOfUsers = statistics.usersNames().size();
        numberOfComments = statistics.commentsCount();
        avgCommentsPerPost = numberOfPosts != 0 ? (double) numberOfComments / numberOfPosts : 0;
        avgCommentsPerUsr = numberOfUsers != 0 ? (double) numberOfComments / numberOfUsers : 0;
        avgPostsPerUsr = numberOfUsers != 0 ? (double) numberOfPosts / numberOfUsers : 0;
        advStatisticsCalculated = true;
    }

    public void showStatistics() {
        if (!advStatisticsCalculated) {
            System.out.println("Call calculateAdvStatistics first!");
            return;
        }
        System.out.println("Number of users: " + numberOfUsers);
        System.out.println("Number of posts: " + numberOfPosts);
        System.out.println("Number of comments: " + numberOfComments);
        System.out.println("Average posts for user: " + avgPostsPerUsr);
        System.out.println("Average comments for user: " + avgCommentsPerUsr);
        System.out.println("Average comments for post: " + avgCommentsPerPost);
    }

}
