package org.example;

import org.example.util.CheckedConversionException;
import org.junit.jupiter.api.Test;

class UncheckedToCheckedExceptionTest {

    @Test
    void performUncheckedOperation() {
        try {
            UncheckedToCheckedException.performUncheckedOperation(10, 0);
        } catch (CheckedConversionException e) {
            // Ensure that the CheckedConversionException is thrown with the expected message
            assert e.getMessage().contains("Unchecked exception converted to checked");
        }
    }
}