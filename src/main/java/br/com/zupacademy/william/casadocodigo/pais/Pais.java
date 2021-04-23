package br.com.zupacademy.william.casadocodigo.pais;

import br.com.zupacademy.william.casadocodigo.estado.Estado;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotBlank String nome;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Estado> estados = new HashSet<>();

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Pais() {}

    public void vincularEstado(Estado estado) {
        this.estados.add(estado);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean possuiEstados() {
        return !this.estados.isEmpty();
    }
}
