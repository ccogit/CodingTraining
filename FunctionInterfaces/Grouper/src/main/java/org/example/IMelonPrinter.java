package org.example;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface IMelonPrinter {
    void print(Map<String, List<Melon>> melons);
}
