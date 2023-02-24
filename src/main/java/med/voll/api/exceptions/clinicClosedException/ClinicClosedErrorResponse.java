package med.voll.api.exceptions.clinicClosedException;

import lombok.Data;

import java.time.Instant;

@Data
public class ClinicClosedErrorResponse {

    private Instant timestamp;
    private Integer status;
    private String message;
    private String path;

}
