package com.dara.wishListDara.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento do nome é obrigatório")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "Nome precisa ser uma string")
    private String nome;

    @NotEmpty(message="Preenchimento do email é obrigatório")
    @Email(message="Email inválido")
    private String email;

    @NotEmpty(message="Preenchimento do endereço obrigatório")
    @Length(min=5, max=30, message="O tamanho do endereço deve ser entre 5 e 30 caracteres")
    private String endereco;

    @NotEmpty(message="Preenchimento do cpf é obrigatório")
    private String cpf;

    public ClienteDTO() {

    }

    public ClienteDTO(Integer id, String nome, String email, String endereco, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}

