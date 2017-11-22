package algorithms;

import java.util.*;

public class Task_4_1_9_cover_segments_with_dots {

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        List<Pair> list = new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(s.nextInt(), s.nextInt()));
        }
        int points=0;
        list.sort(Comparator.comparingInt(o -> o.second));
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            Pair pair = list.remove(0);
            sb.append(pair.second).append(" ");
            points++;
//            result.add(pair.second);
            while (!list.isEmpty() && list.get(0).first <= pair.second) {
                list.remove(0);
            }

        }
        System.out.println(points);
        System.out.print(sb.toString());
//        System.out.println(result.size());
//        result.forEach(i -> System.out.print(i + " "));
    }
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
