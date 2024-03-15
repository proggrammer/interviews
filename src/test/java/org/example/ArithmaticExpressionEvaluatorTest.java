package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmaticExpressionEvaluatorTest {

    @Test
    void evaluateTest() {
        String expression = "(2+4) * (4+6)";
        double result = ArithmaticExpressionEvaluator.evaluate(expression);
        Assertions.assertEquals(result, 1);
    }
}