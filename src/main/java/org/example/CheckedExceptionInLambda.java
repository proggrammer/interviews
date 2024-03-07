package org.example;

import org.example.util.Pair;

import java.util.List;
import java.util.stream.Collectors;

public class CheckedExceptionInLambda {
    public static void invoke(List<Pair> inputPairs) throws CheckedConversionException {

        try {
            List<Integer> values = inputPairs.stream().map(p -> {
                try {
                    return UncheckedToCheckedException.performUncheckedOperation(p.x, p.y);
                } catch (CheckedConversionException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        }
        catch(RuntimeException e)   {
            if (e.getCause() instanceof CheckedConversionException) {
                throw (CheckedConversionException) e.getCause();
            } else {
                throw new CheckedConversionException("Unchecked exception converted to checked: " + e.getMessage());
            }
        }
    }
}
