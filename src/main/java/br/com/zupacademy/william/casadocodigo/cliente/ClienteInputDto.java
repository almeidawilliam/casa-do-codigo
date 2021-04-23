package br.com.zupacademy.william.casadocodigo.cliente;

import br.com.zupacademy.william.casadocodigo.estado.Estado;
import br.com.zupacademy.william.casadocodigo.exception.IncompativelException;
import br.com.zupacademy.william.casadocodigo.pais.Pais;
import br.com.zupacademy.william.casadocodigo.validation.annotation.CpfCnpj;
import br.com.zupacademy.william.casadocodigo.validation.annotation.ExistsId;
import br.com.zupacademy.william.casadocodigo.validation.annotation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ClienteInputDto {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CpfCnpj
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @JsonProperty("id_estado")
    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;

    @NotNull
    @JsonProperty("id_pais")
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public ClienteInputDto(String email, String nome, String sobrenome, String documento, String endereco,
                           String complemento, String cidade, String telefone, String cep, Long idEstado, Long idPais) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.idEstado = idEstado;
        this.idPais = idPais;
    }

    public Cliente toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        Assert.state(Objects.nonNull(pais), "Você está tentando cadastrar um cliente em um país que não existe no banco de dados");

        if (Objects.isNull(idEstado) && pais.possuiEstados()) {
            throw new IncompativelException("É necessário o estado do país em que o cliente está se cadastrando");
        }

        Estado estado = manager.find(Estado.class, idEstado);
        Assert.state(Objects.nonNull(estado), "Você está tentando cadastrar um cliente em um estado que não existe no banco de dados");

        if (!estado.pertenceAoPais(pais)) {
            throw new IncompativelException(String.format("O estado %d (%s) não pertence ao país %d (%s)", estado.getId(), estado.getNome(), pais.getId(), pais.getNome()));
        }

        return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento,
                this.cidade, this.telefone, this.cep, pais, estado);
    }
}
