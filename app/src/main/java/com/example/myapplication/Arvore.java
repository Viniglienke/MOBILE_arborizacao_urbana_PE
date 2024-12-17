package com.example.myapplication;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Arvore {
    private int id;

    @SerializedName("nome_registrante")
    private String nomeRegistrante;

    @SerializedName("nome_cientifico")
    private String nomeCientifico;

    @SerializedName("data_plantio")
    private Date dataPlantio;

    @SerializedName("estado_saude")
    private String estadoSaude;

    @SerializedName("localizacao")
    private String localizacao;

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeRegistrante() {
        return nomeRegistrante;
    }

    public void setNomeRegistrante(String nomeRegistrante) {
        this.nomeRegistrante = nomeRegistrante;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public Date getDataPlantio() {
        return dataPlantio;
    }

    public void setDataPlantio(Date dataPlantio) {
        this.dataPlantio = dataPlantio;
    }

    public String getEstadoSaude() {
        return estadoSaude;
    }

    public void setEstadoSaude(String estadoSaude) {
        this.estadoSaude = estadoSaude;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}