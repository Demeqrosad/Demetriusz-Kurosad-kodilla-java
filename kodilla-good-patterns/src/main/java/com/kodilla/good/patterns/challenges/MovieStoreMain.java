package com.kodilla.good.patterns.challenges;

public class MovieStoreMain
{
    public static void main(String[] args)
    {
        MovieStore movieStore = new MovieStore();
        movieStore.getMovies().entrySet().stream()
                .flatMap(titles->titles.getValue().stream())
                .map(title->title + "!")
                .forEach(System.out::printf);
    }
}
