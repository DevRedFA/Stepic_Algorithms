package algorithms;

import java.util.Scanner;

public class Task_6_8_3_countSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] data = new int[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = s.nextInt();
        }
        int[] keys = new int[11];
        for (int i = 0; i < n; i++) {
            keys[data[i]]++;
        }
        for (int i = 1; i < keys.length; i++) {
            keys[i] += keys[i - 1];
        }
        for (int i = 0; i < n; i++) {
            result[--keys[data[i]]] = data[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
