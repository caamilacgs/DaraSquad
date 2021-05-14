package com.luizacode.API.Wishlist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;


@Entity //Informa que se trata de uma entidade;
@Table(name = "TB_WISHLIST") //Informa nome da tabela que ela utiliza;
public class Wishlist {

    //id do produto gerado automaticamente e autoincrementado;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idWishlist;

    @NotNull //Define que o Clienteid não pode ser nulo
    @Column(name = "Clienteid")
    private Long idCliente;

    @NotNull //Define que o Produtoid não pode ser nulo
    @Column(name = "Produtoid")
    private Long idProduto;

    public Wishlist(){}
    public Wishlist(long idCliente, long idProduto) {
        this.idProduto = idProduto;
        this.idCliente = idCliente;
    }



    //GETTERS E SETTERS

    public long getIdWishlist() {
        return idWishlist;
    }

    public void setIdWishlist(long idWishlist) {
        this.idWishlist = idWishlist;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
}
