package exceptions;

public class FailedAttemptExceededException extends Exception{
    public FailedAttemptExceededException(String message) {
        super(message);
    }
}