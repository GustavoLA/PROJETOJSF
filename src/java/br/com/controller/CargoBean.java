package br.com.controller;

import br.com.modelo.Autor;
import br.com.modelo.persistencia.CargoDAOJPA;
import br.com.modelo.persistencia.dao.CargoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class CargoBean {

    private Autor cargo;
    private List<Autor> cargos;

    public CargoBean() {
        cargo = new Autor();
    }

    public String insere() {
        EntityManager manager = this.getManager();
        CargoDAO dao = new CargoDAOJPA(manager);
        dao.salvar(cargo);
        this.cargos = null;
        return "/paginas/cargos.xhtml";
    }

    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        CargoDAO dao = new CargoDAOJPA(manager);
        this.cargo = dao.buscarPorId(Autor.class, cargo.getCodigo());
        return "/paginas/cargo.xhtml";
    }

    public void remove() {
        EntityManager manager = this.getManager();
        CargoDAO dao = new CargoDAOJPA(manager);
        dao.remover(Autor.class, cargo.getCodigo());
        this.cargos = null;
    }

    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute("EntityManager");
    }

    public Autor getCargo() {
        return cargo;
    }

    public void setCargo(Autor cargo) {
        this.cargo = cargo;
    }

    public List<Autor> getCargos() {
        if (this.cargos == null) {
            EntityManager manager = this.getManager();
            CargoDAO dao = new CargoDAOJPA(manager);
            this.cargos = dao.buscarTodos(Autor.class);
        }
        return cargos;
    }
}
