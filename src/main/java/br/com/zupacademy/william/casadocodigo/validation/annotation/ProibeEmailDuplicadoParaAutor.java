package br.com.zupacademy.william.casadocodigo.validation.annotation;

import br.com.zupacademy.william.casadocodigo.validation.validator.ProibeEmailDuplicadoParaAutorValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = ProibeEmailDuplicadoParaAutorValidator.class)
public @interface ProibeEmailDuplicadoParaAutor {

    String message() default "Já existe um autor cadastrado com esse e-mail";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";
}
