package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CollatzConjectureTest {

    @Test
    void runTest() {
        CollatzConjecture.runTest(10000);
    }

    @Test
    void threeNPlus1() {
        String s = CollatzConjecture.threeNPlus1("1101");
        Assertions.assertEquals(s, "101000");

        String s1 = CollatzConjecture.threeNPlus1("1001101");
        Assertions.assertEquals(s1, "11101000");
    }

    @Test
    void collatzStep() {
        String v = CollatzConjecture.collatzStep("1");
        Assertions.assertEquals(v, "100");
    }
}