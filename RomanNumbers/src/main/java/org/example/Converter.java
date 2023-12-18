package org.example;

public class Converter {
    private static final String[] HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ONES = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String convert(int number, String result) {

        if (number > 999) return "-1";

        // number = 558
        result = result + HUNDREDS[number / 100]; // number / 100 = 5 -> HUNDRED[5] = "D"
        number = number % 100; // number % 100 = 58

        // number = 58
        result = result + TENS[number / 10]; // number / 10 = 5 -> TENS[5] = "L"
        number = number % 10; // number % 10 = 8

        // number = 8
        result = result + ONES[number]; // ONES[8] = "VIII"

        return result; // "DLVIII"
    }

}
