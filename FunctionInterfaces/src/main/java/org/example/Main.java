package org.example;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final Faker faker = new Faker();
    public static final List<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        generatePersons();

        /* V1: No functional interface; use condition defined in method */
        persons.stream().filter(Main::isHeavierThan3000).toList().forEach(System.out::println);

        /* V2: Provide instantiated functional interface as parameter of a method */
        PersonPredicate isHeavy = person -> person.weight() > 3000;
        persons.stream().filter(p -> p.checker(isHeavy)).toList().forEach(System.out::println);
        persons.stream().filter(p -> p.checker(person -> person.weight() > 3000)).toList().forEach(System.out::println);

        /* V3: Use method of class that implements functional interface */
        persons.stream().filter(p -> new HeavyPersonPredicate().checker(p)).toList().forEach(System.out::println);

        /* V4: Provide class that implements functional interface as parameter  */
        Filter.heavyPersons(persons, new HeavyPersonPredicate()).forEach(System.out::println);

        /* V5: Use predicate defined as inner class */
        persons.stream().filter(p -> p.checker(new PersonPredicate() {
            @Override
            public boolean checker(Person person) {
                return person.weight() > 3000;
            }
        })).toList().forEach(System.out::println);
    }

    private static void generatePersons() {
        for (int i = 1; i < 50; i++) {
            persons.add(new Person(i, faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(1, 5000)));
        }
    }

    public static boolean isHeavierThan3000(Person p) {
        return p.weight() > 3000;
    }
}