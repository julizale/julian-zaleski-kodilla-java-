package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    private List<String> generateListOfNUsersNames(int usersQuantity) {
        List<String> resultList = new ArrayList<>();
        for (int n = 1; n <= usersQuantity; n++) {
            String userName = "Stefan Stefanik " + n;
            resultList.add(userName);
        }
        return resultList;
    }

    @BeforeEach
    public void beforeEachTest() {
        statisticsMock = mock(Statistics.class);
    }

    @Test
    void testCalculateAdvStatisticsWhen0Posts() {
        //Given
        StatisticsCalculator calculator = new StatisticsCalculator();
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsersNames(16));

        //When
        calculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, calculator.getAvgPostsPerUsr());
        assertEquals(0, calculator.getAvgCommentsPerUsr());
        assertEquals(0, calculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhen1000Posts() {
        //Given
        StatisticsCalculator calculator = new StatisticsCalculator();
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(200);
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsersNames(16));

        //When
        calculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(62.5, calculator.getAvgPostsPerUsr());
        assertEquals(12.5, calculator.getAvgCommentsPerUsr());
        assertEquals(0.2, calculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhen0Comments() {
        //Given
        StatisticsCalculator calculator = new StatisticsCalculator();
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsersNames(16));

        //When
        calculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(62.5, calculator.getAvgPostsPerUsr());
        assertEquals(0, calculator.getAvgCommentsPerUsr());
        assertEquals(0, calculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhenMoreCommentsThanPosts() {
        //Given
        StatisticsCalculator calculator = new StatisticsCalculator();
        when(statisticsMock.postsCount()).thenReturn(160);
        when(statisticsMock.commentsCount()).thenReturn(420);
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsersNames(16));

        //When
        calculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, calculator.getAvgPostsPerUsr());
        assertEquals(26.25, calculator.getAvgCommentsPerUsr());
        assertEquals(2.625, calculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhenMorePostsThanComments() {
        //Given
        StatisticsCalculator calculator = new StatisticsCalculator();
        when(statisticsMock.postsCount()).thenReturn(240);
        when(statisticsMock.commentsCount()).thenReturn(80);
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsersNames(16));

        //When
        calculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(15, calculator.getAvgPostsPerUsr());
        assertEquals(5, calculator.getAvgCommentsPerUsr());
        assertEquals(0.3333333333333333, calculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhen0Users() {
        //Given
        StatisticsCalculator calculator = new StatisticsCalculator();
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsersNames(0));

        //When
        calculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, calculator.getAvgPostsPerUsr());
        assertEquals(0, calculator.getAvgCommentsPerUsr());
        assertEquals(0, calculator.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhen1000Users() {
        //Given
        StatisticsCalculator calculator = new StatisticsCalculator();
        when(statisticsMock.postsCount()).thenReturn(240);
        when(statisticsMock.commentsCount()).thenReturn(80);
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsersNames(1000));

        //When
        calculator.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0.24, calculator.getAvgPostsPerUsr());
        assertEquals(0.08, calculator.getAvgCommentsPerUsr());
        assertEquals(0.3333333333333333, calculator.getAvgCommentsPerPost());
    }

}
