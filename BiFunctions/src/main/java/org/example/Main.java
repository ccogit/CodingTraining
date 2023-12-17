package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {
    private final static Map<String, String> map = Map.of(
            "Android", "Mobile",
            "Eclipse IDE", "Java",
            "Eclipse RCP", "Java",
            "Git", "Version control system");

    private final static List<String> strings = List.of("a", "b", "c", "d");
    private final static List<Integer> integers = List.of(1, 2, 3, 4);

    public static void main(String[] args) {
        List<String> resultList = listCombiner(strings, integers, (s, i) -> s + i);
        printMapAsTable();
    }

    public static <T, U, R> List<R> listCombiner(List<T> list1, List<U> list2, BiFunction<T, U, R> combiner) {
        List<R> resultingList = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            resultingList.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return resultingList;
    }

    public static String exchangeFirstLetter(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        char c = s1Arr[0];
        s1Arr[0] = s2Arr[0];
        s2Arr[0] = c;
        return String.valueOf(s1Arr) + "-" + String.valueOf(s2Arr);
    }

    public static void printMapAsTable() {
        map.forEach((s1, s2) -> System.out.printf("%-20s %-20s%n", s1, s2));
    }

    public static void printMap() {

    }
}