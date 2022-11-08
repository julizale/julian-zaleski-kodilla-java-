package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private final List<SudokuElement> sudokuElementList = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            sudokuElementList.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getSudokuElementList() {
        return sudokuElementList;
    }

}
