package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Arithmatic expression evaluator
 * //:TODO not correct implementation
 */
public class ArithmaticExpressionEvaluator {
    public static double evaluate(String expression) {
        String postfix = infixToPostfix(expression);
        return evaluatePostfix(postfix);
    }

    public static String infixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(" "+c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(" "+stack.pop());
                }
                stack.pop(); // Remove the '('
            } else if (isOperator(c)) { // Operator
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(" "+stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(" "+stack.pop());
        }

        return postfix.toString();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static double evaluatePostfix(String postfix) {
        Deque<Double> stack = new ArrayDeque<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
            } else { // Operator
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result;
                switch (c) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + c);
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0; // Parentheses
        }
    }
}
