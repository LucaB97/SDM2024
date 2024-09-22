package exceptions;

public class OutOfRangeLocationException extends RuntimeException {
    public OutOfRangeLocationException(String message) {
        super(message);
    }
}