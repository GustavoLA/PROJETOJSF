/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gustavo_lourenco
 */
@Entity
public class Bibliotecario {

    @Id
    @GeneratedValue
    private int codigo;
    private String nome;
    private int cpf;
    private int telefone;
    private double salario;
    @Temporal(TemporalType.DATE)
    private Date dataAdmisao;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private int ctps;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @Lob
    private String obs;

    public Bibliotecario() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getDataAdmisao() {
        return dataAdmisao;
    }

    public void setDataAdmisao(Date dataAdmisao) {
        this.dataAdmisao = dataAdmisao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCtps() {
        return ctps;
    }

    public void setCtps(int ctps) {
        this.ctps = ctps;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
