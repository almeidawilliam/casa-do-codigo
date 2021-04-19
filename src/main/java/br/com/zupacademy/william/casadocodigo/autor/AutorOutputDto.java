package br.com.zupacademy.william.casadocodigo.autor;

import java.time.LocalDateTime;

public class AutorOutputDto {

    private final Long id;
    private final String nome;
    private final String email;
    private final String descricao;
    private final LocalDateTime instanteCriacao;

    public AutorOutputDto(Long id, String nome, String email, String descricao, LocalDateTime instanteCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.instanteCriacao = instanteCriacao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }

    public static AutorOutputDto toDto(Autor autor) {
        return new AutorOutputDto(
                autor.getId(),
                autor.getNome(),
                autor.getEmail(),
                autor.getDescricao(),
                autor.getInstanteCriacao());
    }
}
