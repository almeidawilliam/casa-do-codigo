package br.com.zupacademy.william.casadocodigo.categoria;

import br.com.zupacademy.william.casadocodigo.validation.annotation.ProibeNomeDuplicadoParaCategoria;

import javax.validation.constraints.NotBlank;

public class CategoriaInputDto {

    @NotBlank
    @ProibeNomeDuplicadoParaCategoria
    private String nome;

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
