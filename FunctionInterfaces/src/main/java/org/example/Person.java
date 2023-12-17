package org.example;

public record Person(long id, String firstname, String lastname, int weight) {
    public boolean checker(PersonPredicate pp) {
        return pp.checker(this);
    }
}
