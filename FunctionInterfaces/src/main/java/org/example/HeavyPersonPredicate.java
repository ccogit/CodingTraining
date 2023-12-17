package org.example;

public class HeavyPersonPredicate implements PersonPredicate {
    @Override
    public boolean checker(Person person) {
        return person.weight() > 3000;
    }
}

