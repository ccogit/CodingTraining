package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MelonGrouper {

    public static Map<String, List<Melon>> group(List<Melon> melons, IMelonGrouper mg) {
        return mg.group(melons);
    }

    public static IMelonGrouper groupMelonsByType() {
        return (List<Melon> melons) ->
                melons.stream().collect(Collectors.groupingBy(Melon::getType));
    }

    public static IMelonGrouper groupMelonsByOrigin() {
        return (List<Melon> melons) ->
                melons.stream().collect(Collectors.groupingBy(Melon::getOrigin));
    }
}
