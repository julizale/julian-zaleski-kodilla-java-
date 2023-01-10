package com.kodilla.bubbles;

import com.kodilla.bubbles.exception.NotNumericCharacterException;

import java.util.*;

public class Calculator {

    public int findSecondMin(int[] intArrray) throws IllegalArgumentException {
        if (intArrray.length < 2) {
            throw new IllegalArgumentException("Array to find second minimum shorter than 2.");
        }
        int firstMin = intArrray[0];
        int secondMin = firstMin;
        for (int i = 1; i < intArrray.length; i++) {
            if (intArrray[i] < firstMin) {
                secondMin = firstMin;
                firstMin = intArrray[i];
            } else if (intArrray[i] < secondMin && intArrray[i] > firstMin) {
                secondMin = intArrray[i];
            }
        }
        return secondMin;
    }

    public int findSecondMax(int[] intArrray) throws IllegalArgumentException {
        if (intArrray.length < 2) {
            throw new IllegalArgumentException("Array to find second maximum shorter than 2.");
        }
        int firstMax = intArrray[0];
        int secondMax = firstMax;
        for (int i = 1; i < intArrray.length; i++) {
            if (intArrray[i] > firstMax) {
                secondMax = firstMax;
                firstMax = intArrray[i];
            } else if (intArrray[i] > secondMax && intArrray[i] < firstMax) {
                secondMax = intArrray[i];
            }
        }
        return secondMax;
    }

    public static boolean  isIsogram(String str) {
        str = str.toLowerCase();
        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();

        for(char c : str.toCharArray()) {
            list.add(c);
            set.add(c);
        }
        return list.size() == set.size();
    }

    public int mapStringToInt(String input) throws NotNumericCharacterException {
        String charsAllowed = "0123456789";
        int result = 0;
        int n = 1;
        char[] chars = input.toCharArray();
        for (int i = chars.length -1; i >= 0; i--) {
            if (charsAllowed.indexOf(chars[i]) == -1) {
                throw new NotNumericCharacterException();
            }
            result += Character.getNumericValue(chars[i]) * n;
            n *= 10;
        }
        return result;
    }

    public String mapDecToBin(int dec) {
        if (dec == 0) {
            return "0";
        }
        StringBuilder bin = new StringBuilder();
        int arg = Math.abs(dec);
        while (arg > 0) {
            bin.insert(0, arg % 2);
            arg /= 2;
        }
        if (dec < 0) {
            bin.insert(0, '-');
        }
        return bin.toString();
    }

    public String mapDecToHex(int dec) {
        if (dec==0) {
            return "0";
        }
        String hexDigits = "0123456789ABCDEF";
        StringBuilder hex = new StringBuilder();
        int arg = Math.abs(dec);
        while (arg > 0) {
            char digit = hexDigits.charAt(arg % 16);
            hex.insert(0, digit);
            arg /= 16;
        }
        if (dec < 0) {
            hex.insert(0, '-');
        }
        return hex.toString();
    }

/*    Napisz program, który zamieni liczby całkowite w systemie dziesiętnym na liczby całkowite zapisane w
 systemie szesnastkowym (heksadecymalnym). Kluczowy algorytm zamknij w osobnej funkcji/metodzie,
  która będzie przyjmować jeden argument wejściowy (liczba dziesiętna powinna być zapisana w pamięci jako
   liczba całkowita (nie jako string)). Po obliczeniach funkcja ta powinna zwracać wynik w postaci ciągu znaków (string).*/

}
