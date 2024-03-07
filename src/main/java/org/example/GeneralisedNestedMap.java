package org.example;

import java.util.HashMap;
import java.util.Map;

public class GeneralisedNestedMap {
    private Map<String, Object> internalMap;

    public GeneralisedNestedMap() {
        this.internalMap = new HashMap<>();
    }

    public void put(String key, Object value) {
        internalMap.put(key, value);
    }

    public Object get(String key) {
        return internalMap.get(key);
    }
}

