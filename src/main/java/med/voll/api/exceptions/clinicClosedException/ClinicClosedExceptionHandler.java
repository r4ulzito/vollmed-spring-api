package med.voll.api.exceptions.clinicClosedException;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ClinicClosedExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ClinicClosedErrorResponse> clinicClosedException(ClinicClosedException ex, HttpServletRequest request) {

        ClinicClosedErrorResponse error = new ClinicClosedErrorResponse();

        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Data ou Horário fora do funcionamento da clinica!");
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
