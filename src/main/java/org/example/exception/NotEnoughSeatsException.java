package org.example.exception;

public class NotEnoughSeatsException extends IllegalArgumentException {
    public NotEnoughSeatsException(String message) {
        super(message);
    }

}
