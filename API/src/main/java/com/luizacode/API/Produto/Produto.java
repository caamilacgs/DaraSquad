package com.luizacode.API.Produto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity //Informa que se trata de uma entidade;
@Table(name = "TB_PRODUTO") //Informa nome da tabela que ela utiliza;
public class Produto implements Serializable {

    //id do produto gerado automaticamente e autoincrementado;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProduto;

    private String nome;
    private BigDecimal quantidade;
    private BigDecimal valor;

    //GETTERS E SETTERS

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
