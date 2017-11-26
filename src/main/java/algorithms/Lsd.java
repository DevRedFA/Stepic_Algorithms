package algorithms;

import org.junit.Assert;


public class Lsd {
    private static int R = 3;

    private static int getKey(String s, int max, int k) {
        if (k > max - s.length()) {
            return s.charAt(k - (max - s.length())) - 65;
        } else {
            return 0;
        }
    }

    private static void sortLsd(String[] a, int K) {
        int max = 0;
        for (String st : a) {
            if (st.length() > max) {
                max = st.length();
            }
        }
        int[] count = new int[R + 2];
        String[] temp = new String[a.length];
        for (int d = K - 1; d >= 0; d--) {
            for (String anA : a) {
                count[getKey(anA, K, d) + 2]++;
            }
            for (int i = 0; i < count.length - 1; i++) {
                count[i + 1] += count[i];
            }
            for (String anA : a) {
                temp[count[getKey(anA, K, d) + 1]++] = anA;
            }
            System.arraycopy(temp, 0, a, 0, a.length);
            count = new int[R + 2];
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String[] a = {"AA", "CCBA", "BBAA", "AB", "AAA", "ACB"};
        sortLsd(a, 4);
        String[] result = {"AA", "AAA", "AB", "ACB", "BBAA", "CCBA"};
        Assert.assertArrayEquals(a, result);
    }
}
