package org.example;

@FunctionalInterface
public interface PersonPredicate {
    boolean checker(Person person);
}
