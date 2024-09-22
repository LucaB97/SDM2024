package exceptions;

public class NoMovesAvailableException extends RuntimeException {
    public NoMovesAvailableException(String message) {
        super(message);
    }
}
