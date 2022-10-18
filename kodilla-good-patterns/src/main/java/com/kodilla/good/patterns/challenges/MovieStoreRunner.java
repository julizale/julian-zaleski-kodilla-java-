package com.kodilla.good.patterns.challenges;

public class MovieStoreRunner {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        movieStore.getMovies().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .forEach(title -> System.out.print(title + " ! "));
        System.out.println("\b\b\b");
    }
}
