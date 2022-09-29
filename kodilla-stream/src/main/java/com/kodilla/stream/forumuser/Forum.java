package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "thegodfather", 'M',
                LocalDate.of(1982, 8, 30), 78));
        userList.add(new ForumUser(2, "greentea", 'F',
                LocalDate.of(1912, 8, 30), 0));
        userList.add(new ForumUser(3, "pinecone", 'M',
                LocalDate.of(2004, 8, 30), 12));
        userList.add(new ForumUser(4, "thekidikirukidney", 'M',
                LocalDate.of(1996, 8, 30), 782));
        userList.add(new ForumUser(5, "pomegranatesunrise", 'M',
                LocalDate.of(2001, 8, 30), 0));
        userList.add(new ForumUser(6, "vforvendettavibrant", 'F',
                LocalDate.of(1982, 8, 30), 978));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
