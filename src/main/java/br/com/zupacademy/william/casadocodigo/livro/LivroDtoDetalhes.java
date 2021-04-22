package br.com.zupacademy.william.casadocodigo.livro;

import br.com.zupacademy.william.casadocodigo.autor.AutorDtoDetalhes;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class LivroDtoDetalhes {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numeroPaginas;
    private String isbn;
    private String dataPublicacao;
    private String categoria;
    private AutorDtoDetalhes autor;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public AutorDtoDetalhes getAutor() {
        return autor;
    }

    public LivroDtoDetalhes(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.categoria = livro.getNomeCategoria();
        this.autor = new AutorDtoDetalhes(livro.getAutor());
    }
}
