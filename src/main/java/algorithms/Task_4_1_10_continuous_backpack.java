package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Task_4_1_10_continuous_backpack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Thing> list = new ArrayList<>();
        int n = s.nextInt();
        int space = s.nextInt();
        double priceFull = 0;
        for (int i = 0; i < n; i++) {
            list.add(new Thing(s.nextInt(), s.nextInt()));
        }
        list.sort(Comparator.comparingDouble(o -> -o.value));
        while (space > 0 && !list.isEmpty()) {
            Thing thing = list.remove(0);
            if (thing.size <= space) {
                space -= thing.size;
                priceFull += thing.price;
            } else {
                priceFull += space * thing.value;
                break;
            }

        }
        String formattedDouble = String.format("%.3f", priceFull);
        System.out.println(formattedDouble);
    }

    static class Thing {
        int price;
        int size;
        double value;

        Thing(int price, int size) {
            this.price = price;
            this.size = size;
            this.value = (double) price / size;
        }
    }
}
