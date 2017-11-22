package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task_4_1_11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        LinkedList<Integer> numbers = new LinkedList<>();
        if (n < 3) {
            System.out.println(1);
            System.out.println(n);
            return;
        }
        numbers.push(1);
        n -= 1;
        while (n >= numbers.peekLast() + 1) {
            numbers.add(numbers.peekLast() + 1);
            n -= numbers.peekLast();
        }
        if (n != 0) {
            numbers.add(numbers.pollLast() + n);
        }
        System.out.println(numbers.size());
        numbers.forEach(i -> System.out.print(i + " "));
    }
}

// 10.72 compl, my - 20~
//import java.util.Scanner;
//
//class Main {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int i = 1;
//
//        StringBuilder sb = new StringBuilder();
//
//        while ( n > 2 * i ) {
//            n -= i;
//            sb.append(i++ + " ");
//        }
//
//        sb.append(n);
//        System.out.println(i);
//        System.out.println(sb.toString());
//    }
//}