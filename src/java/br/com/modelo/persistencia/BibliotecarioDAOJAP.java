/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo.persistencia;

import br.com.modelo.Bibliotecario;
import br.com.modelo.persistencia.dao.BibliotecarioDAO;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author gustavo_lourenco
 */
public class BibliotecarioDAOJAP extends DAOJPA<Bibliotecario, Integer> implements BibliotecarioDAO {

    public BibliotecarioDAOJAP(EntityManager manager) {
        super(manager);
    }
}
