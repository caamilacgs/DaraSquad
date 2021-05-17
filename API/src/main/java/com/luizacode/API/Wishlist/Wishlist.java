package com.luizacode.API.Wishlist;

import com.luizacode.API.Cliente.Cliente;
import com.luizacode.API.Produto.Produto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //Informa que se trata de uma entidade;
@Table(name = "TB_WISHLIST") //Informa nome da tabela que ela utiliza;
public class Wishlist {

    //id do produto gerado automaticamente e autoincrementado;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idWishlist;

    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "idCliente")
    private Cliente cliente;

    @ManyToMany(mappedBy = "listaWishlist")
    private List<Produto> listaProdutos = new ArrayList<>();


//GETTERS E SETTERS


    public Wishlist() {

    }

    public Wishlist(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getIdWishlist() {
        return idWishlist;
    }

    public void setIdWishlist(long idWishlist) {
        this.idWishlist = idWishlist;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
