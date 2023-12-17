package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(countDuplicateCharacters("HHalloo"));
        System.out.println(countDuplicateCharactersUsingCompute("HHalloo"));
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 2);
        map.put('b', 3);
        map.put('c', 5);
        map.put('d', 12);
        getDoubleValues(map).forEach((character, aLong) -> System.out.println(character + " / " + aLong));
    }

    public static long countDuplicateCharacters(String string) {
        Map<Character, Long> map = string.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        return map.entrySet().stream().filter(characterLongEntry -> characterLongEntry.getValue() > 1).count();
    }

    public static long countDuplicateCharactersUsingCompute(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            map.compute(c, (k, v) -> (v == null) ? 1 : ++v);
        }
        return map.entrySet().stream().filter(characterIntegerEntry -> characterIntegerEntry.getValue() > 1).count();
    }

    public static Map<Character, Integer> getDoubleValues(Map<Character, Integer> map) {
        map.replaceAll((c, i) -> i * 2);
        return map;
    }
}