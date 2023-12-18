package org.example;

import java.util.List;
import java.util.Map;

public class MelonPrinter {
    public static void print(Map<String, List<Melon>> melons, IMelonPrinter printer) {
        printer.print(melons);
        System.out.println();
    }

    public static void print(Map<String, List<Melon>> melons) {
        print(melons, oneLinePerMapEntryPrinter());
    }

    public static IMelonPrinter oneLinePerMapEntryPrinter() {
        return (Map<String, List<Melon>> map) -> map.forEach((key, value) -> System.out.println(key + ", " + value));
    }
}
