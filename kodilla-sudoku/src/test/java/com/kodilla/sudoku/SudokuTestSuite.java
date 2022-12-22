package com.kodilla.sudoku;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SudokuTestSuite {

    @Test
    void testSudokuBoardToString() {
        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();

        //When
        String resultBoard = sudokuBoard.toString();
        System.out.println(resultBoard);
        String expectedBoard = """
                    1   2   3   4   5   6   7   8   9
                  -------------------------------------
                1 |   |   |   |   |   |   |   |   |   |
                  -------------------------------------
                2 |   |   |   |   |   |   |   |   |   |
                  -------------------------------------
                3 |   |   |   |   |   |   |   |   |   |
                  -------------------------------------
                4 |   |   |   |   |   |   |   |   |   |
                  -------------------------------------
                5 |   |   |   |   |   |   |   |   |   |
                  -------------------------------------
                6 |   |   |   |   |   |   |   |   |   |
                  -------------------------------------
                7 |   |   |   |   |   |   |   |   |   |
                  -------------------------------------
                8 |   |   |   |   |   |   |   |   |   |
                  -------------------------------------
                9 |   |   |   |   |   |   |   |   |   |
                  -------------------------------------
                """;

        //Then
        assertEquals(expectedBoard, resultBoard);
    }
}
