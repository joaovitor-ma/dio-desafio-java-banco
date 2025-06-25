package Exceptions;

public class FaturaExcedeLimiteException extends RuntimeException {
    public FaturaExcedeLimiteException(String message) {
        super(message);
    }
}
