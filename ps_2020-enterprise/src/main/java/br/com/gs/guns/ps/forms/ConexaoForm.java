package br.com.gs.guns.ps.forms;

import java.util.Calendar;

public class ConexaoForm {

    private Calendar dataConmexao;

    private String status;

    public Calendar getDataConmexao() {
        return dataConmexao;
    }

    public void setDataConmexao(Calendar dataConmexao) {
        this.dataConmexao = dataConmexao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
