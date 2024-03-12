package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Develop a java custom map whose values can be a a terminal data type in java or a map - kind of nested map.
 */
public class GeneralisedNestedMap {
    private Map<String, Object> internalMap;

    public GeneralisedNestedMap() {
        this.internalMap = new HashMap<>();
    }

    public GeneralisedNestedMap(Map<String, Object> map)    {
        this.internalMap = map;
    }
    public void put(String key, Object value) {
        internalMap.put(key, value);
    }

    public Object get(String key) {
        return internalMap.get(key);
    }

    public Map<String, Object> getInternalMap() {
        return internalMap;
    }
}

