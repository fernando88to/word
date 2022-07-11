package com.fernando.domain;


import java.util.List;

import com.deepoove.poi.data.PictureRenderData;

public class PaymentHackData {
    private String comarca;
    private String cidade;
    private String nomeCartorio;
    private String atoNomeacao;
    private String dataNomeacao;
    private String corregedor;
    private String dataCorreicao;



    private String subtotal;
    private String tax;
    private String transform;
    private String other;
    private String unpay;
    private String total;

    private List<Goods> goods;
    private List<Goods> goods2;
    private List<Labor> labors;
    private List<Labor> labors2;


    private List<EquipeCorrecao> equipe;

    public List<Goods> getGoods2() {
        return goods2;
    }

    public void setGoods2(List<Goods> goods2) {
        this.goods2 = goods2;
    }

    public List<Labor> getLabors2() {
        return labors2;
    }

    public void setLabors2(List<Labor> labors2) {
        this.labors2 = labors2;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<Labor> getLabors() {
        return labors;
    }

    public void setLabors(List<Labor> labors) {
        this.labors = labors;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getSubtotal() {
        return this.subtotal;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTransform(String transform) {
        this.transform = transform;
    }

    public String getTransform() {
        return this.transform;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getOther() {
        return this.other;
    }

    public void setUnpay(String unpay) {
        this.unpay = unpay;
    }

    public String getUnpay() {
        return this.unpay;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNomeCartorio() {
        return nomeCartorio;
    }

    public void setNomeCartorio(String nomeCartorio) {
        this.nomeCartorio = nomeCartorio;
    }

    public String getAtoNomeacao() {
        return atoNomeacao;
    }

    public void setAtoNomeacao(String atoNomeacao) {
        this.atoNomeacao = atoNomeacao;
    }

    public String getDataNomeacao() {
        return dataNomeacao;
    }

    public void setDataNomeacao(String dataNomeacao) {
        this.dataNomeacao = dataNomeacao;
    }

    public String getCorregedor() {
        return corregedor;
    }

    public void setCorregedor(String corregedor) {
        this.corregedor = corregedor;
    }

    public String getDataCorreicao() {
        return dataCorreicao;
    }

    public void setDataCorreicao(String dataCorreicao) {
        this.dataCorreicao = dataCorreicao;
    }

    public List<EquipeCorrecao> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<EquipeCorrecao> equipe) {
        this.equipe = equipe;
    }
}



