package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {

    @Test
    void rotateMatrixTest() {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        RotateMatrix.rotateMatrix(matrix);

        Assertions.assertEquals(7, matrix[0][0]);
    }
}