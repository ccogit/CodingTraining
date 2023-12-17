package org.example;

public class HeavyMelonPredicate implements MelonPredicate {
    @Override
    public boolean test(Melon melon) {
        return melon.getWeight() > 1500;
    }
}
