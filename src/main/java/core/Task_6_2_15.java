package core;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_6_2_15 {
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int count = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                final int i = sc.nextInt();
                if (count++ % 2 == 1) {
                    list.add(i);
                }
            }
        }
        list.descendingIterator().forEachRemaining(s -> System.out.print(s + " "));
    }
}

