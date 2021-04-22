package br.com.zupacademy.william.casadocodigo.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String nome;

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Categoria() { }

    public String getNome() {
        return nome;
    }
}
