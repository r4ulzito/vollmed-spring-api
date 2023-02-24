package med.voll.api.exceptions.beanValidationExceptions;

import java.time.Instant;

import med.voll.api.exceptions.beanValidationExceptions.BeanErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomBeanExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BeanErrorResponse handleException(BindException ex) {

        FieldError fieldError = ex.getFieldError();

        BeanErrorResponse error = new BeanErrorResponse();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        assert fieldError != null;
        error.setMessage(fieldError.getDefaultMessage());
        error.setFieldName(fieldError.getField());

        return error;
    }

}