package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;
    private final Random generator;
    private final Player player;
    private final Player computer;
    private int numberOfPointsToWin;
    private boolean isPlaying = false;

    public Game() {
        scanner = new Scanner(System.in);
        System.out.println("Hello! Let's play Rock-Paper-Scissors-Lizard-Spock!");
        System.out.println("My name is Computer. What's Your name?");
        String playerName = scanner.nextLine();
        System.out.println("Hello " + playerName + "! Nice to meet You.");
        if (playerName.length() > 10) {
            playerName = playerName.substring(0, 10);
            System.out.println("Your name is very long. May I call You " +
                    playerName + "? It was a rhetorical question...");
        }
        this.player = new Player (playerName);
        computer = new Player("Computer");
        numberOfPointsToWin = 0;
        generator = new Random();
    }

    public void inputNumberOfPointsToWin() {
        numberOfPointsToWin = 0;
        System.out.println("How many points to win? Enter 1-5");
        while (numberOfPointsToWin < 1 || numberOfPointsToWin > 5) {
            numberOfPointsToWin = scanner.nextInt();
        }
    }

    public char getUserInput (String message, String charactersAllowed) {
        System.out.println(message);
        char choice = ' ';
        while (charactersAllowed.indexOf(choice) == -1) {
            choice = scanner.next().charAt(0);
        }
        return choice;
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

    public void playRound(Move playerMove) {
        int randomInt = generator.nextInt(1, 6);
        Move computerMove = charToMove(Integer.toString(randomInt).charAt(0));

        System.out.println(player.getName() + " --> " + playerMove + "  ***  " +
                computerMove + " <-- " + computer.getName());

        if (computerMove.equals(playerMove)) {
            System.out.println("Draw!");
            displayPoints();
            return;
        }
        if(playerMove.beats(computerMove)) {
            System.out.println(player.getName() + " wins!");
            player.setPoints(player.getPoints() + 1);
        } else {
            System.out.println(computer.getName() + " wins!");
            computer.setPoints(computer.getPoints() + 1);
        }
        displayPoints();
    }

    public void displayPoints() {
        System.out.println(player.getName() + ": " + player.getPoints() +
                " pts.  ***   " + computer.getName() + ": " + computer.getPoints() +
                " pts.");
    }

    public boolean isOver () {
        return player.getPoints() == numberOfPointsToWin ||
                computer.getPoints() == numberOfPointsToWin;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getComputer() {
        return computer;
    }

    public void zeroPoints () {
        player.setPoints(0);
        computer.setPoints(0);
    }
}
