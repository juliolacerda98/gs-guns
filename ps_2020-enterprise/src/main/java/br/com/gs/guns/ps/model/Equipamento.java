package br.com.gs.guns.ps.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "TB_EQUIPAMENTO")
@SequenceGenerator(name = "equipamento", sequenceName = "sq_equipamento", allocationSize = 1)
public class Equipamento {

    @Id
    @Column(name = "cd_equipamento", nullable = false, unique = true)
    @GeneratedValue(generator = "equipamento", strategy = GenerationType.SEQUENCE)
    private String codigo;

    @Column(name = "nm_modelo_equipamento", nullable = false, length = 30)
    private String modelo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_cadastro_equipamento", nullable = false)
    private Calendar dataCadastro;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "equipamento")
    private List<Digital> digitais = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,optional = true)
    @JoinColumn(name = "cd_usuario")
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "conexao")
    private List<Conexao> conexao = new ArrayList<>();

    public Equipamento(Calendar dataCadastro, String modelo) {
    }
}
