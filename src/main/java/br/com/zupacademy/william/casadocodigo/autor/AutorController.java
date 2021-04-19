package br.com.zupacademy.william.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<AutorOutputDto> criar(@RequestBody @Valid AutorInputDto autorInputDto) {
        Autor autor = autorInputDto.toModel();
        Autor novoAutor = autorRepository.save(autor);
        AutorOutputDto autorOutputDto = AutorOutputDto.toDto(novoAutor);

        return ResponseEntity.ok(autorOutputDto);
    }
}
