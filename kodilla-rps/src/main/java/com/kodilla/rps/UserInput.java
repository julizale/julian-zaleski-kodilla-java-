package com.kodilla.rps;

import java.util.Scanner;

public class UserInput {

    private final Scanner scanner = new Scanner(System.in);
    public char getUserInput (String message, String charactersAllowed) {
        System.out.println(message);
        char inputChar = '!';
        while (charactersAllowed.indexOf(inputChar) == -1) {
            inputChar = scanner.next().charAt(0);
        }
        return inputChar;
    }

    public Move charToMove(char input) {
        Move move = null;
        switch (input) {
            case '1' -> move = Move.ROCK;
            case '2' -> move = Move.PAPER;
            case '3' -> move = Move.SCISSORS;
            case '4' -> move = Move.LIZARD;
            case '5' -> move = Move.SPOCK;
        }
        return move;
    }

    public String askForPlayerName () {
        System.out.println("Hello! Let's play Rock-Paper-Scissors-Lizard-Spock!");
        System.out.println("My name is Computer. What's Your name?");
        String playerName = scanner.nextLine();
        System.out.println("Hello " + playerName + "! Nice to meet You.");
        if (playerName.length() > 10) {
            playerName = playerName.substring(0, 10);
            System.out.println("Your name is very long. May I call You " +
                    playerName + "? It was a rhetorical question...");
        }
        return playerName;
    }

    public int askForNumberOfPointsToWin() {
        char input = getUserInput("How many points to win? Enter 1-5", "12345");
        return Character.getNumericValue(input);
    }
}
