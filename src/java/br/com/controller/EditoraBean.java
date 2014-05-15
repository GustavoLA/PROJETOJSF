/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.modelo.Editora;
import br.com.modelo.persistencia.EditoraDAOJPA;
import br.com.modelo.persistencia.dao.EditoraDAO;
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
public class EditoraBean {

    private Editora editora;
    private List<Editora> editoras;

    public EditoraBean() {
        editora = new Editora();
    }

    public String insere() {
        EntityManager manager = this.getManager();
        EditoraDAO dao = new EditoraDAOJPA(manager);
        dao.salvar(editora);
        this.editoras = null;
        return "/paginas/editoras.xhtml";
    }

    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        EditoraDAO dao = new EditoraDAOJPA(manager);
        this.editora = dao.buscarPorId(Editora.class, editora.getCodigo());
        return "/paginas/editora.xhtml";
    }

    public void remove() {
        EntityManager manager = this.getManager();
        EditoraDAO dao = new EditoraDAOJPA(manager);
        dao.remover(Editora.class, editora.getCodigo());
        this.editoras = null;
    }

    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute("EntityManager");
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora eiditora) {
        this.editora = editora;
    }

    public List<Editora> getEditoras() {
        if (this.editoras == null) {
            EntityManager manager = this.getManager();
            EditoraDAO dao = new EditoraDAOJPA(manager);
            this.editoras = dao.buscarTodos(Editora.class);
        }
        return editoras;
    }
}
