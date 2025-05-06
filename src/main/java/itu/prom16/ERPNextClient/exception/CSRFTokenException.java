package itu.prom16.ERPNextClient.exception;

public class CSRFTokenException extends SecurityException {
    public CSRFTokenException(String message) {
        super(message);
    }
}
