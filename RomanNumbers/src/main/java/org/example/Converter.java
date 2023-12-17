package org.example;

public class Converter {
    private static final String[] HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ONES = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String convert(int number, String result) {

        if (number > 999) return "-1";

        result = result + HUNDREDS[number / 100];
        number = number % 100;

        result = result + TENS[number / 10];
        number = number % 10;

        result = result + ONES[number];

        return result;
    }

}
