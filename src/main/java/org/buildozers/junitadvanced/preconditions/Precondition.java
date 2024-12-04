package org.buildozers.junitadvanced.preconditions;

import java.util.function.Predicate;

import lombok.experimental.UtilityClass;

/**
 * Precondition class is responsible for checking preconditions.
 */
@UtilityClass
public class Precondition {

    /**
     * Check if a condition is respected.
     * 
     * @param <T> type of the argument
     * @param t argument to check
     * @param argumentName name of the argument (for error message)
     * @param predicate condition to check as a predicate
     * @param message error message
     */
    public static <T> void checkPredicate(T t, String argumentName, Predicate<T> predicate, String message) {
        if (!predicate.test(t)) {
            throw new PreconditionException(argumentName, message);
        }
    }

    /**
     * Check if an argument is not null.
     * 
     * @param <T> type of the argument
     * @param t argument to check
     * @param argumentName name of the argument (for error message)
     */
    public static <T> void checkNotNull(T t, String argumentName) {
        if (t == null) {
            throw new PreconditionException(argumentName, "cannot be null");
        }
    }
    

}
