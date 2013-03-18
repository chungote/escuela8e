/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.its.dsw2.Dao.HistorialMedicoDaoLocal;
import mx.its.dsw2.Modelo.HistorialMedico;
import mx.its.dsw2.biblioteca.enumeracion.estadoHistorialMedico;

/**
 *
 * @author franciscojavier
 */
@Stateless
public class HistorialMedicoBl implements HistorialMedicoBlLocal {
    @EJB
    private HistorialMedicoDaoLocal historialMedicoDao;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
public estadoHistorialMedico register(HistorialMedico medicalhistory) {
        if(historialMedicoDao.findDuplicity(medicalhistory)){
           return estadoHistorialMedico.INCOMPLETO;
       }else{
           historialMedicoDao.create(medicalhistory);
           return estadoHistorialMedico.COMPLETO;
       }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public estadoHistorialMedico modify(HistorialMedico medicalhistory) {
        if(medicalhistory.getId()==null || historialMedicoDao.find(medicalhistory.getId())==null){
        return estadoHistorialMedico.INCOMPLETO;
        }
        else{
            historialMedicoDao.edit(medicalhistory);
            return estadoHistorialMedico.COMPLETO;
        }
    }

    @Override
    public estadoHistorialMedico delete(HistorialMedico medicalhistory) {
        if(medicalhistory.getId()==null || historialMedicoDao.find(medicalhistory.getId())==null){
        return estadoHistorialMedico.INCOMPLETO;
        }
        else{
            historialMedicoDao.remove(medicalhistory);
            return estadoHistorialMedico.COMPLETO;
        }
    }

    @Override
    public List<HistorialMedico> getAll() {
        return historialMedicoDao.findAll();
    }
}
