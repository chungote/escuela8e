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
    @PersistenceContext(unitName = "Escuela8e-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistorialMedicoDao() {
        super(HistorialMedico.class);
    }
    
    @Override
    public boolean findDuplicity(HistorialMedico medicalHistory){
     Query q = em.createNamedQuery("HistorialMedico.findById");
     q.setParameter("id", medicalHistory.getId());
//     q.setParameter("apellidoMaterno", medicalhistory.getApellidoMaterno());
//     q.setParameter("apellidoPaterno", medicalhistory.getApellidoPaterno());
     return !q.getResultList().isEmpty();
 }  
    
}
