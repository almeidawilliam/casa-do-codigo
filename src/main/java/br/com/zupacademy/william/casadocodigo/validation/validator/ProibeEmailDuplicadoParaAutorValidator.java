package br.com.zupacademy.william.casadocodigo.validation.validator;

import br.com.zupacademy.william.casadocodigo.autor.Autor;
import br.com.zupacademy.william.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.william.casadocodigo.validation.annotation.ProibeEmailDuplicadoParaAutor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ProibeEmailDuplicadoParaAutorValidator implements ConstraintValidator<ProibeEmailDuplicadoParaAutor, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Autor> possivelAutor = autorRepository.findByEmail(email);
        return possivelAutor.isEmpty();
    }
}
