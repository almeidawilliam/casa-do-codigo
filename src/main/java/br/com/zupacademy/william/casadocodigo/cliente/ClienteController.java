package br.com.zupacademy.william.casadocodigo.cliente;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public void criar(@RequestBody @Valid ClienteInputDto clienteInputDto) {
        Cliente novoCliente = clienteInputDto.toModel(manager);
        manager.persist(novoCliente);
    }
}
