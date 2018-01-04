package algorithms;


import java.util.Scanner;

public class Task_4_3_8_priority_queue {

    private static int[] data = new int[16];
    //    private static int[] data = {7, 6, 5, 4, 3, 2, 1};
    private static int last = 0;
//    private static int last = 7;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int countOperations = s.nextInt();
        for (int i = 0; i < countOperations; i++) {
            if (s.hasNext()) {
                String command = s.next();
                switch (command) {
                    case "Insert":
                        if (s.hasNextInt()) {
                            last++;
                            if (last >= data.length) {
                                data = resize(data);
                            }
                            data[last - 1] = s.nextInt();
                            swimUp(data, last);
                        }
                        break;
                    case "ExtractMax":
                        last--;
                        System.out.println(data[0]);
                        swap(0, last);
                        data[last] = 0;
                        sinkDown(data, 1);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static void swimUp(int[] data, int nNew) {
        if (nNew > 1) {
            if (data[nNew - 1] > data[(nNew / 2) - 1]) {
                swap(nNew - 1, (nNew / 2) - 1);
                if ((nNew / 2) - 1 > 0) {
                    swimUp(data, (nNew / 2));
                }
            }
        }
    }

    private static void sinkDown(int[] data, int nNew) {
        int left = data[2 * nNew - 1];
        int right = data[2 * nNew];
        if (left >= right) {
            if (data[nNew - 1] < data[2 * nNew - 1]) {
                swap(nNew - 1, 2 * nNew - 1);
                if (4 * nNew - 1 < last) {
                    sinkDown(data, 2 * nNew);
                }
            }
        } else {
            if (data[nNew - 1] < data[2 * nNew]) {
                swap(nNew - 1, 2 * nNew);
                if (4 * nNew - 1 < last) {
                    sinkDown(data, 2 * nNew + 1);
                }
            }
        }
    }

    private static void swap(int i, int j) {
        int first = data[i];
        data[i] = data[j];
        data[j] = first;
    }

    private static int[] resize(int[] data) {
        int[] newArray = new int[(int) (data.length * 1.5)];
        System.arraycopy(data, 0, newArray, 0, data.length);
        return newArray;
    }
}
