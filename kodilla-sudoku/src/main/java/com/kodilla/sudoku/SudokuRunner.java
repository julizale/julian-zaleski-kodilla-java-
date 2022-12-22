package com.kodilla.sudoku;

public class SudokuRunner {

    public static void main(String[] args) throws ValueOutOfBoundsException {

        SudokuBoard sudokuBoard = new SudokuBoard();
        UserInput userInput = new UserInput();

        while (true) {
            System.out.println(sudokuBoard);
            UserResponse userResponse = userInput.getInput();
            switch (userResponse.getResponseStatus()) {
                case ENDGAME -> System.exit(0);
                case SUDOKU -> System.exit(0);
                case COORDINATES_VALUE -> System.exit(0);
            }
        }


    }
}
