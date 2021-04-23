package br.com.zupacademy.william.casadocodigo.estado;

import br.com.zupacademy.william.casadocodigo.pais.Pais;
import br.com.zupacademy.william.casadocodigo.validation.annotation.ExistsId;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class EstadoInputDto {

    @NotBlank
    private String nome;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    @JsonProperty("id_pais")
    private Long idPais;

    public EstadoInputDto(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado toModel(Pais pais) {
        return new Estado(this.nome, pais);
    }

    public Pais validarPais(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        Assert.state(Objects.nonNull(pais), "Você está querendo cadastrar um estado para um país que não existe");

        return pais;
    }
}
