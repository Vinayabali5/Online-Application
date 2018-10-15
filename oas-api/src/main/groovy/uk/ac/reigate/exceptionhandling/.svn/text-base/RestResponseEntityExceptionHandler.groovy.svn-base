package uk.ac.reigate.exceptionhandling

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

import uk.ac.reigate.dto.ErrorDTO
import uk.ac.reigate.exceptions.ApiException

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = [ApiException.class])
    protected ResponseEntity<ErrorDTO> handleExceptions(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.message
        ErrorDTO error = new ErrorDTO(ex.message)
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
