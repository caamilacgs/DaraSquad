package com.luizacode.API.Cliente;

import com.luizacode.API.Produto.Produto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

    @ManyToMany                                                         //Define a relação com a tabela PRODUTO
    @JoinTable(name = "TB_WISHLIST",                                    //Define o nome da tabela a ser criada
            joinColumns = @JoinColumn(name = "Clienteid"),              //Define a coluna Clienteid onde a enditade "Cliente" é a dona desssa FK
            inverseJoinColumns = @JoinColumn(name = "Produtoid"))      //Define a coluna Produtoid onde a entidade "Produto" é a dona desssa FK

    private List<Produto> Produto = new ArrayList<>(); //cria lista para produtos


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

    public List<com.luizacode.API.Produto.Produto> getProduto() {
        return Produto;
    }

    public void setProduto(List<com.luizacode.API.Produto.Produto> produto) {
        Produto = produto;
    }
}
