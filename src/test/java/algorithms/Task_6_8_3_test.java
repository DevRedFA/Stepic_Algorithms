package algorithms;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Task_6_8_3_test {
    public byte[] doTest(byte[] inputBytes) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Task_6_8_3_countSort.main(null);
        return outputStream.toByteArray();
    }

    @Test
    public void TestDataFromStepic() {
        String input = "5" + System.lineSeparator()
                + "2 3 9 2 9" + System.lineSeparator();
        String answer = "2 2 3 9 9" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestWithGenericData() {
        Random random = new Random();
        int n = random.nextInt(1000);
        int[] all = new int[n];
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(System.lineSeparator());
        for (int i = 0; i < n; i++) {
            int nextInt = 0;
            do {
                nextInt = random.nextInt(11);
            } while (nextInt == 0);

            sb.append(nextInt).append(" ");
            all[i] = nextInt;
        }
        sb.append(System.lineSeparator());
        byte[] inputBytes = sb.toString().getBytes();
        StringBuilder answer = new StringBuilder();
        Arrays.stream(all).sorted().forEach(s -> answer.append(s).append(" "));

        byte[] expectedBytes = answer
                .substring(0, answer.length() - 1)
                .concat(System.lineSeparator())
                .getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertEquals(new String(expectedBytes), new String(resultBytes));
    }
}
