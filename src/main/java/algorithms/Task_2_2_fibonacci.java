package algorithms;

import java.util.Scanner;

public class Task_2_2_fibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a = 0;
        int b = 1;
        int c;
        for (int i = 0; i < n; i++) {
            c = b;
            b = (a + b) % 10;
            a = c;
        }
        System.out.println(a);
    }
}