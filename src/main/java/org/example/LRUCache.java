package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU cache
 */
public class LRUCache<K, V> {
    private class Node {
        K key;
        V value;
        Node prev;
        Node next;
    }

    private final Map<K, Node> cache;
    private final int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            if (cache.size() == capacity) {
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addToHead(newNode);
        }
    }
}
