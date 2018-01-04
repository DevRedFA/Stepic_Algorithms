package algorithms;

import java.util.Scanner;

public class Task_6_1_4_binary_search {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] data = new long[n];
        for (int i = 0; i < n; i++) {
            data[i] = s.nextInt();
        }
        int nSearch = s.nextInt();
        long[] dataForSearch = new long[nSearch];
        for (int i = 0; i < nSearch; i++) {
            dataForSearch[i] = s.nextInt();
        }
        StringBuilder result = new StringBuilder(nSearch * 2);

        for (int i = 0; i < nSearch; i++) {
            result.append(binarySearch(data, dataForSearch[i]) + 1).append(" ");

        }
        System.out.println(result.subSequence(0, result.length() - 1).toString());

        Thread.sleep(100);
    }

    private static int binarySearch(long[] data, long number) {
        int l = 0;
        int r = data.length-1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid] == number) return mid;
            if (data[mid] > number) {
                r = mid - 1;
            }
            if (data[mid] < number) {
                l = mid + 1;
            }
        }
        return -2;
    }
}
