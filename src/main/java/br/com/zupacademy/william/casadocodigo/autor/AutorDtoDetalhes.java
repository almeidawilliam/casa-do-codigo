package br.com.zupacademy.william.casadocodigo.autor;

public class AutorDtoDetalhes {

    private String nome;
    private String descricao;

    public AutorDtoDetalhes(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
