package br.com.zupacademy.william.casadocodigo.livro;

import br.com.zupacademy.william.casadocodigo.autor.Autor;
import br.com.zupacademy.william.casadocodigo.categoria.Categoria;
import br.com.zupacademy.william.casadocodigo.validation.annotation.ExistsId;
import br.com.zupacademy.william.casadocodigo.validation.annotation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroInputDto {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    @JsonProperty("numero_paginas")
    private int numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    @JsonProperty("data_publicacao")
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    @JsonProperty("id_categoria")
    private Long idCategoria;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    @JsonProperty("id_autor")
    private Long idAutor;

    public LivroInputDto(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
                         @NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroPaginas,
                         @NotBlank String isbn,
                         @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }


    /*
    * A biblioteca de serializacao do Jackson não consegue serializar a data de publicacao atraves do construtor
    */
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro toModel(EntityManager manager) {
        @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
        @NotNull Autor autor = manager.find(Autor.class, idAutor);

        Assert.state(categoria != null, "Você está querendo cadastrar um livro para uma categoria que não existe no banco de dados");
        Assert.state(autor != null, "Você está querendo cadastrar um livro para um autor que não existe no banco de dados");

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn,
                this.dataPublicacao, categoria, autor);
    }
}
