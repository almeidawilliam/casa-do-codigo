package br.com.zupacademy.william.casadocodigo.validation.annotation;

import br.com.zupacademy.william.casadocodigo.validation.validator.ProibeNomeDuplicadoParaCategoriaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = ProibeNomeDuplicadoParaCategoriaValidator.class)
public @interface ProibeNomeDuplicadoParaCategoria {

    String message() default "Já existe uma categoria com esse nome";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";
}
