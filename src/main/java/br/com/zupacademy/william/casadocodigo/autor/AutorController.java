package br.com.zupacademy.william.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;
    private final ProibeEmailDuplicadoValidator proibeEmailDuplicadoAutorValidator;

    public AutorController(ProibeEmailDuplicadoValidator proibeEmailDuplicadoAutorValidator,
                           AutorRepository autorRepository) {
        this.proibeEmailDuplicadoAutorValidator = proibeEmailDuplicadoAutorValidator;
        this.autorRepository = autorRepository;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping
    public ResponseEntity<AutorOutputDto> criar(@RequestBody @Valid AutorInputDto autorInputDto) {
        Autor autor = autorInputDto.toModel();
        Autor novoAutor = autorRepository.save(autor);
        AutorOutputDto autorOutputDto = AutorOutputDto.toDto(novoAutor);

        return ResponseEntity.ok(autorOutputDto);
    }
}
