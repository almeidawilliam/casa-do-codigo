package br.com.zupacademy.william.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorOutputDto> criar(@RequestBody @Valid AutorInputDto autorInputDto) {
        Autor novoAutor = autorInputDto.toModel();
        Autor autorSalvo = autorRepository.save(novoAutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AutorOutputDto(autorSalvo));
    }
}
