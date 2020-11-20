package br.com.gs.guns.ps.model;;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "TB_CONEXAO")
@SequenceGenerator(name = "conexao", sequenceName = "sq_conexao", allocationSize = 1)
public class Conexao {

    @Id
    @Column(name = "cd_conexao", nullable = false,unique = true)
    @GeneratedValue(generator = "conexao",strategy = GenerationType.SEQUENCE)
    private String codigo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_conexao", nullable = false)
    private Calendar dataConexao;

    @Column(name = "st_conexao", nullable = false )
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "cd_equipamento", nullable = false)
    private Equipamento equipamento;

    public Conexao(Calendar dataConmexao, String status) {
    }
}
