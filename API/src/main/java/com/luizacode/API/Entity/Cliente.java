package com.luizacode.API.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;


@Entity //Informa que se trata de uma entidade;
@Table(name = "TB_CLIENTE") //Informa nome da tabela que ela utiliza;
public class Cliente {

    //Id do produto gerado automaticamente e autoincrementado;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCliente;

    private String nome;
    private String cpf;
    private String email;

    @JsonIgnore
    @NotNull
    @OneToOne(mappedBy = "cliente",cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Wishlist wishlist;

    //GETTERS E SETTERS

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }
}


