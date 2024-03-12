package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Develop a custom Java map with composite keys, consisting of two individual keys.
 * @param <K1>
 * @param <K2>
 * @param <V>
 */
public class CustomMap<K1, K2, V> {
    private static class Pair<K1, K2>   {
        private final K1 key1;
        private final K2 key2;

        public Pair(K1 key1, K2 key2)   {
            this.key1 = key1;
            this.key2 = key2;
        }
        public int hashCode()    {
            return key1.hashCode() ^ key2.hashCode();
        }
        public boolean equals(Object obj)    {
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;
            Pair<?,?> pair = (Pair<?, ?>) obj;
            return key1.equals(pair.key1) && key2.equals(pair.key2);
        }

    }
    private final Map<Pair<K1, K2>, V> map = new HashMap<>();

    public void put(K1 k1, K2 k2, V v)  {
        map.put(new Pair<>(k1,k2), v);
    }
    public V get(K1 k1,K2 k2) {
       return map.get(new Pair<>(k1,k2));
    }
}
