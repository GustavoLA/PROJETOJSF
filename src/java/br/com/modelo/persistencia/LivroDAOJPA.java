package br.com.modelo.persistencia;

import br.com.modelo.Livro;
import br.com.modelo.persistencia.dao.LivroDAO;
import javax.persistence.EntityManager;

public class LivroDAOJPA extends DAOJPA<Livro, Integer> implements LivroDAO {

    public LivroDAOJPA(EntityManager manager) {
        super(manager);
    }
}
