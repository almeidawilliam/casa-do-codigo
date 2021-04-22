package br.com.zupacademy.william.casadocodigo.livro;

import br.com.zupacademy.william.casadocodigo.autor.Autor;
import br.com.zupacademy.william.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotBlank String titulo;
    private @NotBlank @Size(max = 500) String resumo;
    private String sumario;
    private @NotNull @Min(20) BigDecimal preco;
    private @NotNull @Min(100) int numeroPaginas;
    private @NotNull @NotEmpty String isbn;
    private @Future LocalDate dataPublicacao;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private @NotNull Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private @NotNull Autor autor;

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
                 @NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroPaginas, @NotBlank String isbn,
                 @Future @NotNull LocalDate dataPublicacao, @NotNull @Valid Categoria categoria, @NotNull @Valid Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Deprecated
    public Livro() {
    }

    public LivroDtoApenasNome toDto() {
        return new LivroDtoApenasNome(this.id, this.titulo);
    }
}
