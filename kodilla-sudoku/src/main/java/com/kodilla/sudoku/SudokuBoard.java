package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    private final List<SudokuRow> sudokuRowList = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            sudokuRowList.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getSudokuRowList() {
        return sudokuRowList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(1600);
        stringBuilder.append("-------------------------------------\n");
        for (SudokuRow sudokuRow: sudokuRowList) {
            stringBuilder.append("|");
            for (SudokuElement sudokuElement: sudokuRow.getSudokuElementList()) {
                stringBuilder.append(sudokuElement.toString());
                stringBuilder.append("|");
            }
            stringBuilder.append("\n-------------------------------------\n");
        }
        return stringBuilder.toString();
    }
}
