package br.com.zupacademy.william.casadocodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    public ResponseEntity<List<LivroDtoApenasNome>> listar() {
        TypedQuery<Livro> query = manager.createQuery("select l from Livro l", Livro.class);
        List<Livro> livros = query.getResultList();
        List<LivroDtoApenasNome> livrosDtoApenasNome = livros.stream().map(livro -> new LivroDtoApenasNome(livro.getId(), livro.getTitulo())).collect(Collectors.toList());

        return ResponseEntity.ok(livrosDtoApenasNome);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Livro livro = manager.find(Livro.class, id);

        if (Objects.isNull(livro)) {
            return ResponseEntity.notFound().build();
        }

        LivroDtoDetalhes livroDtoDetalhes = new LivroDtoDetalhes(livro);
        return ResponseEntity.ok(livroDtoDetalhes);
    }

    @PostMapping
    @Transactional
    public void criar(@RequestBody @Valid LivroInputDto livroInputDto) {
        Livro novoLivro = livroInputDto.toModel(manager);
        manager.persist(novoLivro);
    }
}
