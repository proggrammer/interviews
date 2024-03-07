package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UncheckedToCheckedExceptionTest {

    @Test
    void performUncheckedOperation() throws CheckedConversionException {
        try {
            UncheckedToCheckedException.performUncheckedOperation(10, 0);
        } catch (CheckedConversionException e) {
            // Ensure that the CheckedConversionException is thrown with the expected message
            assert e.getMessage().contains("Unchecked exception converted to checked");
        }
    }
}