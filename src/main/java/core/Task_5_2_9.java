package core;

import java.io.*;

public class Task_5_2_9 {
    public static void main(String[] args) throws IOException {
        int data;
        int[] a = {0, 0};
        int first = 0;
        while ((data = System.in.read()) != -1) {
            a[0] = a[1];
            a[1] = data;

            if (!(a[0] == 13 && a[1] == 10)) {
                if (first == 1) {
                    System.out.write(a[0]);
                } else {
                    first = 1;
                }
            }
        }
        if (first == 1) {
            System.out.write(a[1]);
            System.out.flush();
        }
    }
}

