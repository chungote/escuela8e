/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.its.dsw2.Dao.DocenteDaoLocal;
import mx.its.dsw2.Modelo.Docente;
import mx.its.dsw2.escuela.enumeracion.estadoHistorialMedico;

/**
 *
 * @author franciscojavier
 */
@Stateless
public class DocenteBl implements DocenteBlLocal {
    @EJB
    private DocenteDaoLocal docenteDao;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
public estadoHistorialMedico register(Docente teaching) {
        if(docenteDao.findDuplicity(teaching)){
           return estadoHistorialMedico.INCOMPLETO;
       }else{
           docenteDao.create(teaching);
           return estadoHistorialMedico.COMPLETO;
       }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public estadoHistorialMedico modify(Docente teaching) {
        if(teaching.getId()==null || docenteDao.find(teaching.getId())==null){
        return estadoHistorialMedico.INCOMPLETO;
        }
        else{
            docenteDao.edit(teaching);
            return estadoHistorialMedico.COMPLETO;
        }
    }

    @Override
    public estadoHistorialMedico delete(Docente teaching) {
        if(teaching.getId()==null || docenteDao.find(teaching.getId())==null){
        return estadoHistorialMedico.INCOMPLETO;
        }
        else{
            docenteDao.remove(teaching);
            return estadoHistorialMedico.COMPLETO;
        }
    }

    @Override
    public List<Docente> getAll() {
        return docenteDao.findAll();
    }
}
