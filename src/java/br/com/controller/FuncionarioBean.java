package br.com.controller;

import br.com.modelo.Cargo;
import br.com.modelo.Funcionario;
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

    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    private int cargoId;

    public FuncionarioBean() {
        funcionario = new Funcionario();
    }

    public String insere() {
        EntityManager manager = this.getManager();
        CargoDAO cargoDao = new CargoDAOJPA(manager);

        if (cargoId != 0) {
            Cargo cargo = cargoDao.buscarPorId(Cargo.class, cargoId);
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
        this.funcionario = dao.buscarPorId(Funcionario.class, funcionario.getCodigo());
        return "/paginas/funcionario.xhtml";
    }

    public void remove() {
        EntityManager manager = this.getManager();
        FuncionarioDAO dao = new FuncionarioDAOJPA(manager);
        dao.remover(Funcionario.class, funcionario.getCodigo());
        this.funcionarios = null;
    }

    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute("EntityManager");
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public List<Funcionario> getFuncionarios() {
        if (this.funcionarios == null) {
            EntityManager manager = this.getManager();
            FuncionarioDAO dao = new FuncionarioDAOJPA(manager);
            this.funcionarios = dao.buscarTodos(Funcionario.class);
        }
        return funcionarios;
    }
}
