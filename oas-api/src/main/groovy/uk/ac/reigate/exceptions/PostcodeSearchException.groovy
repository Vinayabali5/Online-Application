package uk.ac.reigate.exceptions


class PostcodeSearchException extends ApiException {
    
    PostcodeSearchException() {
        super("Failed to search for postcode.")
    }
    
    PostcodeSearchException(String message) {
        super("Failed to search for postcode. Reason: " + message)
    }
}
