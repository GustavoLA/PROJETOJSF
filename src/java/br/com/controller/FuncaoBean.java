package br.com.controller;

import br.com.modelo.Funcao;
import br.com.modelo.persistencia.FuncaoDAOJPA;
import br.com.modelo.persistencia.dao.FuncaoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class FuncaoBean {

    private Funcao funcao;
    private List<Funcao> funcoes;

    public FuncaoBean() {
        funcao = new Funcao();
    }

    public String insere() {
        EntityManager manager = this.getManager();
        FuncaoDAO dao = new FuncaoDAOJPA(manager);
        dao.salvar(funcao);
        this.funcoes = null;
        return "/paginas/funcoes.xhtml";
    }

    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        FuncaoDAO dao = new FuncaoDAOJPA(manager);
        this.funcao = dao.buscarPorId(Funcao.class, funcao.getCodigo());
        return "/paginas/funcao.xhtml";
    }

    public void remove() {
        EntityManager manager = this.getManager();
        FuncaoDAO dao = new FuncaoDAOJPA(manager);
        dao.remover(Funcao.class, funcao.getCodigo());
        this.funcoes = null;
    }

    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute("EntityManager");
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public List<Funcao> getFuncoes() {
        if (this.funcoes == null) {
            EntityManager manager = this.getManager();
            FuncaoDAO dao = new FuncaoDAOJPA(manager);
            this.funcoes = dao.buscarTodos(Funcao.class);
        }
        return funcoes;
    }
}
