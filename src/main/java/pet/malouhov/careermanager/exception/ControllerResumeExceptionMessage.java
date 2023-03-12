package pet.malouhov.careermanager.exception;

import java.time.LocalDateTime;

public record ControllerResumeExceptionMessage(
        LocalDateTime timestamp,
        int statusCode,
        String message,
        String path) {

}
