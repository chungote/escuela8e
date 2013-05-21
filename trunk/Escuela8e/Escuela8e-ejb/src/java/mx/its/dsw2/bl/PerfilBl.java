/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.its.dsw2.Dao.PerfilDaoLocal;
import mx.its.dsw2.Modelo.Perfil;
import mx.its.dsw2.escuela.enumeracion.estadoHistorialMedico;

/**
 *
 * @author franciscojavier
 */
@Stateless
public class PerfilBl implements PerfilBlLocal {
    @EJB
    private PerfilDaoLocal perfilDao;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
public estadoHistorialMedico register(Perfil profile) {
        if(perfilDao.findDuplicity(profile)){
           return estadoHistorialMedico.INCOMPLETO;
       }else{
           perfilDao.create(profile);
           return estadoHistorialMedico.COMPLETO;
       }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public estadoHistorialMedico modify(Perfil profile) {
        if(profile.getId()==null || perfilDao.find(profile.getId())==null){
        return estadoHistorialMedico.INCOMPLETO;
        }
        else{
            perfilDao.edit(profile);
            return estadoHistorialMedico.COMPLETO;
        }
    }

    @Override
    public estadoHistorialMedico delete(Perfil profile) {
        if(profile.getId()==null || perfilDao.find(profile.getId())==null){
        return estadoHistorialMedico.INCOMPLETO;
        }
        else{
            perfilDao.remove(profile);
            return estadoHistorialMedico.COMPLETO;
        }
    }

    @Override
    public List<Perfil> getAll() {
        return perfilDao.findAll();
    }  
    
}
