/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public boolean findDuplicity(Alumno student){
        Query q = em.createNamedQuery("Alumno.findDuplicity");
        q.setParameter("nombre", student.getNombre());
        q.setParameter("apellidoMaterno", student.getApellidoMaterno());
        q.setParameter("apellidoPaterno", student.getApellidoPaterno());
        return !q.getResultList().isEmpty();
    }
    
}
