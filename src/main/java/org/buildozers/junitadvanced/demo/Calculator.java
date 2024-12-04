package org.buildozers.junitadvanced.demo;

import lombok.Getter;
import org.buildozers.junitadvanced.preconditions.Precondition;

/**
 * A simple calculator class that can perform basic arithmetic operations.
 */

public class Calculator {

    @Getter
    private long currentValue = 0;

    /**
     * Resets the calculator to its initial state.
     */
    void reset() {
        currentValue = 0;
    }

    /**
     * Adds the given value to the current value.
     * @param value the value to add
     */
    void add(int value) {
        currentValue += value;
    }

    /**
     * Subtracts the given value from the current value.
     * @param value the value to subtract
     */
    public void subtract(int value) {
        currentValue -= value;
    }

    /**
     * Multiplies the current value by the given value.
     * @param value the value to multiply by
     */
    public void multiply(int value) {
        currentValue *= value;
    }

    /**
     * Divides the current value by the given value.
     * @param value the value to divide by
     * @throws IllegalArgumentException if the given value is zero with a message "Cannot divide by zero"
     */
    public void divide(int value) {
        Precondition.checkPredicate(value, "value", v -> v != 0, "Cannot divide by zero");
        currentValue /= value;
    }

}
