package org.example;

public class TypeAMelons implements MelonPredicate {
    @Override
    public boolean test(Melon melon) {
        return melon.getType().equalsIgnoreCase("a");
    }
}
