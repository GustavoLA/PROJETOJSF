package br.com.controller;

import br.com.modelo.Autor;
import br.com.modelo.Livro;
import br.com.modelo.persistencia.CargoDAOJPA;
import br.com.modelo.persistencia.FuncionarioDAOJPA;
import br.com.modelo.persistencia.dao.CargoDAO;
import br.com.modelo.persistencia.dao.FuncionarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class FuncionarioBean {

    private Livro funcionario;
    private List<Livro> funcionarios;
    private int cargoId;

    public FuncionarioBean() {
        funcionario = new Livro();
    }

    public String insere() {
        EntityManager manager = this.getManager();
        CargoDAO cargoDao = new CargoDAOJPA(manager);

        if (cargoId != 0) {
            Autor cargo = cargoDao.buscarPorId(Autor.class, cargoId);
            this.funcionario.setCargo(cargo);
        }
        FuncionarioDAO dao = new FuncionarioDAOJPA(manager);
        dao.salvar(funcionario);
        this.funcionarios = null;
        return "/paginas/funcionarios.xhtml";
    }

    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        FuncionarioDAO dao = new FuncionarioDAOJPA(manager);
        this.funcionario = dao.buscarPorId(Livro.class, funcionario.getCodigo());
        return "/paginas/funcionario.xhtml";
    }

    public void remove() {
        EntityManager manager = this.getManager();
        FuncionarioDAO dao = new FuncionarioDAOJPA(manager);
        dao.remover(Livro.class, funcionario.getCodigo());
        this.funcionarios = null;
    }

    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute("EntityManager");
    }

    public Livro getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Livro funcionario) {
        this.funcionario = funcionario;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public List<Livro> getFuncionarios() {
        if (this.funcionarios == null) {
            EntityManager manager = this.getManager();
            FuncionarioDAO dao = new FuncionarioDAOJPA(manager);
            this.funcionarios = dao.buscarTodos(Livro.class);
        }
        return funcionarios;
    }
}
