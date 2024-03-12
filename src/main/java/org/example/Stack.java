package org.example;

import java.util.LinkedList;

/**
 * Implement Stack in Java.
 * @param <T>
 */
public class Stack <T>{
    private LinkedList<T> linkedList = new LinkedList<>();

    public void push(T value)   {
        linkedList.addFirst(value);
    }

    public T pop()  {
        if(linkedList.isEmpty()) throw new IllegalStateException("Empty stack");
        return linkedList.removeFirst();
    }

    public T peek() {
        if(linkedList.isEmpty()) throw new IllegalStateException("Empty stack");
        return linkedList.getFirst();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
}
