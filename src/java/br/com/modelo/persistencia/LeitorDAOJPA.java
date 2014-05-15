/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo.persistencia;

import br.com.modelo.Leitor;
import br.com.modelo.persistencia.dao.LeitorDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author gustavo_lourenco
 */
public class LeitorDAOJPA extends DAOJPA<Leitor, Integer> implements LeitorDAO {

    public LeitorDAOJPA(EntityManager manager) {
        super(manager);
    }
}
