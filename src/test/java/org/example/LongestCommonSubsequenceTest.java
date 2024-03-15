package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {

    @Test
    void lcs() {
        String str1 = "ABCDGH";
        String str2 = "AEDFHR";

        System.out.println("Longest Common Subsequence: " + LongestCommonSubsequence.lcs(str1, str2));
    }
}