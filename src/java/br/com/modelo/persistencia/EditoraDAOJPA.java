
package br.com.modelo.persistencia;

import br.com.modelo.Editora;
import br.com.modelo.persistencia.dao.EditoraDAO;
import javax.persistence.EntityManager;


public class EditoraDAOJPA extends DAOJPA<Editora, Integer> implements EditoraDAO{

    public EditoraDAOJPA(EntityManager manager) {
        super(manager);
    }   
}
