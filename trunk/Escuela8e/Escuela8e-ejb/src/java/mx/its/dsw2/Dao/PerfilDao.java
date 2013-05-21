/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.its.dsw2.Modelo.Perfil;

/**
 *
 * @author franciscojavier
 */
@Stateless
public class PerfilDao extends AbstractDao<Perfil> implements PerfilDaoLocal {
    @PersistenceContext(unitName = "Escuela8e-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilDao() {
        super(Perfil.class);
    }
    
     public boolean findDuplicity(Perfil profile){
     Query q = em.createNamedQuery("Perfil.findDuplicity");
     q.setParameter("nombre", profile.getNombre());
//     q.setParameter("apellidoMaterno", profile.getId());
     
     return !q.getResultList().isEmpty();
 }  
}
