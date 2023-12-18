package org.example;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/* Beginnend mit 2. Element wird sukzessive jedes Element des Arrays untersucht. */
/* Das aktuell untersuchte Element wird dann mit dem davor verglichen und getauscht - falls untersuchtes kleiner ist als das verglichene. */
/* Dann alle weiter vorne liegenden Elemente vergleichen mit Vergleichelement und ggf tauschen. */
/* Konsequenz: das untersuchte Elemente rutscht solange weiter nach vorne, bis das davor liegende Element kleiner ist. */
/* Dann wird das nächste Element des Arrays untersucht */
public class Main {

    static Faker faker = new Faker();
    static Random rnd = new Random();

    static Comparator<Melon> comparatorByWeight = Comparator.comparingInt(Melon::getWeight);
    static int[] ints = rnd.ints(10000, 1, 10000).toArray();
    static Comparator<Melon> melonComparator = Comparator.comparing(Melon::getType).thenComparingInt(Melon::getWeight);

    public static void main(String[] args) {
        /* SORTING PRIMITIVES */
        //        Arrays.stream(insertionSortPrimitives()).forEach(System.out::println);


        /* SORTING OBJECTS */
        Melon[] melons = new Melon[10];
        for (int i = 0; i < 10; i++) {
            melons[i] = randomMelonGenerator();
        }

        // Using comparator with two criteria (first by type, then by weight)
        Arrays.stream(insertionSortObjects(melons, melonComparator))
                .forEach(System.out::println);
    }

    public static int[] insertionSortPrimitives() {
        int[] intsCloned = ints.clone();
        for (int i = 1; i < intsCloned.length; i++) {

            int key = intsCloned[i];
            int j = i - 1;

            while (j >= 0 && intsCloned[j] > key) {
                intsCloned[j + 1] = intsCloned[j];
                j = j - 1;
            }
            intsCloned[j + 1] = key;
        }
        return intsCloned;
    }

    public static <T> T[] insertionSortObjects(T arr[], Comparator<T> c) {
        for (int i = 1; i < arr.length; i++) {

            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && c.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static Melon randomMelonGenerator() {
        return new Melon((MelonType) new RandomEnumGenerator(MelonType.class).getRandomEnumValue(), faker.number().numberBetween(1000, 3000), faker.country().capital());
    }
}