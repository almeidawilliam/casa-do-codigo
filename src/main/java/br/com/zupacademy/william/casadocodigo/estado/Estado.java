package br.com.zupacademy.william.casadocodigo.estado;

import br.com.zupacademy.william.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotBlank String nome;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    public Estado(@NotBlank String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Deprecated
    public Estado() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return nome.equals(estado.nome) && pais.equals(estado.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, pais);
    }
}
