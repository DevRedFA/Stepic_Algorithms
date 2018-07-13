package algorithms;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class Task_4_1_10_continuous_backpack_test {

    public byte[] doTest(byte[] inputBytes) throws IOException, InterruptedException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Task_4_1_10_continuous_backpack.main(null);
        return outputStream.toByteArray();
    }

    @Test
    public void TestDataFromStepic() throws Exception {
        String input = "3 50" + System.lineSeparator()
                + "60 20" + System.lineSeparator()
                + " 100 50" + System.lineSeparator()
                + "120 30" + System.lineSeparator();
        String answer = "180,000" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertEquals(answer, new String(resultBytes));
    }


    @Test
    public void TestDataFromStepic2() throws Exception {
        String input = "1 9" + System.lineSeparator()
                + "100 10" + System.lineSeparator()
                + "50 10" + System.lineSeparator();
        String answer = "90,000" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertEquals(answer, new String(resultBytes));
    }

}
