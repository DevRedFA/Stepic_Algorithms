package core;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;

public class Task_6_2_15_test {
    public byte[] doTest(byte[] inputBytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Task_6_2_15.main(null);
        return outputStream.toByteArray();
    }

    @Test
    public void test1() throws Exception {
        byte[] inputBytes = "1 25 345 436 5 6 7".getBytes();
        byte[] expectedBytes = "6 436 25 ".getBytes();
        final byte[] bytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes,bytes);
    }

    @Test
    public void test2() throws Exception {
        byte[] inputBytes = " ".getBytes();
        byte[] expectedBytes = "".getBytes();
        final byte[] bytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes,bytes);
    }
}
