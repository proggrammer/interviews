package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressDecompressStringTest {

    @Test
    void compressString() {
        utilTest("aabbbbbbbbbbbbbbbbbbxcccaaa", "a2b18xc3a3");
        utilTest("abc", "abc");
    }

    private void utilTest(String input, String compressedExpected)   {
        String compressed = CompressDecompressString.compressString(input);
        Assertions.assertEquals(compressedExpected, compressed);

        String uncompressed = CompressDecompressString.decompressString(compressedExpected);
        Assertions.assertEquals(input, uncompressed);
    }
}