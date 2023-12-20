package ru.vsu.cs.loseva.math.Test;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.loseva.math.Matrix.Matrix4;
import ru.vsu.cs.loseva.math.Vector.Vector4f;

import static org.junit.jupiter.api.Assertions.*;

class Matrix4Test {

    @Test
    void add() {
        double[][] data1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        double[][] data2 = {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        };
        Matrix4 m1 = new Matrix4(data1);
        Matrix4 m2 = new Matrix4(data2);

        Matrix4 result = m1.add(m2);

        double[][] expectedData = {
                {17, 17, 17, 17},
                {17, 17, 17, 17},
                {17, 17, 17, 17},
                {17, 17, 17, 17}
        };

        assertArrayEquals(expectedData, result.getMatrix());
    }

    @Test
    void subtract() {
        double[][] data1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        double[][] data2 = {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        };
        Matrix4 m1 = new Matrix4(data1);
        Matrix4 m2 = new Matrix4(data2);

        Matrix4 result = m1.subtract(m2);

        double[][] expectedData = {
                {-15, -13, -11, -9},
                {-7, -5, -3, -1},
                {1, 3, 5, 7},
                {9, 11, 13, 15}
        };
        assertArrayEquals(expectedData, result.getMatrix());
    }

    @Test
    void multiply() {
        double[][] matrixData = {
                {2, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 2}
        };
        Matrix4 matrix = new Matrix4(matrixData);

        double[] vectorData = {1, 2, 3, 4};
        Vector4f vector = new Vector4f(vectorData[0], vectorData[1],vectorData[2], vectorData[3]);

        Vector4f result = matrix.multiply(vector);

        assertEquals(2, result.get(0), 0.01);
        assertEquals(4, result.get(1), 0.01);
        assertEquals(6, result.get(2), 0.01);
        assertEquals(8, result.get(3), 0.01);
    }

    @Test
    void multiplyMatrix() {
        double[][] matrixData1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Matrix4 matrix1 = new Matrix4(matrixData1);

        double[][] matrixData2 = {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        };
        Matrix4 matrix2 = new Matrix4(matrixData2);

        Matrix4 result = matrix1.multiplyMatrix(matrix2);

        double[][] expectedData = {
                {80, 70, 60, 50},
                {240, 214, 188, 162},
                {400, 358, 316, 274},
                {560, 502, 444, 386}
        };
        assertArrayEquals(expectedData, result.getMatrix());
    }

    @Test
    void transpose() {
        double[][] matrixData = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Matrix4 matrix = new Matrix4(matrixData);

        Matrix4 transposed = matrix.transpose();

        double[][] expectedData = {
                {1, 5, 9, 13},
                {2, 6, 10, 14},
                {3, 7, 11, 15},
                {4, 8, 12, 16}
        };
        assertArrayEquals(expectedData, transposed.getMatrix());
    }

    @Test
    void identity() {
        Matrix4 identity = Matrix4.identity();
        double[][] data = identity.getMatrix();

        double[][] expectedData = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        assertArrayEquals(expectedData, data);
    }

    @Test
    void zero() {
        Matrix4 zero = Matrix4.zero();
        double[][] data = zero.getMatrix();

        double[][] expectedData = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        assertArrayEquals(expectedData, data);
    }
}