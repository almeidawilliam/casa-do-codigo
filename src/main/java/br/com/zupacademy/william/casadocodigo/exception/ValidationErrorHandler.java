package br.com.zupacademy.william.casadocodigo.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationErrorHandler {

    private final MessageSource messageSource;

    public ValidationErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorsOutput handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        return buildValidationErrors(fieldErrors);
    }

    public ValidationErrorsOutput buildValidationErrors(List<FieldError> fieldErrors) {

        List<ErrorBody> erros = fieldErrors.stream()
                .map(error -> new ErrorBody(error.getField(), getErrorMessage(error)))
                .collect(Collectors.toList());

        return new ValidationErrorsOutput(erros);
    }

    public String getErrorMessage(ObjectError error) {
        boolean hasMessage = !messageSource.getMessage(error, LocaleContextHolder.getLocale()).isEmpty();

        if (hasMessage) {
            return messageSource.getMessage(error, LocaleContextHolder.getLocale());
        }

        return error.getDefaultMessage();
    }
}
