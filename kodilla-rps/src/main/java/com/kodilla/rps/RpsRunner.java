package com.kodilla.rps;

public class RpsRunner {


    public static void main(String[] args) {

        Game game = new Game();
        boolean end = false;

        gameloop:
        while (!end) {

            game.zeroPoints();
            game.inputNumberOfPointsToWin();
            System.out.println("     x - End Game  ***  n - New Game");
            System.out.println("1 -rock  ***  2 - paper  ***  3 - scissors\n" +
                    "       4 - lizard   ***   5 - Spock");
            game.setPlaying(true);

            roundloop:
            while (game.isPlaying()) {
                char choice = ' ';
                while (choice == ' ') {
                    choice = game.getUserInput("Shoot!", "xnXN12345");
                    if (choice == 'x' || choice == 'X') {
                        char quitOrNot = game.getUserInput("Exit? Are You sure? (y / n)",
                                "ynYN");
                        if (quitOrNot == 'Y' || quitOrNot == 'y') {
                            break gameloop;
                        } else {
                            choice = ' ';
                        }
                    }
                    if (choice == 'n' || choice == 'N') {
                        char newGameOrNot = game.getUserInput("New game? Are You sure you want to quit this game? (y / n)",
                                "ynYN");
                        if (newGameOrNot == 'y' || newGameOrNot == 'Y') {
                            game.setPlaying(false);
                            break roundloop;
                        } else {
                            choice = ' ';
                        }
                    }
                }

                game.playRound(game.charToMove(choice));

                if (game.isOver()) {
                    Player winner = game.getPlayer().getPoints() > game.getComputer().getPoints() ?
                            game.getPlayer() : game.getComputer();
                    System.out.println(winner.getName() + " wins! --> " +
                            game.getPlayer().getPoints() + " : " + game.getComputer().getPoints());
                    game.setPlaying(false);
                }
            }

            char playOrNot = game.getUserInput("New game - n *** Exit - x","XxNn");
            if (playOrNot == 'X' || playOrNot == 'x') {
                end = true;
                System.out.println("Bye, bye!");
            }
            //tu uruchamiam metodę którą stworzę "zamiast gameloop" (wewnątrz tej metody - rekurencja)
            //System.exit doczytać
        }
    }
}

