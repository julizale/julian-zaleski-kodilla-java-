package com.kodilla.exception.test;

import java.time.LocalDateTime;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(3,3));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            System.out.println("Method probablyIWillThrowException called " + LocalDateTime.now());
        }
    }

}
