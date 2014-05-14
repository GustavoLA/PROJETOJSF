package br.com.controller;

import br.com.modelo.Autor;
import br.com.modelo.Editora;
import br.com.modelo.Livro;
import br.com.modelo.persistencia.AutorDAOJPA;
import br.com.modelo.persistencia.EditoraDAOJPA;
import br.com.modelo.persistencia.LivroDAOJPA;
import br.com.modelo.persistencia.dao.AutorDAO;
import br.com.modelo.persistencia.dao.EditoraDAO;
import br.com.modelo.persistencia.dao.LivroDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
public class LivroBean {

    private Livro livro;
    private List<Livro> livros;
    private int autorId;
    private int editoraId;

    public LivroBean() {
        livro = new Livro();
    }

    public String insere() {
        EntityManager manager = this.getManager();
        AutorDAO autorDao = new AutorDAOJPA(manager);
        EditoraDAO editoraDao = new EditoraDAOJPA(manager);
        
        if (editoraId != 0) {
            Editora editora = editoraDao.buscarPorId(Editora.class, editoraId);
            this.livro.setEditora(editora);
        }
        
        if (autorId != 0) {
            Autor autor = autorDao.buscarPorId(Autor.class, autorId);
            this.livro.setAutor(autor);
        }



        LivroDAO dao = new LivroDAOJPA(manager);
        dao.salvar(livro);
        this.livros = null;
        return "/paginas/livros.xhtml";
    }

    public String preparaAlteracao() {
        EntityManager manager = this.getManager();
        LivroDAO dao = new LivroDAOJPA(manager);
        this.livro = dao.buscarPorId(Livro.class, livro.getCodigo());
        return "/paginas/livro.xhtml";
    }

    public void remove() {
        EntityManager manager = this.getManager();
        LivroDAO dao = new LivroDAOJPA(manager);
        dao.remover(Livro.class, livro.getCodigo());
        this.livros = null;
    }

    private EntityManager getManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        return (EntityManager) request.getAttribute("EntityManager");
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public int getEditoraId() {
        return editoraId;
    }

    public void setEditoraId(int editoraId) {
        this.editoraId = editoraId;
    }

    public List<Livro> getLivros() {
        if (this.livros == null) {
            EntityManager manager = this.getManager();
            LivroDAO dao = new LivroDAOJPA(manager);
            this.livros = dao.buscarTodos(Livro.class);
        }
        return livros;
    }
}
