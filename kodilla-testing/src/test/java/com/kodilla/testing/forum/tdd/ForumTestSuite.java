package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Beginning tests...");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("End of testing.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Beginning test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    class TestPosts {

        @Test
        void testAddPost() {
            //Given
            ForumUser user = new ForumUser("mrSmith", "John Smith");

            //When
            user.addPost("mrSmith", "Hello everybody, this is my first post!");

            //Then
            Assertions.assertEquals(1, user.getPostsQuantity());
        }

        @Test
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everybody, this is my first post!", "mrSmith");
            forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());

            //When
            ForumPost retrievedPost = forumUser.getPost(0);

            //Then
            Assertions.assertEquals(forumPost, retrievedPost);
        }

        @Test
        void testRemovePostNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everybody, this is my first post!", "mrSmith");

            //When
            boolean result = forumUser.removePost(forumPost);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemovePost() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everybody, this is my first post!", "mrSmith");
            forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());

            //When
            boolean result = forumUser.removePost(forumPost);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }

    }

    @Nested
    @DisplayName("Tests for comments")
    class TestsForComments {

        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everybody, this is my first post!", "mrSmith");

            //When
            forumUser.addComment(forumPost, "mrSmith", "Hello!");

            //Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everybody, this is my first post!", "mrSmith");
            ForumComment forumComment = new ForumComment(forumPost, "This is comment", "mrSmith");
            forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());

            //When
            ForumComment retrievedComment = forumUser.getComment(0);

            //Then
            Assertions.assertEquals(forumComment, retrievedComment);
        }

        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everybody, this is my first post!", "mrSmith");
            ForumComment forumComment = new ForumComment(forumPost, "This is comment", "mrSmith");

            //When
            boolean result = forumUser.removeComment(forumComment);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost forumPost = new ForumPost("Hello everybody, this is my first post!", "mrSmith");
            ForumComment forumComment = new ForumComment(forumPost, "This is comment", "mrSmith");
            forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());

            //When
            boolean result = forumUser.removeComment(forumComment);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }

    }

}
