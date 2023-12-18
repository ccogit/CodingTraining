package org.example;

import java.util.List;

import static org.example.MelonGrouper.*;
import static org.example.MelonPrinter.oneLinePerMapEntryPrinter;
import static org.example.MelonPrinter.print;

public class Main {
    private final static List<Melon> melons = List.of(
            new Melon("A", 1500, "O1"),
            new Melon("A", 2500, "O2"),
            new Melon("B", 1500, "O2"),
            new Melon("B", 1500, "O3"),
            new Melon("B", 2000, "O2")
    );

    public static void main(String[] args) {
        print(group(melons, groupMelonsByType()), oneLinePerMapEntryPrinter());
        print(group(melons, groupMelonsByOrigin()));
    }


}