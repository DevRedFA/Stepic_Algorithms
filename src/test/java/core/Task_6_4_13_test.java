package core;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;

public class Task_6_4_13_test {
    public byte[] doTest(byte[] inputBytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Task_6_4_13.main(null);
        return outputStream.toByteArray();
    }

    @Test
    public void test1() throws Exception {
        byte[] inputBytes = "ћама мыла-мыла-мыла раму!\n".getBytes();
        byte[] expectedBytes = ("мыла\n"
                + "мама\n"
                + "раму").getBytes();
        final byte[] bytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, bytes);
    }

    @Test
    public void test2() throws Exception {
        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";
        byte[] inputBytes = str.getBytes();
        byte[] expectedBytes = "".getBytes();
        final byte[] bytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, bytes);
    }
}
