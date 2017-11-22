package algorithms;

public class Lsd {
    public static int R = 3;

    public static int getKey(String s, int max, int k) {
        if (k > max - s.length()) {
            return s.charAt(k - (max - s.length())) - 65;
        } else {
            return 0;
        }
    }

    public static void sortLsd(String[] a, int K) {
        int max = 0;
        for (String st : a) {
            if (st.length() > max) {
                max = st.length();
            }
        }
        int[] count = new int[R + 2];
        String[] temp = new String[a.length];
        for (int d = K - 1; d >= 0; d--) {
            for (int i = 0; i < a.length; i++) {
                count[getKey(a[i], max, d) + 2]++;
            }
            for (int i = 0; i < count.length - 1; i++) {
                count[i + 1] += count[i];
            }
            for (int i = 0; i < a.length; i++) {
                temp[count[getKey(a[i], max, d) + 1]++] = a[i];
            }
            for (int i = 0; i < a.length; i++) {
                a[i] = temp[i];
            }
            count = new int[R + 2];
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String[] a = {"AA", "CCBA", "BBAA", "AB", "AAA", "ACB"};
        sortLsd(a, 4);
        Thread.sleep(1000);
    }
}
