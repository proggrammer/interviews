package org.example;
import org.example.util.CheckedConversionException;

/**
 * Example of unchecked exceptions to checked Exception.
 */
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
