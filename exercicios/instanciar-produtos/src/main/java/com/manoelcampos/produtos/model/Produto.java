package com.mycompany.exerciciobuilder.model;

import java.time.LocalDate;


public final class Produto {
    long id;
    String codigoEan;
    String descricao;
    double preco;
    String marca;
    String modelo;
    String categoria;
    int estoque;
    LocalDate dataCadastro;
    LocalDate dataAtualizacao;
    String urlFoto;
    
    Produto(long id, String codigoEan, String descricao, double preco, String marca, String modelo, String categoria, int estoque, LocalDate dataCadastro, LocalDate dataAtualizacao, String urlFoto) {
        this.setId(id);
        this.setCodigoEan(codigoEan);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setCategoria(categoria);
        this.dataCadastro = LocalDate.now();
        this.setDataAtualizacao(LocalDate.now());
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setEstoque(estoque);
        this.setUrlFoto(urlFoto);
    }
    


    public long getId() {
        return id;
    }

    public void setId(long id) {
        if(id < 0)
            throw new IllegalArgumentException(
                    "O id é obrigatorio");
        this.id = id;
    }
    /*
    public Produto setId(int id) {
        this.id = id;
        return this;
    }

     */

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <=0)
            throw new IllegalArgumentException(
                    "O preço deve ser maior que zero");

        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if ((modelo !=null && !modelo.isBlank()) && (getMarca() == null || getMarca().isBlank()))
            throw  new IllegalArgumentException("É preciso atribuir uma marca para poder informar um modelo");
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque <0)
            throw new IllegalArgumentException(
                    "O estoque não pode ser negativo");
        this.estoque = estoque;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        if (dataAtualizacao.isBefore(getDataCadastro()))
            throw new IllegalArgumentException(
                    "O data de Atualização não pode ser menor que a data de cadastro");
        this.dataAtualizacao = dataAtualizacao;
    }

  
    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getCodigoEan() {
        return codigoEan;
    }

    public void setCodigoEan(String codigoEan) {
        this.codigoEan = codigoEan;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", codigoEan=" + codigoEan + ", descricao=" + descricao + ", preco=" + preco + ", marca=" + marca + ", modelo=" + modelo + ", categoria=" + categoria + ", estoque=" + estoque + ", dataCadastro=" + dataCadastro + ", dataAtualizacao=" + dataAtualizacao + ", urlFoto=" + urlFoto + '}';
    }

}

