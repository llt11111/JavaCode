package main.streams;

import java.util.stream.IntStream;

public class NumbericStream {
    public static void main(String[] args) {
       IntStream.range(0,50)
                .boxed().mapToInt(Integer::intValue)
                .forEach(System.out::println);
    }
}
