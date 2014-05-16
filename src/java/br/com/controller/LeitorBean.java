/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.modelo.Leitor;
import br.com.modelo.persistencia.LeitorDAOJPA;
import br.com.modelo.persistencia.dao.LeitorDAO;
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
public class LeitorBean {

    private Leitor leitor;
    private List<Leitor> leitores;

    public LeitorBean() {

        leitor = new Leitor();

    }

    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute("EntityManager");
    }

    public String insere() {

        EntityManager manager = this.getManager();
        LeitorDAO dao = new LeitorDAOJPA(manager);
        dao.salvar(leitor);
        this.leitores = null;
        return "/paginas/leitores.xhtml";
    }

    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        LeitorDAO dao = new LeitorDAOJPA(manager);
        this.leitor = dao.buscarPorId(Leitor.class, leitor.getCodigo());
        return "/paginas/leitor.xhtml";
    }

    public void remove() {
        EntityManager manager = this.getManager();
        LeitorDAO dao = new LeitorDAOJPA(manager);
        dao.remover(Leitor.class, leitor.getCodigo());
        this.leitores = null;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public List<Leitor> getLeitores() {
        if (this.leitores == null) {
            EntityManager manager = this.getManager();
            LeitorDAO dao = new LeitorDAOJPA(manager);
            this.leitores = dao.buscarTodos(Leitor.class);
        }
        return leitores;
    }
}
