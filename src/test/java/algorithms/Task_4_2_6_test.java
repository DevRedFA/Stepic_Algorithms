package algorithms;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;

public class Task_4_2_6_test {
    public byte[] doTest(byte[] inputBytes) throws IOException, InterruptedException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Task_4_2_6.main(null);
        return outputStream.toByteArray();
    }

    @Test
    public void TestDataFromStepic() throws Exception {
        String answer = "a" + System.lineSeparator();
        String input = "1 1" + System.lineSeparator()
                + "a: 0" + System.lineSeparator()
                + "0" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromStepic2() throws Exception {
        String answer = "abacabad" + System.lineSeparator();
        String input = "4 14" + System.lineSeparator()
                + "a: 0" + System.lineSeparator()
                + "b: 10" + System.lineSeparator()
                + "c: 110" + System.lineSeparator()
                + "d: 111" + System.lineSeparator()
                + "01001100100111" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }
}
