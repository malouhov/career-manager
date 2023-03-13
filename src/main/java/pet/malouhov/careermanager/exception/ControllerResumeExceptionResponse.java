package pet.malouhov.careermanager.exception;

import java.time.LocalDateTime;

public record ControllerResumeExceptionResponse(
        LocalDateTime timestamp,
        int statusCode,
        String message,
        String path) {

}
