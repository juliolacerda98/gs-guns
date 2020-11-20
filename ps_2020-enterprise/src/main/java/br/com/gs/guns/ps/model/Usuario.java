package br.com.gs.guns.ps.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "usuario", sequenceName = "sq_usuario", allocationSize = 1)
public class Usuario {

    @Id
    @Column(name = "cd_usuario", nullable = false, unique = true)
    @GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
    private String codigo;

    @Column(name = "nr_cpf_usuario", nullable = false, length = 11)
    private String cpf;

    @Column(name = "nm_usuario", length = 100, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nasc_usuario", nullable = false)
    private Calendar dataNascimento;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Digital> digitais = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
    private Equipamento equipamento;

    public Usuario(String codigo, String cpf, String nome, Calendar dataNascimento) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(String cpf, String nome, Calendar dataNascimento) {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
