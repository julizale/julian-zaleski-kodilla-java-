package com.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {

        UserInput userInput = new UserInput();
        Game game = new Game();

        while (true) {

            game.initializeGame();

            while (!game.isOver()) {
                char choice = userInput.getUserInput("Shoot!", "xnXN12345");
                switch (choice) {
                    case 'x', 'X' -> game.quitGame();
                    case 'n', 'N' -> game.newGame();
                    case '1','2','3','4','5' -> game.playRound(choice);
                    default -> throw new IllegalArgumentException("Invalid char: " + choice);
                }
            }
            game.displayWinner();
            game.runFinalProcedure();
        }
    }
}
