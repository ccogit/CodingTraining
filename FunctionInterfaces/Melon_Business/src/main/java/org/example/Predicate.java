package org.example;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
