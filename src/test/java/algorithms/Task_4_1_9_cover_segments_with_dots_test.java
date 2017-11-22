package algorithms;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class Task_4_1_9_cover_segments_with_dots_test {

    public byte[] doTest(byte[] inputBytes) throws IOException, InterruptedException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Task_4_1_9_cover_segments_with_dots.main(null);
        return outputStream.toByteArray();
    }

    @Test
    public void TestDataFromStepic() throws Exception {
        String input ="4" + System.lineSeparator()
                + "4 7" + System.lineSeparator()
                + "1 3" + System.lineSeparator()
                + "2 5" + System.lineSeparator()
                + "5 6" + System.lineSeparator();
        String answer = "2" + System.lineSeparator()
                + "3 6 ";
        byte[] inputBytes =input.getBytes() ;
        byte[] expectedBytes = answer.getBytes();
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }

    @Test
    public void TestDataFromStepic2() throws Exception {
        String input = "3" + System.lineSeparator()
                + "1 3" + System.lineSeparator()
                + "2 5" + System.lineSeparator()
                + "3 6";
        String answer = "1" + System.lineSeparator()
                + "3 ";
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        assertArrayEquals(expectedBytes, doTest(inputBytes));
    }
}
