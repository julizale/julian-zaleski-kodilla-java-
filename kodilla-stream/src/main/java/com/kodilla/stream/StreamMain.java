package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();
        Map<Integer, ForumUser> resultUsersMap = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M'
                        && user.getBirthDate().plusYears(20).isBefore(LocalDate.now())
                        && user.getPostQuantity() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        System.out.println("Number of entries in result map: " + resultUsersMap.size());
        resultUsersMap.entrySet().stream()
                .forEach(entry -> System.out.println("User # " + entry.getKey() + " " + entry.getValue()));
    }

}