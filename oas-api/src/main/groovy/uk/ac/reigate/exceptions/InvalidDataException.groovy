package uk.ac.reigate.exceptions;

public class InvalidDataException extends ApiException {
    
    public InvalidDataException() {
        super("Invalid Data Provided");
    }
}
