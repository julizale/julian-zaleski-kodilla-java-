package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userId;
    private final String name;
    private final char sex;
    private final LocalDate birthDate;
    private final int postQuantity;

    public ForumUser(final int userId, final String name, final char sex, final LocalDate birthDate,
                     final int postQuantity) {
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postQuantity = postQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostQuantity() {
        return postQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postQuantity=" + postQuantity +
                '}';
    }
}
