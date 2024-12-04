package org.buildozers.junitadvanced.preconditions;

import lombok.Getter;

/**
 * Exception thrown when a precondition is not respected.
 */
public class PreconditionException extends RuntimeException {

    @Getter
    private final String argumentName;
    
    public PreconditionException(String argumentName, String message) {
        super("Argument '" + argumentName + "' does not respect a precondition : " + message);
        this.argumentName = argumentName;
    }

}
