package br.com.zupacademy.william.casadocodigo.pais;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public void criar(@RequestBody @Valid PaisInputDto paisInputDto) {
        Pais novoPais = paisInputDto.toModel();
        manager.persist(novoPais);
    }
}
