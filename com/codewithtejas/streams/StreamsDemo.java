package com.codewithtejas.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        //StreamsDemo.show();
        // StreamsDemo.showStream();
        StreamsDemo.showSlice();
    }

    public static void showSlice() {
        var movies = List.of(
                new Movie("avatar", 20),
                new Movie("pokemon", 12),
                new Movie("annabelle", 19)
        );

        /*
        * 1000 movies list
        * 10 movies per page --> pageSize
        * 3rd page --> skip(20)
        * skip( (page - 1) x pageSize )
        * */
        movies.stream()
                .skip(2)
                // .peek(System.out::println)
                .forEach(movie -> System.out.println(movie.getTitle()));
    }

    // streams example
    public static void showStream() {
        var stream = Stream.generate(Math::random);
        stream
                .limit(4)
                .forEach(System.out::println);
    }

    // imperative and declarative count example
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("robot", 12),
                new Movie("interstellar", 20),
                new Movie("3 idiots", 8)
        );

        // imperative programming | how something is done
        int count = 0;
        for (var item : movies)
            if (item.getLikes() > 10)
                count++;
        System.out.println("Imperative Count: " + count);

        // declarative (functional) programming | what is to be done
        var count2 = movies.stream().filter(movie -> movie.getLikes() > 10).count();
        System.out.println("Declarative Count: " + count2);

    }
}
