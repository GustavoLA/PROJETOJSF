
package br.com.modelo.persistencia;

import br.com.modelo.Funcionario;
import br.com.modelo.persistencia.dao.FuncionarioDAO;
import javax.persistence.EntityManager;



public class FuncionarioDAOJPA  extends
        DAOJPA<Funcionario, Integer> 
        implements FuncionarioDAO{

    public FuncionarioDAOJPA(EntityManager 
            manager) {
        super(manager);
    }
    
    
    
}
