package org.example;

class CheckedConversionException extends Exception {
    public CheckedConversionException(String message) {
        super(message);
    }
}

public class UncheckedToCheckedException {
    public static int performUncheckedOperation(int a , int b) throws CheckedConversionException {
        try {
            int result = divideNumbers(a, b);
            System.out.println("Result: " + result);
            return result;
        } catch (ArithmeticException e) {
            // Convert unchecked exception to checked exception
            throw new CheckedConversionException("Unchecked exception converted to checked: " + e.getMessage());
        }
    }

    private static int divideNumbers(int a, int b) {
        return a / b;
    }
}
