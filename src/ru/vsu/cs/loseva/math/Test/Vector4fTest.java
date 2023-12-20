package ru.vsu.cs.loseva.math.Test;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.loseva.math.Vector.Vector4f;

import static org.junit.jupiter.api.Assertions.*;

class Vector4fTest {

    @Test
    void add() {
        Vector4f v1 = new Vector4f(1.0, 2.0, 3.0, 4.0);
        Vector4f v2 = new Vector4f(4.0, 5.0, 6.0, 7.0);
        Vector4f result = v1.add(v2);
        assertEquals(5.0, result.get(0), 0.01);
        assertEquals(7.0, result.get(1), 0.01);
        assertEquals(9.0, result.get(2), 0.01);
        assertEquals(11.0, result.get(3), 0.01);
    }

    @Test
    void subtract() {
        Vector4f v1 = new Vector4f(4.0, 5.0, 6.0, 7.0);
        Vector4f v2 = new Vector4f(1.0, 2.0, 3.0, 4.0);
        Vector4f result = v1.subtract(v2);
        assertEquals(3.0, result.get(0), 0.01);
        assertEquals(3.0, result.get(1), 0.01);
        assertEquals(3.0, result.get(2), 0.01);
        assertEquals(3.0, result.get(3), 0.01);
    }

    @Test
    void multiply() {
        Vector4f v1 = new Vector4f(2.0, 3.0, 4.0, 5.0);
        double scalar = 2.0;
        Vector4f result = v1.multiply(scalar);
        assertEquals(4.0, result.get(0), 0.01);
        assertEquals(6.0, result.get(1), 0.01);
        assertEquals(8.0, result.get(2), 0.01);
        assertEquals(10.0, result.get(3), 0.01);
    }

    @Test
    void divide() {
        Vector4f v1 = new Vector4f(6.0, 8.0, 10.0, 12.0);
        double scalar = 2.0;
        Vector4f result = v1.divide(scalar);
        assertEquals(3.0, result.get(0), 0.01);
        assertEquals(4.0, result.get(1), 0.01);
        assertEquals(5.0, result.get(2), 0.01);
        assertEquals(6.0, result.get(3), 0.01);
    }

    @Test
    void length() {
        Vector4f v = new Vector4f(3.0, 4.0, 5.0, 6.0);
        double result = v.length();
        double expected = 9.273618495495704; // Примерное значение
        assertEquals(expected, result, 0.00001);
    }

    @Test
    void normalize() {
        Vector4f v = new Vector4f(1.0, 2.0, 2.0, 2.0);
        Vector4f result = v.normalize();
        double length = result.length();
        assertTrue(Math.abs(length - 1.0) < 0.00001);
    }

    @Test
    void dotProduct() {
        Vector4f v1 = new Vector4f(1.0, 2.0, 3.0, 4.0);
        Vector4f v2 = new Vector4f(4.0, 5.0, 6.0, 7.0);
        double result = v1.dotProduct(v2);
        double expected = 60.0;
        assertEquals(expected, result, 0.00001); // Учитывать погрешность
    }
}