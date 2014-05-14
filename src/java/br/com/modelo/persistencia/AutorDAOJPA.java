
package br.com.modelo.persistencia;

import br.com.modelo.Autor;
import br.com.modelo.persistencia.dao.AutorDAO;
import javax.persistence.EntityManager;


public class AutorDAOJPA extends DAOJPA<Autor, Integer> implements AutorDAO{

    public AutorDAOJPA(EntityManager manager) {
        super(manager);
    }
    
    
}
