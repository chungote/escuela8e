/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.its.dsw2.Modelo.Alumno;

/**
 *
 * @author franciscojavier
 */
@Stateless
public class AlumnoDao extends AbstractDao<Alumno> implements AlumnoDaoLocal {
    @PersistenceContext(unitName = "Escuela8e-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoDao() {
        super(Alumno.class);
    }
    
}
