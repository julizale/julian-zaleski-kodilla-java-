package com.kodilla.sudoku;

import java.util.Scanner;

public class UserInput {

    Scanner scanner = new Scanner(System.in);

    public UserResponse getInput() throws ValueOutOfBoundsException {

        while (true) {

            System.out.println("""
                    * Enter three digits representing column, row, and value
                      from range 1-9, i.e. '679' for column 6, row 7, and value 9
                    * Or type SUDOKU to resolve the game
                    * Or type END to end the game""");
            String inputString = scanner.nextLine();

            if (inputString.length() > 2 &&
                    (inputString.startsWith("END") || inputString.startsWith("end"))) {
                return new UserResponse(1,1,1, ResponseStatus.ENDGAME);
            }

            if (inputString.length() > 5 &&
                    (inputString.startsWith("SUDOKU") || inputString.startsWith("sudoku"))) {
                return new UserResponse(1,1,1, ResponseStatus.SUDOKU);
            }

            if (inputString.length()>2) {
                String charactersAllowed = "123456789";
                boolean inputIsValid = true;
                for (int i = 0; i < 3 ; i++) {
                    if (charactersAllowed.indexOf(inputString.charAt(i)) == -1) {
                        inputIsValid = false;
                        break;
                    }
                }
                if (inputIsValid) {
                    return new UserResponse(
                            Character.getNumericValue(inputString.charAt(0)),
                            Character.getNumericValue(inputString.charAt(1)),
                            Character.getNumericValue(inputString.charAt(2)),
                            ResponseStatus.COORDINATES_VALUE
                    );
                }
            }
            System.out.println("Choose one of below options:");
        }
    }

}
