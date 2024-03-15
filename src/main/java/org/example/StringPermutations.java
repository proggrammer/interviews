package org.example;

import java.util.HashSet;
import java.util.Set;

public class StringPermutations {
    public static void printPermutations(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("Invalid input");
            return;
        }
        printPermutationsHelper(str.toCharArray(), 0);
    }

    private static void printPermutationsHelper(char[] chars, int index) {
        if (index == chars.length - 1) {
            System.out.println(new String(chars));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                swap(chars, i, index);
                printPermutationsHelper(chars, index + 1);
                swap(chars, i, index);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
