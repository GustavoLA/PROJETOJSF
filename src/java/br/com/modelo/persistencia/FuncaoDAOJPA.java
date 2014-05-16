
package br.com.modelo.persistencia;

import br.com.modelo.Funcao;
import br.com.modelo.persistencia.dao.FuncaoDAO;
import javax.persistence.EntityManager;


public class FuncaoDAOJPA extends DAOJPA<Funcao, Integer> 
implements FuncaoDAO{

    public FuncaoDAOJPA(EntityManager manager) {
        super(manager);
    }
    
    
}
