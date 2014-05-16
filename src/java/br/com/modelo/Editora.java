/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Editora {

    @Id
    @GeneratedValue
    private int codigo;
    private int cnpj;
    private String nomeFantasia;
    private String telefone;
    private String email;
    private String contatoComercial;
    private String fax;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Editora() {
        this.endereco = new Endereco();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContatoComercial() {
        return contatoComercial;
    }

    public void setContatoComercial(String contatoComercial) {
        this.contatoComercial = contatoComercial;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return nomeFantasia;
    }

}
