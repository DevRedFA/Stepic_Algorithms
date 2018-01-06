package algorithms;

import java.util.Scanner;

public class Task_6_4_5_native_count_of_inversions {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] data = new long[n];
        for (int i = 0; i < n; i++) {
            data[i] = s.nextLong();
        }
        long result = nativeCount(data, 0, n - 1);
        System.out.println(result);
    }

    private static long nativeCount(long[] data, int l, int r) {
        long count = 0;
        for (int i = l; i < r; i++) {
            for (int j = i + 1; j <= r; j++) {
                if (data[i] > data[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
