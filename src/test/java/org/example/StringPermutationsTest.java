package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringPermutationsTest {

    @Test
    void printPermutations() {
        String str = "aab";
        System.out.println("Permutations of \"" + str + "\":");
        StringPermutations.printPermutations(str);
    }
}