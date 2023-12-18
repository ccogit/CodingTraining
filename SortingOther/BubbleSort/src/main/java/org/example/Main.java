package org.example;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/* Bubble sort: Only swaps of adjacent numbers of array */
public class Main {
    static Faker faker = new Faker();
    static Random rnd = new Random();
    static Comparator<Melon> comparatorByWeight = Comparator.comparingInt(Melon::getWeight);
    static int[] ints = rnd.ints(10000, 1, 10000).toArray();

    public static void main(String[] args) {

        /* SORTING PRIMITIVES */
        Arrays.stream(sortBubblePrimitives(Main.ints)).forEach(System.out::println);

        /* SORTING OBJECTS */
        Melon[] melons = new Melon[10];
        for (int i = 0; i < 10; i++) {
            melons[i] = randomMelonGenerator();
        }

        // V1: Usage of comparator inline via lambda expression
        Arrays.stream(bubbleSortObjects(melons.clone(), Comparator.comparingInt(Melon::getWeight))).forEach(System.out::println);

        // V2: Usage of comparator instantiated before
        Arrays.stream(bubbleSortObjects(melons.clone(), comparatorByWeight)).forEach(System.out::println);

    }


    public static Melon randomMelonGenerator() {
        return new Melon(faker.cannabis().types(), faker.number().numberBetween(1000, 3000), faker.country().capital());
    }

    public static int[] sortBubblePrimitives(int[] integerList) {
        // Swap one number
        for (int i = 0; i < integerList.length - 1; i++) {
            for (int j = 0; j < integerList.length - i - 1; j++) {
                if (integerList[j] > integerList[j + 1]) {
                    Integer temp = integerList[j];
                    integerList[j] = integerList[j + 1];
                    integerList[j + 1] = temp;
                }
            }
        }
        return integerList;
    }

    // Requires provision of comparator instantiated before
    // Alternative: Implement Comparable-Interface in Melon-Class -> no comparator parameter required
    public static <T> T[] bubbleSortObjects(T[] arr, Comparator<? super T> c) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}