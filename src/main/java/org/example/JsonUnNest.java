package org.example;

import org.json.JSONObject;

import java.util.Map;

public class JsonUnNest {
    public static GeneralisedNestedMap extract(String jsonAsString)   {
        JSONObject jsonObject = new JSONObject(jsonAsString);
        return jsonToMap(jsonObject);
    }
    public static GeneralisedNestedMap transform(String prefix, GeneralisedNestedMap generalisedNestedMap)    {

        GeneralisedNestedMap generalisedNestedMapFlatten = new GeneralisedNestedMap();

        for(Map.Entry<String, Object> entry: generalisedNestedMap.getInternalMap().entrySet())   {
            String currentKey = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Map) {
                // Recursive call for nested map
                GeneralisedNestedMap nestedFlatten = transform(prefix + currentKey + ".", new GeneralisedNestedMap((Map<String, Object>) value));

                for(String keyFlatten: nestedFlatten.getInternalMap().keySet())    {
                    generalisedNestedMapFlatten.put(keyFlatten, nestedFlatten.get(keyFlatten));
                }
            } else {
                // Add non-nested key-value pair
                generalisedNestedMapFlatten.put(prefix + currentKey, value);
            }
        }
        return null;
    }
    public static  String load(GeneralisedNestedMap generalisedNestedMap) {
        return null;
    }

    private static GeneralisedNestedMap jsonToMap(JSONObject jsonObject)   {
        GeneralisedNestedMap generalisedNestedMap = new GeneralisedNestedMap();
        for(String key: jsonObject.keySet())    {
            if(jsonObject.get(key).getClass().isInstance(JSONObject.class))
                generalisedNestedMap.put(key, jsonToMap((JSONObject) jsonObject.get(key)));
            else
                generalisedNestedMap.put(key, jsonObject.get(key).toString());
        }
        return generalisedNestedMap;
    }
}
