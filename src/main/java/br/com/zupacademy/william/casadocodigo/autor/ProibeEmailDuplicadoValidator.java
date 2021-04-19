package br.com.zupacademy.william.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorInputDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        AutorInputDto autorInputDto = (AutorInputDto) target;
        autorRepository.findByEmail(autorInputDto.getEmail())
                .ifPresent(autor ->
                        errors.rejectValue(
                                "email",
                                null,
                                "Já existe um(a) autor(a) com o e-mail " + autor.getEmail())
                );
    }
}
