package com.example.bus;

import android.widget.EditText;

public class Bus {

    private String marca;
    private String modelo;
    private String origemDestino;
    private String tipo;
    private String assTotais;
    private String assOcupados;

    public Bus(EditText marca, EditText modelo, EditText origemDestino, EditText tipo, EditText totais, EditText ocupados) {

    }

    public Bus(String marca, String modelo, String origemDestino, String tipo, String assTotais, String assOcupados) {
        this.marca = marca;
        this.modelo = modelo;
        this.origemDestino = origemDestino;
        this.tipo = tipo;
        this.assTotais = assTotais;
        this.assOcupados = assOcupados;
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
        this.modelo = modelo;
    }

    public String getOrigemDestino() {
        return origemDestino;
    }

    public void setOrigemDestino(String origem_destino) {
        this.origemDestino = origemDestino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAssTotais() {
        return assTotais;
    }

    public void setAssTotais(String assTotais) {
        this.assTotais = assTotais;
    }

    public String getAssOcupados() {
        return assOcupados;
    }

    public void setAssOcupados(String assOcupados) {
        this.assOcupados = assOcupados;
    }
}
