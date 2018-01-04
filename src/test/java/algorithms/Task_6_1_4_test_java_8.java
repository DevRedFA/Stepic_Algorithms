package algorithms;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;

public class Task_6_1_4_test_java_8 {
    public byte[] doTest(byte[] inputBytes) throws InterruptedException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Task_6_1_4_binary_search_java_8_stream.main(null);
        return outputStream.toByteArray();
    }

    @Test
    public void TestDataFromStepic() throws Exception {
        String input = "5 1 5 8 12 13" + System.lineSeparator()
                + "5 8 1 23 1 11" + System.lineSeparator();
        String answer = "3 1 -1 1 -1 ";
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }


    @Test
    public void TestData2() throws Exception {
        String input = "3 100 120 130" + System.lineSeparator()
                + "5 100 120 130 10 170" + System.lineSeparator();
        String answer = "1 2 3 -1 -1 ";
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }
}

