package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task_6_2_14 {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 2, 3};
        Integer[] ints2 = new Integer[]{0, 1, 2};
        List<Integer> list = Arrays.asList(ints);
        List<Integer> list2 = Arrays.asList(ints2);
        final Set<Integer> integers = symmetricDifference(new HashSet<>(list), new HashSet<>(list2));
        System.out.println(integers);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set1copy = new HashSet<T>(set1);
        Set<T> set2copy = new HashSet<T>(set2);
        set1copy.removeAll(set2);
        set2copy.removeAll(set1);
        set2copy.addAll(set1copy);
        return set2copy;

//        return set.stream()
//                .filter((s) -> !(set2.contains(s) && set1.contains(s)))
//                .collect(Collectors.toSet());
    }
}
