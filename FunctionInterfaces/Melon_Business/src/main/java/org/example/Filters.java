package org.example;

import java.util.List;

public class Filters {
    public static List<Melon> filterByType(List<Melon> melons, String type) {
        return melons.stream().filter(melon -> melon.getType().equalsIgnoreCase(type)).toList();
    }

    public static List<Melon> filterByWeight(List<Melon> melons, int weight) {
        return melons.stream().filter(melon -> melon != null && melon.getWeight() == weight).toList();
    }

    public static List<Melon> filterByWeightAndType(List<Melon> melons, String type, int weight) {
        return melons.stream().filter(melon ->
                        melon != null &&
                                melon.getWeight() == 1500 &&
                                melon.getType().equalsIgnoreCase(type))
                .toList();
    }

    public static List<Melon> filterMelons(List<Melon> melons, MelonPredicate predicate) {
        return melons.stream().filter(melon -> melon != null && predicate.test(melon)).toList();
    }

    public static <T> List<T> filter(List<T> instances, Predicate<T> predicate) {
        return instances.stream().filter(t -> t != null && predicate.test(t)).toList();
    }

}
