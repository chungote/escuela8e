/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.its.dsw2.Modelo.Docente;

/**
 *
 * @author franciscojavier
 */
@Stateless
public class DocenteDao extends AbstractDao<Docente> implements DocenteDaoLocal {
    @PersistenceContext(unitName = "School8e-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteDao() {
        super(Docente.class);
    }
    public boolean findDuplicity(Docente teaching){
        Query q = em.createNamedQuery("Docente.findDuplicity");
        q.setParameter("nombre", teaching.getNombre());
        q.setParameter("apellidoMaterno", teaching.getApellidoMaterno());
        q.setParameter("apellidoPaterno", teaching.getApellidoPaterno());
        return !q.getResultList().isEmpty();
    }
    
    
}
