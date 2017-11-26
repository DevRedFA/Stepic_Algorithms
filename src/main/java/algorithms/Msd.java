package algorithms;

import org.junit.Assert;

public class Msd {
    private static int R = 256;        // radix
    //    private static int R = 3;        // radix
    private static String[] aux;       // auxiliary array for distribution

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
//        if (d < s.length()) return s.charAt(d)-65;
        else return -1;
    }

    private static int getKey(String s, int d) {
        if (d < s.length()) return s.charAt(d) - 65;
        else return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        String[] a = {"ABC", "AA", "CCBA", "BBAA", "AB", "AAA", "ACB", "ABB", "B", "CAB", "CAA"};
        sort(a);
        String[] result = {"AA", "AAA", "AB", "ABB", "ABC", "ACB", "B", "BBAA", "CAA", "CAB", "CCBA"};
        Assert.assertArrayEquals(a, result);
    }


    private static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {  // Sort from a[lo] to a[hi], starting at the dth character.
        int[] count = new int[R + 2];        // Compute frequency counts.
        for (int i = lo; i <= hi; i++)
            count[charAt(a[i], d) + 2]++;
        for (int r = 0; r < R + 1; r++)      // Transform counts to indices.
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++)     // Distribute.
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        System.arraycopy(aux, 0, a, lo, hi + 1 - lo);
        // Recursively sort for each character value.
        for (int r = 0; r < R; r++)
            if (count[r + 1] - count[r] > 0) {
                sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
            }
    }
}

