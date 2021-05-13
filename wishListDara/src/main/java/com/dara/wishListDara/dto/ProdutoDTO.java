package com.dara.wishListDara.dto;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento do nome é obrigatório")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "Nome precisa ser uma string")
    private String nome;

    @NotEmpty(message="Preenchimento do descricao é obrigatório")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "Nome precisa ser uma string")
    private String descricao;

    @NotEmpty(message="Preenchimento da imagem é obrigatório")
    @URL(message = "A imagem precisa ser uma URL")
    private String imgUrl;

    @NotEmpty(message="Preenchimento do preco é obrigatório")
    @Positive(message = "O preço precisa ser positivo")
    private Double preco;

    public ProdutoDTO() {

    }

    public ProdutoDTO(Integer id, String nome, String descricao, String imgUrl, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imgUrl = imgUrl;
        this.preco = preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
