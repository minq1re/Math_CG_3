package ru.vsu.cs.loseva.math.Test;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.loseva.math.Matrix.MatrixUtils;

import static org.junit.jupiter.api.Assertions.*;

class MatrixUtilsTest {

    @Test
    void submatrix() {
        double[][] inputMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int row = 1;
        int column = 1;
        double[][] expectedSubmatrix = {
                {1, 3},
                {7, 9}
        };
        double[][] result = MatrixUtils.submatrix(inputMatrix, row, column);
        assertArrayEquals(expectedSubmatrix, result);
    }

    @Test
    void determinant() {
        double[][] inputMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double expectedResult = 0;
        double result = MatrixUtils.determinant(inputMatrix);
        assertEquals(expectedResult, result);
    }

    @Test
    void matrixInverse() {
        double[][] inputMatrix = {
                {3, -5},
                {1, -2}
        };
        double[][] expectedMatrix = {
                {2, -5},
                {1, -3}
        };
        double[][] result = MatrixUtils.matrixInverse(inputMatrix);
        assertArrayEquals(expectedMatrix, result);
    }

    @Test
    void matrixInverseDet0() {
        double[][] inputMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThrows(IllegalArgumentException.class, () -> MatrixUtils.matrixInverse(inputMatrix));
    }
}