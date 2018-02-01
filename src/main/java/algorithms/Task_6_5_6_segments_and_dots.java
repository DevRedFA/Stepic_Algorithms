package algorithms;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_6_5_6_segments_and_dots {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); //segments
        int m = s.nextInt(); //dots
        Segment[] segments = new Segment[n];
        int[] result = new int[m];
        for (int i = 0; i < n; i++) {
            segments[i] = new Segment(s.nextInt(), s.nextInt());
        }
        int[] dots = new int[m];
        for (int i = 0; i < m; i++) {
            dots[i] = s.nextInt();
        }

        Arrays.parallelSort(segments);
//        quickSort(segments);

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (segments[j].l <= dots[i] && segments[j].r >= dots[i]) {
                    result[i]++;
                }
            }
        }
         String collect = Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    static class Segment implements Comparable<Segment> {
        int l;
        int r;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Segment segment = (Segment) o;
            return l == segment.l;
        }

        @Override
        public int hashCode() {

            return Objects.hash(l);
        }

        public Segment(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Segment o) {
            return Integer.compare(this.l, o.l);
        }
    }

    public static void quickSort(Segment[] intArray) {
        recQuickSort(intArray, 0, intArray.length - 1);
    }

    public static void recQuickSort(Segment[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(intArray, left, right);
        else {
            double median = medianOf3(intArray, left, right);
            int partition = partitionIt(intArray, left, right, median);
            recQuickSort(intArray, left, partition - 1);
            recQuickSort(intArray, partition + 1, right);
        }
    }

    public static int medianOf3(Segment[] intArray, int left, int right) {
        int center = (left + right) / 2;

        if (intArray[left].l > intArray[center].l)
            swap(intArray, left, center);

        if (intArray[left].l > intArray[right].l)
            swap(intArray, left, right);

        if (intArray[center].l > intArray[right].l)
            swap(intArray, center, right);

        swap(intArray, center, right - 1);
        return intArray[right - 1].l;
    }

    public static void swap(Segment[] intArray, int dex1, int dex2) {
        Segment temp = intArray[dex1];
        intArray[dex1] = intArray[dex2];
        intArray[dex2] = temp;
    }

    public static int partitionIt(Segment[] intArray, int left, int right, double pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (intArray[++leftPtr].l < pivot)
                ;
            while (intArray[--rightPtr].l > pivot)
                ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(intArray, leftPtr, rightPtr);
        }
        swap(intArray, leftPtr, right - 1);
        return leftPtr;
    }

    public static void manualSort(Segment[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (intArray[left].l > intArray[right].l)
                swap(intArray, left, right);
            return;
        } else {
            if (intArray[left].l > intArray[right - 1].l)
                swap(intArray, left, right - 1);
            if (intArray[left].l > intArray[right].l)
                swap(intArray, left, right);
            if (intArray[right - 1].l > intArray[right].l)
                swap(intArray, right - 1, right);
        }
    }
}
