package core;

import java.util.stream.IntStream;

public class Task_6_4_11 {

    public static void main(String[] args) {
        pseudoRandomStream(13).limit(10).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((int)Math.pow(n,2))/10%1000);
    }
}
