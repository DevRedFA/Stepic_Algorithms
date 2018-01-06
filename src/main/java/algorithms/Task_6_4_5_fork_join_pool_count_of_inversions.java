package algorithms;

import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

public class Task_6_4_5_fork_join_pool_count_of_inversions {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] data = new long[n];
        for (int i = 0; i < n; i++) {
            data[i] = s.nextLong();
        }
        Long result = new MergeSortTask(data, 0, n - 1).compute();
        System.out.println(result);
    }

    static class MergeSortTask extends RecursiveTask<Long> {
        long[] data;
        long curJumps = 0;
        int l;
        int r;

        public MergeSortTask(long[] data, int l, int r) {
            this.data = data;
            this.l = l;
            this.r = r;
        }

        @Override
        protected Long compute() {
            if (l == r) {
                return curJumps;
            }
            int mid = l + (r - l) / 2;
            MergeSortTask mergeSortTask = new MergeSortTask(data, l, mid);
            mergeSortTask.fork();

            MergeSortTask mergeSortTask1 = new MergeSortTask(data, mid + 1, r);
            mergeSortTask1.fork();

            curJumps += mergeSortTask1.join();
            curJumps += mergeSortTask.join();

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
}
