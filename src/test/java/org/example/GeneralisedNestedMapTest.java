package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GeneralisedNestedMapTest {

    @Test
    void put() {
        GeneralisedNestedMap generalisedNestedMap = new GeneralisedNestedMap();
        generalisedNestedMap.put("ok", "ok");

        Map<String, String> internalMap = new HashMap<>();
        internalMap.put("internalK1", "internalV1");
        internalMap.put("internalK2", "internalV2");
        generalisedNestedMap.put("internal", internalMap);

        Assertions.assertEquals(((HashMap) generalisedNestedMap.get("internal")).keySet().size(), 2);
    }
}