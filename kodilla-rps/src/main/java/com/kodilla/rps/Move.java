package com.kodilla.rps;

public enum Move {
    ROCK,
    PAPER,
    SCISSORS,
    LIZARD,
    SPOCK;

    public boolean beats (Move opponentMove) {
        switch (this) {
            case ROCK:
                return opponentMove == SCISSORS || opponentMove == LIZARD;
            case PAPER:
                return opponentMove == ROCK || opponentMove == SPOCK;
            case SCISSORS:
                return opponentMove == PAPER || opponentMove == LIZARD;
            case SPOCK:
                return opponentMove == SCISSORS || opponentMove == ROCK;
            case LIZARD:
                return opponentMove == SPOCK || opponentMove == PAPER;
            default:
                return false;
        }
    }
}
