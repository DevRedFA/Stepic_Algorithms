package algorithms;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;

public class Task_4_1_11_test {

    public byte[] doTest(byte[] inputBytes) throws IOException, InterruptedException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Task_4_1_11.main(null);
        return outputStream.toByteArray();
    }

    @Test
    public void TestDataFromStepic() throws Exception {
        String input = "4" + System.lineSeparator();               ;
        String answer = "2" + System.lineSeparator()
                + "1 3 ";
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    public void TestDataFromStepic2() throws Exception {
        String input = "6" + System.lineSeparator();
        String answer = "3" + System.lineSeparator()
                + "1 2 3 ";
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes,resultBytes );
    }

    @Test
    public void TestDataFromStepic5() throws Exception {
        String input = "8" + System.lineSeparator();
        String answer = "3" + System.lineSeparator()
                + "1 2 5 ";
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes,resultBytes );
    }

    @Test
    public void TestDataFromStepic6() throws Exception {
        String input = "11" + System.lineSeparator();
        String answer = "4" + System.lineSeparator()
                + "1 2 3 5 ";
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes,resultBytes );
    }

    @Test
    public void TestDataFromStepic3() throws Exception {
        String input = "1" + System.lineSeparator();
        String answer = "1" + System.lineSeparator()
                + "1"+ System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    public void TestDataFromStepic4() throws Exception {
        String input = "2" + System.lineSeparator();
        String answer = "1" + System.lineSeparator()
                + "2"+ System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }
}
