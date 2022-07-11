package com.fernando.domain;

import com.deepoove.poi.data.PictureRenderData;

public class Goods {
    private int count;
    private String nome;
    private String funcao;
    private int discount;
    private int tax;
    private int price;
    private int totalPrice;

    private PictureRenderData picture;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PictureRenderData getPicture() {
        return picture;
    }

    public void setPicture(PictureRenderData picture) {
        this.picture = picture;
    }

}