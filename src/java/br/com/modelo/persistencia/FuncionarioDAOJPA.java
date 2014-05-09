
package br.com.modelo.persistencia;

import br.com.modelo.Livro;
import br.com.modelo.persistencia.dao.FuncionarioDAO;
import javax.persistence.EntityManager;



public class FuncionarioDAOJPA  extends
        DAOJPA<Livro, Integer> 
        implements FuncionarioDAO{

    public FuncionarioDAOJPA(EntityManager 
            manager) {
        super(manager);
    }
    
    
    
}
