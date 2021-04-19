package br.com.zupacademy.william.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorInputDto {

    @NotBlank
    private final String nome;

    @Email
    @NotBlank
    private final String email;

    @Size(max = 400)
    @NotBlank
    private final String descricao;

    public AutorInputDto(@NotBlank String nome,
                         @NotBlank @Email String email,
                         @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
