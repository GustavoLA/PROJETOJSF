package br.com.controller;

import br.com.modelo.Autor;
import br.com.modelo.persistencia.AutorDAOJPA;
import br.com.modelo.persistencia.dao.AutorDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class AutorBean {

    private Autor autor;
    private List<Autor> autores;

    public AutorBean() {
        autor = new Autor();
    }

    public String insere() {
        EntityManager manager = this.getManager();
        AutorDAO dao = new AutorDAOJPA(manager);
        dao.salvar(autor);
        this.autores = null;
        return "/paginas/autores.xhtml";
    }

    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        AutorDAO dao = new AutorDAOJPA(manager);
        this.autor = dao.buscarPorId(Autor.class, autor.getCodigo());
        return "/paginas/autor.xhtml";
    }

    public void remove() {
        EntityManager manager = this.getManager();
        AutorDAO dao = new AutorDAOJPA(manager);
        dao.remover(Autor.class, autor.getCodigo());
        this.autores = null;
    }

    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute("EntityManager");
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Autor> getAutores() {
        if (this.autores == null) {
            EntityManager manager = this.getManager();
            AutorDAO dao = new AutorDAOJPA(manager);
            this.autores = dao.buscarTodos(Autor.class);
        }
        return autores;
    }
}
