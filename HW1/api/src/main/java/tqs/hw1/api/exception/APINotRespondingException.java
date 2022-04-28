package tqs.hw1.api.exception;

public class APINotRespondingException extends Exception {
    public APINotRespondingException(String errorMessage) {
        super(errorMessage);
    }
}
