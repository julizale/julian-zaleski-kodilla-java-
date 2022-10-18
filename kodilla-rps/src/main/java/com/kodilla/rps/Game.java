package com.kodilla.rps;

import java.util.Random;

public class Game {

    private final UserInput userInput = new UserInput();
    private final Random generator = new Random();
    private final Player player;
    private final Player computer;
    private int numberOfPointsToWin;
    private boolean gameInterrupted;

    public Game() {
        this.player = new Player (userInput.askForPlayerName());
        this.computer = new Player("Computer");
    }

    public void initializeGame() {
        this.numberOfPointsToWin = userInput.askForNumberOfPointsToWin();
        gameInterrupted = false;
        player.setPoints(0);
        computer.setPoints(0);
        displayInstructions();
    }

    public void playRound(char choice) {

        Move playerMove = userInput.charToMove(choice);
        Move computerMove = generateRandomMove();

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

    public void runFinalProcedure() {
        if (gameInterrupted) { return; }
        char playOrNot = userInput.getUserInput("New game - n *** Exit - x","XxNn");
        if (playOrNot == 'X' || playOrNot == 'x') {
            quitGame();
        } else {
            newGame();
        }
        runFinalProcedure();
    }

    private void displayInstructions(){
        System.out.println("     x - End Game  ***  n - New Game");
        System.out.println("1 -rock  ***  2 - paper  ***  3 - scissors\n" +
                "       4 - lizard   ***   5 - Spock");
    }

    public void displayPoints() {
        System.out.println(player.getName() + ": " + player.getPoints() +
                " pts.  ***   " + computer.getName() + ": " + computer.getPoints() +
                " pts.");
    }

    public void displayWinner() {
        if (gameInterrupted) {
            return;
        }
        Player winner = player.getPoints() > computer.getPoints() ? player : computer;
        System.out.println(winner.getName() + " wins! --> " +
                player.getPoints() + " : " + computer.getPoints());
    }

    public boolean isOver () {
        return player.getPoints() == numberOfPointsToWin ||
                computer.getPoints() == numberOfPointsToWin ||
                gameInterrupted;
    }

    public void newGame() {
        char newGameOrNot = userInput.getUserInput("New game? Are You sure? (y / n)",
                "ynYN");
        if (newGameOrNot == 'y' || newGameOrNot == 'Y') {
            gameInterrupted = true;
        }
    }

    public void quitGame() {
        char quitOrNot = userInput.getUserInput("Exit? Are You sure? (y / n)",
                "ynYN");
        if (quitOrNot == 'Y' || quitOrNot == 'y') {
            System.exit(0);
        }
    }

    private Move generateRandomMove() {
        int randomInt = generator.nextInt(1, 6);
        return userInput.charToMove(Integer.toString(randomInt).charAt(0));
    }
}
