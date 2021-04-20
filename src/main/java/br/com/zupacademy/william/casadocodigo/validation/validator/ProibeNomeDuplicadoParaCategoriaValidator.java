package br.com.zupacademy.william.casadocodigo.validation.validator;

import br.com.zupacademy.william.casadocodigo.categoria.Categoria;
import br.com.zupacademy.william.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.william.casadocodigo.validation.annotation.ProibeNomeDuplicadoParaCategoria;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ProibeNomeDuplicadoParaCategoriaValidator implements ConstraintValidator<ProibeNomeDuplicadoParaCategoria, String> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(nome);
        return possivelCategoria.isEmpty();
    }
}
