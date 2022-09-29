package com.kodilla.stream.beautifier;

public class MyBeautifier {

    public static String insertSpaces(String txt) {

        char[] characters = txt.toCharArray();
        String result = "";
        for (char ch: characters) {
            result += ch;
            result += " ";
        }
        return result;
    }
}
