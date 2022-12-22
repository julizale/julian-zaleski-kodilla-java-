package com.kodilla.sudoku;

public class UserResponse {

    private final int column;
    private final int row;
    private final int value;
    private final ResponseStatus responseStatus;


    public UserResponse(final int column, final int row, final int value, final ResponseStatus responseStatus) throws ValueOutOfBoundsException {
        if (column > 0 && column <=9 && row > 0 && row <=9 && value > 0 && value <=9) {
            this.column = column;
            this.row = row;
            this.value = value;
            this.responseStatus = responseStatus;
        } else throw new ValueOutOfBoundsException("Argument should be a digit from range 1-9");
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getValue() {
        return value;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }
}
