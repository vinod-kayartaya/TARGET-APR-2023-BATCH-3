package com.targetindia.tests;

import com.targetindia.utils.MathUtil;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilPowerTests {

    MathUtil mu;

    @BeforeEach
    void setup(){
        mu = new MathUtil();
    }

    @Test
    void shouldGetPower(){
        int a = 2;
        int b = 10;
        double expected = 1024;
        double actual = mu.power(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetNegativePower(){
        int a = 2;
        int b = -10;
        double expected = 0.0009765625;
        double actual = mu.power(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetPowerOfNegativeNumber(){
        assertEquals(2401, mu.power(-7, 4));
        assertEquals(-343, mu.power(-7, 3));
    }
}
