package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CompactLRUCacheTest {

    @Test
    void put() {
        CompactLRUCache<String, String> compactLRUCache = new CompactLRUCache<>(2);
        compactLRUCache.put("a","aV");
        compactLRUCache.put("b","bV");
        compactLRUCache.put("c","cV");
        compactLRUCache.put("d","dV");


        Assertions.assertEquals(null, compactLRUCache.get("a"));
        Assertions.assertEquals("cV", compactLRUCache.get("c"));

        compactLRUCache.put("e","eV");
        Assertions.assertEquals(null, compactLRUCache.get("d"));
        Assertions.assertEquals("eV", compactLRUCache.get("e"));
    }
}