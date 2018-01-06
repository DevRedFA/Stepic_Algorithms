package algorithms;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Task_6_4_5_test {
    public byte[] doTest(byte[] inputBytes) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
        Task_6_4_5_merge_count_of_inversions.main(null);
        return outputStream.toByteArray();
    }

    public byte[] countResultForTest(byte[] inputBytes) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        InputStream SIn = System.in;
        PrintStream SOut = System.out;
        System.setIn(inputStream);
        System.setOut(printStream);
        Task_6_4_5_native_count_of_inversions.main(null);
        System.setIn(SIn);
        System.setOut(SOut);
        return outputStream.toByteArray();
    }


    @Test
    public void TestDataFromStepic() {
        String input = "5" + System.lineSeparator()
                + "2 3 9 2 9" + System.lineSeparator();
        String answer = "2" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromStepic2() {
        String input = "6" + System.lineSeparator()
                + "1 3 4 5 6 2" + System.lineSeparator();
        String answer = "4" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromStepic3() {
        String input = "5" + System.lineSeparator()
                + " 1 2 3 5 4" + System.lineSeparator();
        String answer = "1" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromStepic4() {
        String input = "5" + System.lineSeparator()
                + " 5 4 3 2 1" + System.lineSeparator();
        String answer = "10" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromStepic5() {
        String input = "2" + System.lineSeparator()
                + " 2 1" + System.lineSeparator();
        String answer = "1" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromStepic6() {
        String input = "2" + System.lineSeparator()
                + " 10 1" + System.lineSeparator();
        String answer = "1" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromStepic7() {
        String input = "7" + System.lineSeparator()
                + "7 6 5 4 3 2 1" + System.lineSeparator();
        String answer = "21" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataFromStepic8() {
        String input = "5" + System.lineSeparator()
                + "1 2 3 5 4" + System.lineSeparator();
        String answer = "1" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertArrayEquals(expectedBytes, resultBytes);
    }

    @Test
    public void TestDataGeneratedBad() {
        String input = "5" + System.lineSeparator()
                + "6 4 4 3 1" + System.lineSeparator();
        String answer = "9" + System.lineSeparator();
        byte[] inputBytes = input.getBytes();
        byte[] expectedBytes = answer.getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertEquals("input data:" + new String(inputBytes) + System.lineSeparator(),
                new String(expectedBytes), new String(resultBytes));
    }

    @Test
    public void TestDataGenerated() {
        String[] datas = generateTestData(100000);
        byte[] inputBytes = datas[0].getBytes();
        byte[] expectedBytes = datas[1].getBytes();
        byte[] resultBytes = doTest(inputBytes);
        assertEquals("input data:" + new String(inputBytes) + System.lineSeparator(),
                new String(expectedBytes), new String(resultBytes));
    }

    private String[] generateTestData(int n) {
        StringBuffer sb = new StringBuffer();
        sb.append(n).append(System.lineSeparator());
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            sb.append(random.nextInt(Integer.MAX_VALUE)).append(" ");
//            sb.append(random.nextInt(10)).append(" ");
        }
        sb.append(System.lineSeparator());
        byte[] resultBytes = countResultForTest(sb.toString().getBytes());
        return new String[]{sb.toString(), new String(resultBytes)};
    }
}








