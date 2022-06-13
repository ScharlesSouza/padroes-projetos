package com.mycompany.exerciciobuilder.model;

import java.time.LocalDate;


public class ProdutoBuilder {

    private long id=-1;
    private String codigoEan = "";
    private String descricao = "";
    private double preco;
    private String marca;
    private String modelo = "";
    private String categoria = "";
    private int estoque=0;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
    private String urlFoto = "";
    
    public ProdutoBuilder(){}

    /*
    public ProdutoBuilder(long id, String descricao, String marca, double preco,String categoria) {
        this.id = id;
        this.marca = marca;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }
*/

    public ProdutoBuilder id(long id) {
        this.id = id;
        return this;
    }

    public ProdutoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ProdutoBuilder preco(double preco) {
        this.preco = preco;
        return this;
    }

    public ProdutoBuilder marca(String marca) {
        this.marca = marca;
        return this;
    }

    public ProdutoBuilder modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public ProdutoBuilder categoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public ProdutoBuilder estoque(int estoque) {
        this.estoque = estoque;
        return this;
    }

    public ProdutoBuilder dataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public ProdutoBuilder dataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
        return this;
    }
    
    public ProdutoBuilder codigoEan(String codigoEan) {
        this.codigoEan = codigoEan;
        return this;
    }

    public ProdutoBuilder urlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
        return this;
    }

    public Produto build() {
        return new Produto(id, codigoEan, descricao, preco, marca, modelo, categoria, estoque, dataCadastro, dataAtualizacao, urlFoto);
    }
    
}
