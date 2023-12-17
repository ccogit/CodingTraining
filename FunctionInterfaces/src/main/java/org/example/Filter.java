package org.example;

import java.util.List;

public final class Filter {

    public static List<Person> heavyPersons(List<Person> persons, HeavyPersonPredicate hpp) {
        return persons
                .stream()
                .filter(hpp::checker)
                .toList();
    }
}
