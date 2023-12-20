package ru.vsu.cs.loseva.math.Matrix;

import ru.vsu.cs.loseva.math.Vector.Vector3f;

public class Matrix3 {
    private static final int size = 3;

    private double[][] values = new double[3][3];

    public Matrix3(double[][] matrix) {
        if (matrix.length == 3 && matrix[0].length == 3) {
            this.values = matrix;
        } else {
            throw new ArithmeticException("Некорректный размер матрицы");
        }
    }

    public double[][] getMatrix() {
            return values;
        }

        // Сложение матриц
    public Matrix3 add(Matrix3 matrix) {
        return new Matrix3(MatrixUtils.add(this.values, matrix.values));
    }

        // Вычитание матриц
    public Matrix3 subtract(Matrix3 matrix) {
        return new Matrix3(MatrixUtils.subtract(this.values, matrix.values));
    }

        //Умножение на вектор3Д
    public Vector3f multiply(Vector3f vector) {
        double[] returnVector = MatrixUtils.multiply(this.values, new double[]{vector.get(0), vector.get(1), vector.get(2)});
        return new Vector3f(returnVector[0], returnVector[1], returnVector[2]);
    }

        // Умножение на матрицу
    public Matrix3 multiplyMatrix(Matrix3 matrix) {
        return new Matrix3(MatrixUtils.multiplyMatrix(this.values, matrix.values));
    }

        // Транспонирование
    public Matrix3 transpose() {
        return new Matrix3(MatrixUtils.transpose(this.values));
    }

        // Задание единичной матрицы
    public static Matrix3 identity() {
            return new Matrix3(MatrixUtils.identity(size));
        }

        // Задание нулевой матрицы
   public static Matrix3 zero() {
            return new Matrix3(MatrixUtils.zero(size));
        }
}
