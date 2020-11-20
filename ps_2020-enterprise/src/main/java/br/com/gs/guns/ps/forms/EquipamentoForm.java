package br.com.gs.guns.ps.forms;

import java.util.Calendar;

public class EquipamentoForm {

    private String modelo;

    private Calendar dataCadastro;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
