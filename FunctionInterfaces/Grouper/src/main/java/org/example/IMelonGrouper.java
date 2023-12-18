package org.example;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface IMelonGrouper {
    Map<String, List<Melon>> group(List<Melon> melons);
}
