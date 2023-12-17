package org.example;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testable
public class Tests {

    private static List<Melon> melons = List.of(
            new Melon("A", 1500, "O1"),
            new Melon("A", 2500, "O2"),
            new Melon("B", 1500, "O2"),
            new Melon("b", 1500, "O3"),
            new Melon("C", 2000, "O2")
    );

    @Test
    public void whenMelonsFilteredByTypeB_2Instances() throws IllegalStateException {
        assertEquals(2, (long) Filters.filterByType(melons, "B").size());
    }

    @Test
    public void whenMelonsFilteredByWeight1500_3Instances() throws IllegalStateException {
        assertEquals(3, (long) Filters.filterByWeight(melons, 1500).size());
    }

    @Test
    public void whenMelonsFilteredByWeight1500AndTypeB_1Instance() throws IllegalStateException {
        assertEquals(1, (long) Filters.filterByWeightAndType(melons, "a", 1500).size());
    }

    @Test
    public void whenMelonsFilteredWithHugeMelonPredicateOver1500_2Instance() throws IllegalStateException {
        assertEquals(2, (long) Filters.filterMelons(melons, new HeavyMelonPredicate()).size());
    }

    @Test
    public void whenMelonsFilteredWithTypeAMelonPredicate_2Instance() throws IllegalStateException {
        assertEquals(2, (long) Filters.filterMelons(melons, new HeavyMelonPredicate()).size());
    }

    @Test
    public void whenMelonsFilteredWithAnonymousClass() throws IllegalStateException {
        List<Melon> melonList = Filters.filterMelons(melons, new MelonPredicate() {
            @Override
            public boolean test(Melon melon) {
                return melon.getWeight() > 1500;
            }
        });
        assertEquals(2, (long) melonList.size());
    }

    @Test
    public void whenMelonsFilteredWithLambda() throws IllegalStateException {
        assertEquals(2, (long) Filters.filterMelons(melons, melon -> melon.getWeight() > 1500).size());
    }

    @Test
    public void whenObjectsFilteredWithGenericFilterMelons() throws IllegalStateException {
        assertEquals(2, (long) Filters.filter(melons, (Melon m) -> m.getWeight() > 1500).size());
    }

    @Test
    public void whenObjectsFilteredWithGenericFilterIntegers() throws IllegalStateException {
        assertEquals(3, (long) Filters.filter(List.of(1, 2, 3, 4, 5), (Integer i) -> i > 2).size());
    }

    @Test
    public void whenObjectsFilteredWithGenericFilterIntegersWithPredicateInstance() throws IllegalStateException {
        Predicate<Integer> predicate = (Integer i) -> i > 2;
        assertEquals(3, (long) Filters.filter(List.of(1, 2, 3, 4, 5), predicate).size());
    }
}
