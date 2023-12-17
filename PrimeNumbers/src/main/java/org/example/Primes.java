package org.example;

import java.util.ArrayList;
import java.util.List;


public class Primes {
    // ALle Zahlen von Form: a*3+b*5+c*7=number
    // Examples:
    // number=24 -> 3*7 + 1*3
    public static boolean isPrimeFactor(int number) {
        if (number > 7) number = number % 7;
        if (number == 0) return true;
        else number = number % 5;
        if (number == 0) return true;
        else number = number % 3;
        if (number == 0) return true;
        else return false;
    }

    public static int kth(int k) {
        int count3 = 0;
        int count5 = 0;
        int count7 = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (list.size() <= k + 1) {
            int m = Math.min(Math.min(list.get(count3) * 3,
                    list.get(count5) * 5), list.get(count7) * 7);
            list.add(m);
            if (m == list.get(count3) * 3) {
                count3++;
            }
            if (m == list.get(count5) * 5) {
                count5++;
            }
            if (m == list.get(count7) * 7) {
                count7++;
            }
        }
        return list.get(k - 1);
    }
}
