package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressDecompressStringTest {

    @Test
    void compressString() {
        String input = "aabbbbbbbbbbbbbbbbbbccc";
        String compressedExpected = "a2b18c3";
        String compressed = CompressDecompressString.compressString(input);
        Assertions.assertEquals(compressedExpected, compressed);

        String uncompressed = CompressDecompressString.decompressString(compressedExpected);
        Assertions.assertEquals(input, uncompressed);
    }
}