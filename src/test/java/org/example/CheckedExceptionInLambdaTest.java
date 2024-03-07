package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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