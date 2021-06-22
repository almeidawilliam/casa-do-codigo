package br.com.zupacademy.william.casadocodigo.autor;

import br.com.zupacademy.william.casadocodigo.validation.annotation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorInputDto {

    @NotBlank
    @JsonProperty
    private final String nome;

    @Email
    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    @JsonProperty
    private final String email;

    @Size(max = 400)
    @NotBlank
    @JsonProperty
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

    public String getEmail() {
        return email;
    }
}
