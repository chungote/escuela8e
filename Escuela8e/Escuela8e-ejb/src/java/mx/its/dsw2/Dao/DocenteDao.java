/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.its.dsw2.Modelo.Docente;

/**
 *
 * @author franciscojavier
 */
@Stateless
public class DocenteDao extends AbstractDao<Docente> implements DocenteDaoLocal {
    @PersistenceContext(unitName = "Escuela8e-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteDao() {
        super(Docente.class);
    }
    
}
