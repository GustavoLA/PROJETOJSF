/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.modelo.Bibliotecario;
import br.com.modelo.persistencia.BibliotecarioDAOJAP;
import br.com.modelo.persistencia.dao.BibliotecarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gustavo_lourenco
 */
@ManagedBean
public class BibliotecarioBean {

    private Bibliotecario bibliotecario;
    private List<Bibliotecario> bibliotecarios;

    public BibliotecarioBean() {

        bibliotecario = new Bibliotecario();

    }

    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute("EntityManager");
    }

    public String insere() {

        EntityManager manager = this.getManager();
        BibliotecarioDAO dao = new BibliotecarioDAOJAP(manager);
        dao.salvar(bibliotecario);
        this.bibliotecarios = null;
        return "/paginas/bibliotecarios.xhtml";
    }

    public void remove() {
        EntityManager manager = this.getManager();
        BibliotecarioDAO dao = new BibliotecarioDAOJAP(manager);
        dao.remover(Bibliotecario.class, bibliotecario.getCodigo());
        this.bibliotecarios = null;
    }

    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        BibliotecarioDAO dao = new BibliotecarioDAOJAP(manager);
        this.bibliotecario = dao.buscarPorId(Bibliotecario.class, bibliotecario.getCodigo());
        return "/paginas/bibliotecario.xhtml";
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public List<Bibliotecario> getBibliotecarios() {
        if (this.bibliotecarios == null) {
            EntityManager manager = this.getManager();
            BibliotecarioDAO dao = new BibliotecarioDAOJAP(manager);
            this.bibliotecarios = dao.buscarTodos(Bibliotecario.class);
        }
        return bibliotecarios;
    }
}
