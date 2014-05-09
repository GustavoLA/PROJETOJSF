/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo.persistencia;

import br.com.modelo.Editora;
import br.com.modelo.persistencia.dao.EditoraDAO;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author gustavo_lourenco
 */
public class EditoraDAOJPA extends DAOJPA<Editora, Integer> implements EditoraDAO {

    public EditoraDAOJPA(EntityManager manager) {
        super(manager);
    }
}
