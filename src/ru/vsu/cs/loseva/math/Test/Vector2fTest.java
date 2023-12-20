package ru.vsu.cs.loseva.math.Test;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.loseva.math.Vector.Vector2f;

import static org.junit.jupiter.api.Assertions.*;

class Vector2fTest {

    @Test
    void add() {
        Vector2f vector1 = new Vector2f(3.0, 4.0);
        Vector2f vector2 = new Vector2f(1.0, 2.0);
        Vector2f result = vector1.add(vector2);
        assertEquals(4.0, result.get(0), 0.01);
        assertEquals(6.0, result.get(1), 0.01);
    }

    @Test
    void subtract() {
        Vector2f vector1 = new Vector2f(3.0, 4.0);
        Vector2f vector2 = new Vector2f(1.0, 2.0);
        Vector2f result = vector1.subtract(vector2);
        assertEquals(2.0, result.get(0), 0.01);
        assertEquals(2.0, result.get(1), 0.01);
    }

    @Test
    void multiply() {
        Vector2f vector = new Vector2f(3.0, 4.0);
        Vector2f result = vector.multiply(2.0);
        assertEquals(6.0, result.get(0), 0.01);
        assertEquals(8.0, result.get(1), 0.01);
    }

    @Test
    void divide() {
        Vector2f vector = new Vector2f(6.0, 8.0);
        Vector2f result = vector.divide(2.0);
        assertEquals(3.0, result.get(0), 0.01);
        assertEquals(4.0, result.get(1), 0.01);
    }

    @Test
    void length() {
        Vector2f vector = new Vector2f(3.0, 4.0);
        double length = vector.length();
        assertEquals(5.0, length, 0.01);
    }

    @Test
    void normalize() {
        Vector2f vector = new Vector2f(3.0, 4.0);
        Vector2f result = vector.normalize();
        assertEquals(0.6, result.get(0), 0.01);
        assertEquals(0.8, result.get(1), 0.01);
    }

    @Test
    void dotProduct() {
        Vector2f vector1 = new Vector2f(3.0, 4.0);
        Vector2f vector2 = new Vector2f(1.0, 2.0);
        double dotProduct = vector1.dotProduct(vector2);
        assertEquals(11.0, dotProduct, 0.01);
    }
}