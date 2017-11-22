package algorithms;

import org.junit.Assert;

public class Msd {
    public static void main(String[] args) throws InterruptedException {
        String[] a = {"AA", "CCBA", "BBAA", "AB", "AAA", "ACB"};
        sortMsd(a, 4);
        String[] result = {"AA", "AAA", "AB", "ACB", "BBAA", "CCBA"};
        Assert.assertArrayEquals(a, result);
    }

    private static void sortMsd(String[] a, int i) {

    }


}
