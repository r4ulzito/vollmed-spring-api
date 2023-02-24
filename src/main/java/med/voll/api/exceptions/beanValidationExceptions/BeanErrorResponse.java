package med.voll.api.exceptions.beanValidationExceptions;

import lombok.Data;

import java.time.Instant;

@Data
public class BeanErrorResponse {

    private Instant timestamp;
    private Integer status;
    private String message;
    private String fieldName;

}
