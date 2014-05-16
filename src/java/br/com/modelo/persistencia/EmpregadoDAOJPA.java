
package br.com.modelo.persistencia;

import br.com.modelo.Empregado;
import br.com.modelo.persistencia.dao.EmpregadoDAO;
import javax.persistence.EntityManager;



public class EmpregadoDAOJPA  extends
        DAOJPA<Empregado, Integer> 
        implements EmpregadoDAO{

    public EmpregadoDAOJPA(EntityManager 
            manager) {
        super(manager);
    }
    
    
    
}
