package pet.malouhov.careermanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ControllerResumeNotFoundException.class)
    public ResponseEntity<ControllerResumeExceptionMessage> handleResumeNotFound(
            ControllerResumeNotFoundException exception,
            WebRequest request) {

        ControllerResumeExceptionMessage body = new ControllerResumeExceptionMessage(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
