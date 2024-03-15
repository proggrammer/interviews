package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeakElementTest {

    @Test
    void findPeak() {
        int[] input = { 1, 3, 20, 4, 1, 0 };
        int r = PeakElement.findPeak(input);
        Assertions.assertEquals(2, r);
    }
}