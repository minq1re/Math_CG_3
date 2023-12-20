package ru.vsu.cs.loseva.math.Matrix;

import ru.vsu.cs.loseva.math.Vector.Vector4f;

public class Matrix4 {
    private static final int size = 4;

    private double[][] values = new double[4][4];

    public Matrix4(double[][] matrix) {
        if (matrix.length == 4 && matrix[0].length == 4) {
            this.values = matrix;
        } else {
            throw new ArithmeticException("Некорректный размер матрицы");
        }
    }

    public double[][] getMatrix() {
        return values;
    }

    // Сложение матриц
    public Matrix4 add(Matrix4 matrix) {
        return new Matrix4(MatrixUtils.add(this.values, matrix.values));
    }

    // Вычитание матриц
    public Matrix4 subtract(Matrix4 matrix) {
        return new Matrix4(MatrixUtils.subtract(this.values, matrix.values));
    }

    //Умножение на вектор3Д
    public Vector4f multiply(Vector4f vector) {
        double[] returnVector = MatrixUtils.multiply(this.values, new double[]{vector.get(0), vector.get(1),
                vector.get(2), vector.get(3)});
        return new Vector4f(returnVector[0], returnVector[1], returnVector[2], returnVector[3]);
    }

    // Умножение на матрицу
    public Matrix4 multiplyMatrix(Matrix4 matrix) {
        return new Matrix4(MatrixUtils.multiplyMatrix(this.values, matrix.values));
    }

    // Транспонирование
    public Matrix4 transpose() {
        return new Matrix4(MatrixUtils.transpose(this.values));
    }

    // Задание единичной матрицы
    public static Matrix4 identity() {
        return new Matrix4(MatrixUtils.identity(size));
    }

    // Задание нулевой матрицы
    public static Matrix4 zero() {
        return new Matrix4(MatrixUtils.zero(size));
    }
}
