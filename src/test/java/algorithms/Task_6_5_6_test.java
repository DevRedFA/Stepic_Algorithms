package algorithms;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Task_6_5_6_test {
    public byte[] doTest(byte[] inputBytes) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Task_6_5_6_segments_and_dots.main(null);
        return outputStream.toByteArray();
    }

    @Test
    public void TestDataFromStepic() {
        String input = "2 3" + System.lineSeparator()
                + "7 10" + System.lineSeparator()
                + "0 5" + System.lineSeparator()
                + "1 6 11" + System.lineSeparator();
        String answer = "1 0 0" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromCS2() {
        String input = "2 2" + System.lineSeparator()
                + "0 5" + System.lineSeparator()
                + "7 10" + System.lineSeparator()
                + "1 6" + System.lineSeparator();
        String answer = "1 0" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromSC() {
        String input = "1 3" + System.lineSeparator()
                + "-10 10" + System.lineSeparator()
                + "-100 100 0" + System.lineSeparator();
        String answer = "0 0 1" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromStepic2() {
        String input = "6 6" + System.lineSeparator()
                + "0 3" + System.lineSeparator()
                + "1 3" + System.lineSeparator()
                + "2 3" + System.lineSeparator()
                + "3 4" + System.lineSeparator()
                + "3 5" + System.lineSeparator()
                + "3 6" + System.lineSeparator()
                + "1 2 3 4 5 6" + System.lineSeparator();
        String answer = "2 3 6 3 2 1" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromStepic3() {
        String input = "2 5" + System.lineSeparator()
                + "-1 -1" + System.lineSeparator()
                + "0 1" + System.lineSeparator()
                + "-2 -1 0 1 2" + System.lineSeparator();
        String answer = "0 1 1 1 0" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    private String[] generateData(int n, int m) {
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" ").append(m).append(System.lineSeparator());

        return new String[]{};
    }


    static class Segment implements Comparable<Segment> {
        int l;
        int r;

        public Segment(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Segment o) {
            return Integer.compare(this.l, o.l);
        }
    }
}
