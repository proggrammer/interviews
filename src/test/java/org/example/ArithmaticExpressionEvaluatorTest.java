package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmaticExpressionEvaluatorTest {

    @Test
    void evaluateTest() {
        String expression = "3 + 4 * 2 / (1 - 5)";
        double result = ArithmaticExpressionEvaluator.evaluate(expression);
        Assertions.assertEquals(result, 1);
    }
}