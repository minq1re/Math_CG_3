package ru.vsu.cs.loseva.math.Test;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.loseva.math.Matrix.Matrix3;
import ru.vsu.cs.loseva.math.Vector.Vector3f;

import static org.junit.jupiter.api.Assertions.*;

class Matrix3Test {
    @Test
    void testAdd() {
        double[][] data1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] data2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        Matrix3 m1 = new Matrix3(data1);
        Matrix3 m2 = new Matrix3(data2);

        Matrix3 result = m1.add(m2);

        double[][] expectedData = {
                {10, 10, 10},
                {10, 10, 10},
                {10, 10, 10}
        };
        Matrix3 expected = new Matrix3(expectedData);
        for (int i = 0; i < 3; i++){
            for (int j = 0; i < 3; i++) {
                assertEquals(expected.getMatrix()[i][j], result.getMatrix()[i][j], 0.001);
            }
        }
    }

    @Test
    public void testSubtraction() {
        double[][] data1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] data2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        Matrix3 m1 = new Matrix3(data1);
        Matrix3 m2 = new Matrix3(data2);

        Matrix3 result = m1.subtract(m2);

        double[][] expectedData = {
                {-8, -6, -4},
                {-2, 0, 2},
                {4, 6, 8}
        };
        Matrix3 expected = new Matrix3(expectedData);

        for (int i = 0; i < 3; i++){
            for (int j = 0; i < 3; i++) {
                assertEquals(expected.getMatrix()[i][j], result.getMatrix()[i][j], 0.001);
            }
        }
    }

    @Test
    public void testVectorMultiplication() {
        double[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix3 matrix = new Matrix3(data);
        Vector3f vector = new Vector3f(2, 3, 4);

        Vector3f result = matrix.multiply(vector);

        Vector3f expected = new Vector3f(20, 47, 74);

        for (int i = 0; i < 3; i++){
            assertEquals(expected.get(i), result.get(i), 0.001);
        }
    }

    @Test
    public void testMatrixMultiplication() {
        double[][] data1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] data2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        Matrix3 m1 = new Matrix3(data1);
        Matrix3 m2 = new Matrix3(data2);

        Matrix3 result = m1.multiplyMatrix(m2);

        double[][] expectedData = {
                {30, 24, 18},
                {84, 69, 54},
                {138, 114, 90}
        };
        Matrix3 expected = new Matrix3(expectedData);

        for (int i = 0; i < 3; i++){
            for (int j = 0; i < 3; i++) {
                assertEquals(expected.getMatrix()[i][j], result.getMatrix()[i][j], 0.001);
            }
        }
    }

    @Test
    public void testTranspose() {
        double[][] data = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix3 matrix = new Matrix3(data);

        Matrix3 result = matrix.transpose();

        double[][] expectedData = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        Matrix3 expected = new Matrix3(expectedData);

        for (int i = 0; i < 3; i++){
            for (int j = 0; i < 3; i++) {
                assertEquals(expected.getMatrix()[i][j], result.getMatrix()[i][j], 0.001);
            }
        }
    }

    @Test
    public void testIdentityMatrix() {
        Matrix3 identity = Matrix3.identity();

        double[][] expectedData = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        double[][] actualData = identity.getMatrix();

        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void testZeroMatrix() {
        Matrix3 zero = Matrix3.zero();

        double[][] expectedData = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        double[][] actualData = zero.getMatrix();

        assertArrayEquals(expectedData, actualData);
    }
}