package br.com.controller;

import br.com.modelo.Funcao;
import br.com.modelo.Empregado;
import br.com.modelo.persistencia.FuncaoDAOJPA;
import br.com.modelo.persistencia.EmpregadoDAOJPA;
import br.com.modelo.persistencia.dao.FuncaoDAO;
import br.com.modelo.persistencia.dao.EmpregadoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class EmpregadoBean {

    private Empregado empregado;
    private List<Empregado> empregados;
    private int funcaoId;

    public EmpregadoBean() {
        empregado = new Empregado();
    }

    public String insere() {
        EntityManager manager = this.getManager();
        FuncaoDAO funcaoDao = new FuncaoDAOJPA(manager);

        if (funcaoId != 0) {
            Funcao funcao = funcaoDao.buscarPorId(Funcao.class, funcaoId);
            this.empregado.setFuncao(funcao);
        }
        EmpregadoDAO dao = new EmpregadoDAOJPA(manager);
        dao.salvar(empregado);
        this.empregados = null;
        return "/paginas/empregados.xhtml";
    }

    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        EmpregadoDAO dao = new EmpregadoDAOJPA(manager);
        this.empregado = dao.buscarPorId(Empregado.class, empregado.getCodigo());
        return "/paginas/empregado.xhtml";
    }

    public void remove() {
        EntityManager manager = this.getManager();
        EmpregadoDAO dao = new EmpregadoDAOJPA(manager);
        dao.remover(Empregado.class, empregado.getCodigo());
        this.empregados = null;
    }

    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute("EntityManager");
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public int getFuncaoId() {
        return funcaoId;
    }

    public void setFuncaoId(int funcaoId) {
        this.funcaoId = funcaoId;
    }

    public List<Empregado> getEmpregados() {
        if (this.empregados == null) {
            EntityManager manager = this.getManager();
            EmpregadoDAO dao = new EmpregadoDAOJPA(manager);
            this.empregados = dao.buscarTodos(Empregado.class);
        }
        return empregados;
    }
}
