package com.java.course;
import java.lang.System;
import java.util.Arrays;


public class StringReverser {
    private static final String SPACE_REGEX = "\\s+";
    private static final char SPACE_CHARACTER = ' ';
    String originalString = "Hello Wold";
    String reversedString = "";

    public String reverseWordsinString(String inputString) throws IllegalAccessException {
        if (inputString == null) {
            throw new IllegalAccessException("Input string cannot be null");
        }

        String[] words = inputString.split(SPACE_REGEX);
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            char[] reversedWord = reverseLetters(word);
            result.append(reversedWord).append(SPACE_CHARACTER);
        }
        return result.toString().trim();

    }

    private static char[] reverseLetters(String word) {
        char[] characters = word.toCharArray();
        char[] reverseWord = new char[characters.length];
        int resultIndex = 0;

        int letterIndex = characters.length - 1;

        for (char character : characters) {
            if (Character.isLetter(character)) {
                while (letterIndex >= 0 && !Character.isLetter(characters[letterIndex])) {
                    letterIndex--;
                }
                if (letterIndex >= 0) {
                    reverseWord[resultIndex++] = characters[letterIndex--];
                } else {
                    reverseWord[resultIndex++] = character;

                }
            }

        }
        return Arrays.copyOf(reverseWord, resultIndex);
    }


    public void reverseString(){
        System.out.println("Original String: " + originalString);

        for (int i = 0; i < originalString.length(); i++){
            reversedString = originalString.charAt(i) + reversedString;
        }
        System.out.println("Reversed String: " + reversedString);
    }





}
