package algorithms;

import java.util.Scanner;

public class Task_6_4_5_merge_count_of_inversions {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] data = new long[n];
        for (int i = 0; i < n; i++) {
            data[i] = s.nextLong();
        }
        long result = mergeSort(data, 0, n - 1);
        System.out.println(result);
    }

    private static long mergeSort(long[] data, int l, int r) {
        long curJumps = 0;

        if (l == r) {
            return curJumps;
        }
        int mid = l + (r - l) / 2;
        curJumps += mergeSort(data, l, mid);
        curJumps += mergeSort(data, mid + 1, r);

        curJumps += merge(data, l, mid, r);
        return curJumps;
    }

    private static long merge(long[] data, int l, int mid, int r) {
        long curJumps = 0;
        long[] buf = new long[r - l + 1];
        int pos1 = l;
        int pos2 = mid + 1;
        int posB = 0;

        while (pos1 <= mid && pos2 <= r) {
            if (data[pos1] <= data[pos2]) {
                buf[posB++] = data[pos1++];
            } else {
                buf[posB++] = data[pos2++];
                curJumps += mid - pos1 + 1;
            }
        }

        while (pos1 <= mid) {
            buf[posB++] = data[pos1++];
        }

        while (pos2 <= r) {
            buf[posB++] = data[pos2++];
        }
        System.arraycopy(buf, 0, data, l, buf.length);
        return curJumps;
    }
}
