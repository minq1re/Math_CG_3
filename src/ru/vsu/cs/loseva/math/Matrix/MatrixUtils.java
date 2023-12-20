package ru.vsu.cs.loseva.math.Matrix;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtils {
    public static double[][] submatrix(double[][] matrix, int row, int column) {
        double[][] submatrix = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    submatrix[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return submatrix;
    }

    public static double determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new IllegalStateException("invalid dimensions");

        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i] * determinant(submatrix(matrix, 0, i));
        return det;
    }

    public static double[][] matrixInverse(double[][] matrix) {
        double[][] matrixInverse = new double[matrix.length][matrix.length];

        double det = determinant(matrix);
        if (det == 0) {
            throw new IllegalArgumentException("Определитель = 0!");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixInverse[i][j] = Math.pow(-1, i + j) * determinant(submatrix(matrix, i, j));
            }
        }

        det = 1.0 / det;
        for (int i = 0; i < matrixInverse.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = matrixInverse[i][j];
                matrixInverse[i][j] = matrixInverse[j][i] * det;
                matrixInverse[j][i] = temp * det;
            }
        }

        return matrixInverse;
    }

    protected static double[][] add(double[][] matrixFirst, double[][] matrixSecond) {
        if (matrixFirst.length != matrixFirst[0].length && matrixSecond.length != matrixSecond[0].length
                && matrixFirst.length != matrixSecond.length && matrixFirst[0].length != matrixSecond[0].length) {
            throw new ArithmeticException("Размер матриц не совпадает или матрицы не квадратные");
        } else {
            double[][] result = new double[matrixFirst.length][matrixFirst.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = matrixFirst[i][j] + matrixSecond[i][j];
                }
            }

            return result;
        }
    }

    protected static double[][] subtract(double[][] matrixFirst, double[][] matrixSecond) {
        if (matrixFirst.length != matrixFirst[0].length && matrixSecond.length != matrixSecond[0].length
                && matrixFirst.length != matrixSecond.length && matrixFirst[0].length != matrixSecond[0].length) {
            throw new ArithmeticException("Размер матриц не совпадает или матрицы не квадратные");
        } else {
            double[][] result = new double[matrixFirst.length][matrixFirst.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = matrixFirst[i][j] - matrixSecond[i][j];
                }
            }

            return result;
        }
    }

    protected static double[] multiply(double[][] matrixFirst, double[] vector) {
        if (vector == null) {
            throw new NullPointerException("Вектор не может быть нулевым");
        }
        if (matrixFirst.length != matrixFirst[0].length && matrixFirst[0].length != vector.length) {
            throw new ArithmeticException("Матрица не квадратная или размер не совпадает с длиной вектора");
        } else {
            double[] result = new double[matrixFirst.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = 0;
                for (int j = 0; j < matrixFirst.length; j++) {
                    result[i] += matrixFirst[i][j] * vector[j];
                }
            }
            return result;
        }
    }

    protected static double[][] multiplyMatrix(double[][] matrixFirst, double[][] matrixSecond) {
        if (matrixFirst.length != matrixFirst[0].length && matrixSecond.length != matrixSecond[0].length
                && matrixFirst.length != matrixSecond.length && matrixFirst[0].length != matrixSecond[0].length) {
            throw new ArithmeticException("Размер матриц не совпадает или матрицы не квадратные");
        } else {
            double[][] result = new double[matrixFirst.length][matrixFirst.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < result.length; k++) {
                        result[i][j] += matrixFirst[i][k] * matrixSecond[k][j];
                    }
                }
            }
            return result;
        }
    }

    protected static double[][] transpose(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new ArithmeticException("Матрица не квадратная");
        } else {
            double[][] returnMatrix = new double[matrix.length][matrix.length];
            for (int i = 0; i < returnMatrix.length; i++) {
                for (int j = 0; j < returnMatrix.length; j++) {
                    returnMatrix[j][i] = matrix[i][j];
                }
            }
            return returnMatrix;
        }
    }

    protected static double[][] identity(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i == j) ? 1 : 0;
            }
        }
        return matrix;
    }

    protected static double[][] zero(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }
}
