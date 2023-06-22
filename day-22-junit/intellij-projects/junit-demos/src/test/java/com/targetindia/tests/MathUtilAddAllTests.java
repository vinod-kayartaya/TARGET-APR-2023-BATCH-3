package com.targetindia.tests;

import com.targetindia.utils.MathUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilAddAllTests {
    MathUtil mu;

    @BeforeEach
    void init() {
        mu = new MathUtil();
    }

    @Test
    void testAddAllNumbers() {
        double actual = mu.addAll(10, 20, 30);
        double expected = 60;
        assertEquals(expected, actual);
    }

    @Test
    void testAddAllNumbersAndStrings() {
        double actual = mu.addAll(10.0, "20", "30", 50, 1f);
        double expected = 111;
        assertEquals(expected, actual);
    }

    @Test
    void testAddAllWithIntegerInputs() {
        byte b = 10;
        short s = 20;
        long l = 19l;
        double actual = mu.addAll(b, s, l);
        double expected = 49.0;
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionForStringWithNonNumericValue() {
        try {
            mu.addAll(10, 20, "vinod", "kumar");
            // this is wrong!!
            // we were supposed to get an exception - IllegalArgumentException
            fail("Expecting IllegalArgumentException to be thrown; but did not get one!");
        } catch (IllegalArgumentException e) {
            // do not have to do anything!
            // test passed
        }
    }

    @Test
    void shouldThrowExceptionForIncompatibleTypes() {
        assertThrows(IllegalArgumentException.class, () -> mu.addAll(10, 20, new Date()));
    }

}
