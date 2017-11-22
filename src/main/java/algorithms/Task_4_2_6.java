package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_4_2_6 {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sum = s.nextInt();
        Map<String, Character> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s1 = "";
            while (s1.isEmpty()) {
                s1 = s.nextLine();
            }
            String[] split = s1.split(": ");
            map.put(split[1], split[0].charAt(0));
        }

        StringBuilder coded = new StringBuilder(s.nextLine());
        StringBuilder result = new StringBuilder();
        int i = 0;
        int size = 1;
        while (i < coded.length()) {
            String key = coded.subSequence(i, i + size).toString();
            if (map.containsKey(key)) {
                result.append(map.get(key));
                i += size;
                size = 1;
            } else {
                size++;
            }
        }
        System.out.println(result.toString());
    }
}
