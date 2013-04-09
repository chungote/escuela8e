/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.its.dsw2.Modelo.HistorialMedico;

/**
 *
 * @author franciscojavier
 */
@Stateless
public class HistorialMedicoDao extends AbstractDao<HistorialMedico> implements HistorialMedicoDaoLocal {
    @PersistenceContext(unitName = "School8e-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistorialMedicoDao() {
        super(HistorialMedico.class);
    }
     public boolean findDuplicity(HistorialMedico medicalhistory){
        Query q = em.createNamedQuery("HistorialMedico.findDuplicity");
        q.setParameter("nombre", medicalhistory.getNombre());
        q.setParameter("apellidoMaterno", medicalhistory.getApellidoMaterno());
        q.setParameter("apellidoPaterno", medicalhistory.getApellidoPaterno());
        return !q.getResultList().isEmpty();
    }
    
}
