package br.com.zupacademy.william.casadocodigo.cliente;

import br.com.zupacademy.william.casadocodigo.estado.Estado;
import br.com.zupacademy.william.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank @Email String email;
    private @NotBlank String nome;
    private @NotBlank String sobrenome;
    private @NotBlank String documento;
    private @NotBlank String endereco;
    private @NotBlank String complemento;
    private @NotBlank String cidade;
    private @NotBlank String telefone;
    private @NotBlank String cep;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                   @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                   @NotBlank String cidade, @NotBlank String telefone, @NotBlank String cep, Pais pais, Estado estado) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }
}
