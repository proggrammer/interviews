package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomMapTest {

    @Test
    void putGet() {
        CustomMap<String, Integer, String>  customMap = new CustomMap<>();
        customMap.put("hello", 1, "hello1");
        String retrievedS = customMap.get("hello", 1);
        Assertions.assertEquals(retrievedS, "hello1");
    }
}