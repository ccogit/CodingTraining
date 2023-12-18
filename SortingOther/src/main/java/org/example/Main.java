package org.example;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@Testable
public class Main {

    public static Melon[] melons = {
            new Melon("A", 1000, "o1"),
            new Melon("A", 2000, "o2"),
            new Melon("B", 3000, "o2"),
            new Melon("B", 1000, "o1")
    };
    static Faker faker = new Faker();
    static Random rnd = new Random();
    static Comparator<Melon> melonComparator = Comparator.comparingInt(Melon::getWeight).thenComparing(Melon::getType);
    static int[] ints = rnd.ints(10000, 1, 10000).toArray();

    public static <T> boolean elementContainedInArray(T arr[], T element) {
        return !Arrays.stream(arr).filter(t -> t.equals(element)).toList().isEmpty();
    }

    public static <T> boolean elementContainedInArray(T arr[], T element, Comparator<? super T> c) {
        return !Arrays.stream(arr).filter(t -> c.compare(t, element) == 0).toList().isEmpty();
    }

    public static <T> int getIndexOfElementIfContained(T arr[], T element) {
        if (arr == null) return -1;
        else for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].equals(element)) return i;
        }
        return -1;
    }

    /* TESTS */
    @Test
    public void melonNotIncludedInArray() {
        Melon melon = new Melon("A", 2000, "o1");
        assertFalse(elementContainedInArray(melons, melon));
    }

    @Test
    public void melonIncludedInArray() {
        Melon melon = new Melon("B", 1000, "o1");
        assertTrue(elementContainedInArray(melons, melon));
    }

    @Test
    public void melonNotIncludedInArrayComparator() {
        /* Comparator based on wight and type of melon */
        // Element of same type exists, but not with weight of 3000. Origin not part of melonComparator
        assertFalse(elementContainedInArray(melons, new Melon("A", 3000, "o2"), melonComparator));
    }

    @Test
    public void melonIncludedInArrayComparator() {
        /* Comparator based on wight and type of melon */
        // Element of same type and same weight exists. Origin not part of melonComparator
        assertTrue(elementContainedInArray(melons, new Melon("A", 1000, "o2"), melonComparator));
    }

    @Test
    public void indexOfMelonIfIncludedInArray() {
        assertEquals(2, getIndexOfElementIfContained(melons, new Melon("B", 3000, "o2")));
    }

    @Test
    public void minusOneIfMelonIsNotIncludedInArray() {
        assertEquals(-1, getIndexOfElementIfContained(melons, new Melon("B", 4000, "o2")));
    }

    /* HELPER */
    public static Melon randomMelonGenerator() {
        return new Melon(faker.cannabis().types(), faker.number().numberBetween(1000, 3000), faker.country().capital());
    }

    private static void generateMelons() {
        melons = new Melon[10];
        for (int i = 0; i < 10; i++) {
            melons[i] = randomMelonGenerator();
        }
    }
}



