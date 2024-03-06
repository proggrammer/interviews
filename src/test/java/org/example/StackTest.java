package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    void allOperation() {
        Stack<String> stringStack = new Stack<>();

        Assertions.assertEquals(stringStack.isEmpty(), true);

        stringStack.push("hello");

        Assertions.assertEquals(stringStack.peek(), "hello");
        Assertions.assertEquals(stringStack.pop(), "hello");
        Assertions.assertThrows(IllegalStateException.class, stringStack::pop);
        Assertions.assertThrows(IllegalStateException.class, stringStack::peek);
    }
}