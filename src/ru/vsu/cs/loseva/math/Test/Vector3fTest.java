package ru.vsu.cs.loseva.math.Test;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.loseva.math.Vector.Vector3f;

import static org.junit.jupiter.api.Assertions.*;

class Vector3fTest {

    @Test
    void add() {
        Vector3f v1 = new Vector3f(1.0, 2.0, 3.0);
        Vector3f v2 = new Vector3f(4.0, 5.0, 6.0);
        Vector3f result = v1.add(v2);
        assertEquals(5.0, result.get(0), 0.01);
        assertEquals(7.0, result.get(1), 0.01);
        assertEquals(9.0, result.get(2), 0.01);
    }

    @Test
    void subtract() {
        Vector3f v1 = new Vector3f(4.0, 5.0, 6.0);
        Vector3f v2 = new Vector3f(1.0, 2.0, 3.0);
        Vector3f result = v1.subtract(v2);
        assertEquals(3.0, result.get(0), 0.01);
        assertEquals(3.0, result.get(1), 0.01);
        assertEquals(3.0, result.get(2), 0.01);
    }

    @Test
    void multiply() {
        Vector3f v1 = new Vector3f(2.0, 3.0, 4.0);
        double scalar = 2.0;
        Vector3f result = v1.multiply(scalar);
        assertEquals(4.0, result.get(0), 0.01);
        assertEquals(6.0, result.get(1), 0.01);
        assertEquals(8.0, result.get(2), 0.01);
    }

    @Test
    void divide() {
        Vector3f v1 = new Vector3f(6.0, 8.0, 10.0);
        double scalar = 2.0;
        Vector3f result = v1.divide(scalar);
        assertEquals(3.0, result.get(0), 0.01);
        assertEquals(4.0, result.get(1), 0.01);
        assertEquals(5.0, result.get(2), 0.01);
    }

    @Test
    void length() {
        Vector3f v = new Vector3f(3.0, 4.0, 5.0);
        double result = v.length();
        double expected = 7.0710678118654755; // Примерное значение
        assertEquals(expected, result, 0.00001); // Учитывать погрешность
    }

    @Test
    void normalize() {
        Vector3f v = new Vector3f(1.0, 2.0, 2.0);
        Vector3f result = v.normalize();
        double length = result.length();
        assertTrue(Math.abs(length - 1.0) < 0.00001);
    }

    @Test
    void dotProduct() {
        Vector3f v1 = new Vector3f(1.0, 2.0, 3.0);
        Vector3f v2 = new Vector3f(4.0, 5.0, 6.0);
        double result = v1.dotProduct(v2);
        double expected = 32.0;
        assertEquals(expected, result, 0.00001); // Учитывать погрешность
    }

    @Test
    void crossProduct() {
        Vector3f v1 = new Vector3f(1.0, 0.0, 0.0);
        Vector3f v2 = new Vector3f(0.0, 1.0, 0.0);
        Vector3f result = v1.crossProduct(v2);
        assertEquals(0.0, result.get(0), 0.01);
        assertEquals(0.0, result.get(1), 0.01);
        assertEquals(1.0, result.get(2), 0.01);
    }
}