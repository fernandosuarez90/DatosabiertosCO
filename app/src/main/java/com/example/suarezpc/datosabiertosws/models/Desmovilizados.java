package com.example.suarezpc.datosabiertosws.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by suarezpc on 22/05/17.
 */

public class Desmovilizados {

    @SerializedName("anhodesmovilizacion")
    @Expose
    private String anhodesmovilizacion;
    @SerializedName("departamento")
    @Expose
    private String departamento;
    @SerializedName("numerodesmovilizados")
    @Expose
    private String numerodesmovilizados;

    public String getAnhodesmovilizacion() {
        return anhodesmovilizacion;
    }

    public void setAnhodesmovilizacion(String anhodesmovilizacion) {
        this.anhodesmovilizacion = anhodesmovilizacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNumerodesmovilizados() {
        return numerodesmovilizados;
    }

    public void setNumerodesmovilizados(String numerodesmovilizados) {
        this.numerodesmovilizados = numerodesmovilizados;
    }

}
