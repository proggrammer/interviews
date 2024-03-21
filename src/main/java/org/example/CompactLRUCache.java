package org.example;

import java.util.HashMap;
import java.util.Map;

public class CompactLRUCache <K, V>{
    class Tuple {
        K next;
        K prev;
        V value;
    }

    private K start, end;

    private int capacity;
    private Map<K, Tuple> map;

    public CompactLRUCache(int c)   {
        this.capacity = c;
        map = new HashMap<>();
        start = null;
        end = null;
    }

    public V get(K key) {
        if(!map.containsKey(key)) return null;
        V v = map.get(key).value;
        removeNode(key);
        addInFront(key, v);
        return v;
    }

    public void put(K key, V value) {
        if(map.containsKey(key))    {
            map.get(key).value = value;
            removeNode(key);
            addInFront(key, value);
        }
        else    {
            if(map.size() == capacity)   {
                removeNode(end);
            }
            Tuple tuple = new Tuple();
            tuple.value = value;
            map.put(key, tuple);
            addInFront(key, value);
        }
    }

    private void removeNode(K key) {
        if(start == end)    {
            start = end = null;
        }
        else if(start == key)   {
            start = map.get(start).next;
            map.get(start).prev = null;
        }
        else if(end == key) {
            end = map.get(end).prev;
            map.get(end).next = null;
        }
        else {
            map.get(map.get(key).prev).next = map.get(key).next;
            map.get(map.get(key).next).prev = map.get(key).prev;
        }
        map.remove(key);
    }

    private void addInFront(K key, V value)  {
        Tuple tuple = new Tuple();
        tuple.value = value;
        map.put(key, tuple);
        if(start == null)   {
            start = end = key;
            return;
        }
        tuple.next = start;
        map.get(start).prev = key;
        start = key;
    }
}
