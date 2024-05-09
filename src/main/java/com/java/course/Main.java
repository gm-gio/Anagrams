package com.java.course;


import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IllegalAccessException {
        StringReverser stringReverser = new StringReverser();
        stringReverser.reverseString();

        Scanner sc = new Scanner(System.in);
        LOGGER.info("please enter your text to reverse");

        String input = sc.nextLine();

        String reversed = stringReverser.reverseWordsinString(input);
        LOGGER.info(reversed);

        sc.close();





    }
}