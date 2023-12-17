package org.example;

@FunctionalInterface
public interface Combiner {
    String concat(String s1, String s2);
}
