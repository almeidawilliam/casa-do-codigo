package br.com.zupacademy.william.casadocodigo.estado;

import br.com.zupacademy.william.casadocodigo.pais.Pais;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public void criar(@RequestBody @Valid EstadoInputDto estadoInputdTO) {
        Pais pais = estadoInputdTO.validarPais(manager);
        Estado novoEstado = estadoInputdTO.toModel(pais);
        pais.vincularEstado(novoEstado);
    }
}
