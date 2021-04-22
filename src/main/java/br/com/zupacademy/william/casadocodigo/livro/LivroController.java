package br.com.zupacademy.william.casadocodigo.livro;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public void criar(@RequestBody @Valid LivroInputDto livroInputDto) {
        Livro novoLivro = livroInputDto.toModel(manager);
        manager.persist(novoLivro);
    }
}
