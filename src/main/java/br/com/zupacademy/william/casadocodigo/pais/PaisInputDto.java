package br.com.zupacademy.william.casadocodigo.pais;

import br.com.zupacademy.william.casadocodigo.validation.annotation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisInputDto {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public Pais toModel() {
        return new Pais(this.nome);
    }

    public PaisInputDto() {}

    public PaisInputDto(@NotBlank String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
