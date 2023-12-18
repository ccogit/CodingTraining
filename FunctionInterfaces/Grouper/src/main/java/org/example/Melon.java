package org.example;

import lombok.Data;

@Data
public final class Melon {
    private final String type;
    private final int weight;
    private final String origin;

    @Override
    public String toString() {
        return String.format("%-2s %-5s %-3s", type, weight, origin);
    }


}
