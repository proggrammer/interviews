package org.example;

import org.example.util.Pair;
import org.junit.jupiter.api.Test;
import org.example.util.CheckedConversionException;

import java.util.List;

class CheckedExceptionInLambdaTest {

    @Test
    void invoke() {
        final List<Pair> pairList = List.of(new Pair(1,2), new Pair(1,0));
        try {
            CheckedExceptionInLambda.invoke(pairList);
        } catch (CheckedConversionException e) {
            assert e.getMessage().contains("Unchecked exception converted to checked");
        }
    }
}