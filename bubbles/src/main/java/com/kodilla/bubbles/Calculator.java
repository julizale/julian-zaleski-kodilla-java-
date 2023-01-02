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
        return true;
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

   /* Napisz program, który zamieni liczbę zapisaną jako łańcuch znaków (np. “2040”) na liczbę całkowitą w programie tak,
    aby możliwa była konwersja danych wprowadzonych przez użytkownika na zmienne, których możemy użyć do
     obliczeń matematycznych. Kluczowy algorytm zamknij w osobnej metodzie, która zwróci obliczoną wartość jako
      liczbę całkowitą (ang. integer). Obsłuż błędy, takie jak niedozwolone znaki (litery, przecinki, kropki itp).
*/
}
