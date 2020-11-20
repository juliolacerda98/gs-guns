package br.com.gs.guns.ps.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "TB_DIGITAL")
public class Digital {

    @Id
    @Column(name = "token_digital", nullable = false, unique = true)
    private String token = UUID.randomUUID().toString();

    @Column(name = "ds_digital", nullable = false, length = 50)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "cd_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY,cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "cd_equipamento", nullable = false)
    private Equipamento equipamento ;

    public Digital(String descricao) {
    }
}
