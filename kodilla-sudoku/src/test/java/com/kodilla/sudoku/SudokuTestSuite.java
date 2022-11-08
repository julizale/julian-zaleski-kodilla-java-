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
                -------------------------------------
                |   |   |   |   |   |   |   |   |   |
                -------------------------------------
                |   |   |   |   |   |   |   |   |   |
                -------------------------------------
                |   |   |   |   |   |   |   |   |   |
                -------------------------------------
                |   |   |   |   |   |   |   |   |   |
                -------------------------------------
                |   |   |   |   |   |   |   |   |   |
                -------------------------------------
                |   |   |   |   |   |   |   |   |   |
                -------------------------------------
                |   |   |   |   |   |   |   |   |   |
                -------------------------------------
                |   |   |   |   |   |   |   |   |   |
                -------------------------------------
                |   |   |   |   |   |   |   |   |   |
                -------------------------------------
                """;

        //Then
        assertEquals(expectedBoard, resultBoard);
    }
}
