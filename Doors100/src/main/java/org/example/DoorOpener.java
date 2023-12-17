package org.example;

import java.util.Arrays;

public class DoorOpener {

    private static final int numberDoors = 100;

    public static void toggleDoors() {
        Integer[] doors = new Integer[numberDoors];
        Arrays.fill(doors, 0);

        for (int i = 0; i <= (numberDoors - 1); i++) {
            for (int j = 0; j <= (numberDoors - 1); j++) {
                if ((j + 1) % (i + 1) == 0) {
                    doors[j] = doors[j] == 0 ? 1 : 0;
                }
            }
        }
        System.out.println(Arrays.toString(doors));
    }
}
