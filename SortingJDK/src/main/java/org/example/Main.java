package org.example;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("ComparatorCombinators")
public class Main {
    public static Melon[] melons;

    public static void main(String[] args) {
        melons = new Melon[]{
                new Melon("Hoc", 1000),
                new Melon("All", 2000),
                new Melon("Hoc", 1500)};
        parallelSort2();
        reverseForDescending();
        Arrays.stream(melons).sequential().forEach(System.out::println);
    }

    private static void sort_1() {
        Arrays.sort(melons, new Comparator<Melon>() {
            @Override
            public int compare(Melon o1, Melon o2) {
                return Integer.compare(o1.weight(), o2.weight());
            }
        });
    }

    private static void sort_2() {
        Arrays.sort(melons, (Melon melon1, Melon melon2)
                -> Integer.compare(melon1.weight(), melon2.weight())
        );
    }

    private static void parallelSort() {
        Arrays.parallelSort(melons, (Melon melon1, Melon melon2)
                -> Integer.compare(melon1.weight(), melon2.weight())
        );
    }

    private static void parallelSort2() {
        Arrays.parallelSort(melons, Comparator.comparingInt(Melon::weight));
    }

    private static void reverseForDescending() {
        for (int leftPos = 0, rightPos = melons.length - 1; leftPos < rightPos; leftPos++, rightPos--) {
            Melon currentLeft = melons[leftPos];
            melons[leftPos] = melons[rightPos];
            melons[rightPos] = currentLeft;
        }
    }
}