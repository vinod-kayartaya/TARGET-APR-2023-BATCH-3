package com.targetindia.tests;

import com.targetindia.utils.MathUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MathUtilFactorialTests {

    MathUtil mu;

    @BeforeEach
    void setup() {
        mu = new MathUtil();
    }

    // since JUnit calls this function, it is the responsibility of JUnit to pass the parameters
    // but from where?

    @ParameterizedTest
    @CsvSource({"1,1", "5,120", "4,24", "0,1"})
    void shouldPassForAllInputs(int input, long expected) {
        long actual = mu.factorial(input);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"num-and-factorials.txt"}, numLinesToSkip = 1)
    void shouldPassForAllInputsFromFile(int input, long expected) {
        long actual = mu.factorial(input);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("factorialInputs")
    void shouldPass(int input, long expected) {
        long actual = mu.factorial(input);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> factorialInputs() {
        return Stream.of(
                Arguments.of(7, 5040),
                Arguments.of(8, 40320)
        );
    }


}
