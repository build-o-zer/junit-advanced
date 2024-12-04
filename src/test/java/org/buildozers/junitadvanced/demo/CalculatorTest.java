package org.buildozers.junitadvanced.demo;

import static org.assertj.core.api.Assertions.*;

import org.buildozers.junitadvanced.preconditions.PreconditionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Given a calculator")
class CalculatorTest {

    private Calculator calculator;

    @Test
    @DisplayName("when a new instance is created, then the current value should be 0")
    void instanceCreation() {
        calculator = new Calculator();
        assertThat(calculator.getCurrentValue()).isZero();
    }

    @Nested
    @DisplayName("and a brand new one is created")
    class PoweredOnCalculatorTest {

        @BeforeEach
        void setUp() {
            calculator = new Calculator();
        }

        @Test
        @DisplayName("when add() is called with a value, then the current value should be increased by that value")
        void testAdd() {
            // when
            calculator.add(5);
            // then
            assertThat(calculator).extracting(Calculator::getCurrentValue)
                    .isEqualTo(5L);
        }

        @Test
        @DisplayName("when reset() is called, then the current value should be 0")
        void testReset() {
            // when
            calculator.reset();
            // then
            assertThat(calculator.getCurrentValue()).isZero();
        }

        @Test
        @DisplayName("when subtract() is called with a value, then the current value should be decreased by that value")
        void testSubtract() {
            // when
            calculator.subtract(3);
            // then
            assertThat(calculator).extracting(Calculator::getCurrentValue).isEqualTo(-3L);
        }

        @Test
        @DisplayName("when multiply() is called with a value, then the current value should be multiplied by that value")
        void testMultiply() {
            // given
            calculator.add(4);
            // when
            calculator.multiply(3);
            // then
            assertThat(calculator).extracting(Calculator::getCurrentValue).isEqualTo(12L);
        }

        @Test
        @DisplayName("when divide() is called with a non-zero value, then the current value should be divided by that value")
        void testDivide() {
            // given
            calculator.add(20);
            // when
            calculator.divide(4);
            // then
            assertThat(calculator).extracting(Calculator::getCurrentValue).isEqualTo(5L);
        }

        @Test
        @DisplayName("when divide() is called with zero, then an IllegalArgumentException should be thrown")
        void testDivideByZero() {
            // when / then
            assertThatThrownBy(() -> calculator.divide(0))
                    .isInstanceOf(PreconditionException.class)
                    .hasMessageContaining("Cannot divide by zero");
        }

    }

    @Nested
    @DisplayName("and its current value is set to 30")
    class StatefulCalculatorTest {

        @BeforeEach
        void setUp() {
            calculator = new Calculator();
            calculator.add(30);
        }

        @Test
        @DisplayName("when add() is called with a value, then the current value should be increased by that value")
        void testAdd() {
            // when
            calculator.add(5);
            // then
            assertThat(calculator).extracting(Calculator::getCurrentValue)
                    .isEqualTo(35L);
        }

        @Test
        @DisplayName("when reset() is called, then the current value should be 0")
        void testReset() {
            // when
            calculator.reset();
            // then
            assertThat(calculator.getCurrentValue()).isZero();
        }

        @Test
        @DisplayName("when subtract() is called with a value, then the current value should be decreased by that value")
        void testSubtract() {
            // when
            calculator.subtract(3);
            // then
            assertThat(calculator).extracting(Calculator::getCurrentValue)
                    .isEqualTo(27L);
        }

        @Test
        @DisplayName("when multiply() is called with a value, then the current value should be multiplied by that value")
        void testMultiply() {
            // when
            calculator.multiply(3);
            // then
            assertThat(calculator).extracting(Calculator::getCurrentValue).isEqualTo(90L);
        }

        @Test
        @DisplayName("when divide() is called with a non-zero value, then the current value should be divided by that value")
        void testDivide() {
            // when
            calculator.divide(3);
            // then
            assertThat(calculator).extracting(Calculator::getCurrentValue).isEqualTo(10L);
        }

        @Test
        @DisplayName("when divide() is called with zero, then an IllegalArgumentException should be thrown")
        void testDivideByZero() {
            // when / then
            assertThatThrownBy(() -> calculator.divide(0))
                    .isInstanceOf(PreconditionException.class)
                    .hasMessageContaining("Cannot divide by zero");
        }

    }

    @Nested
    @DisplayName("and a CSV source as annotations is provided with a current value of 30")
    class CSVSourceCalculatorTest {

        @BeforeEach
        void setUp() {
            calculator = new Calculator();
            calculator.add(30);
        }

        @DisplayName("when add() is called with a value, then the current value should be increased by that value")
        @ParameterizedTest
        @CsvSource({ "30,60", "4,34", "20,50" })
        void testAdd(int value, long expected) {
            // when
            calculator.add(value);
            // then
            assertThat(calculator).extracting(Calculator::getCurrentValue)
                    .isEqualTo(expected);
        }

    }

    @Nested
    @DisplayName("and a CSV source files as annotations are provided with a current value of 5")
    class CSVSourceFileCalculatorTest {

        @BeforeEach
        void setUp() {
            calculator = new Calculator();
            calculator.add(5);
        }

        @DisplayName("when multiply() is called with a value, then the current value should be multiplied by that value")
        @ParameterizedTest
        @CsvFileSource(resources = "/calculator-test/multiplications.csv", numLinesToSkip = 4)
        void testMultiplication(int value, long expected) {
            // when
            calculator.multiply(value);
            // then
            assertThat(calculator).extracting(Calculator::getCurrentValue)
                    .isEqualTo(expected);
        }

        @DisplayName("when add() is called with a value, then the current value should be added by that value")
        @ParameterizedTest
        @CsvFileSource(resources = "/calculator-test/additions.csv", numLinesToSkip = 4)
        void testAddition(int value, long expected) {
            // when
            calculator.add(value);
            // then
            assertThat(calculator).extracting(Calculator::getCurrentValue)
                    .isEqualTo(expected);
        }

    }

}