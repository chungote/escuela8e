/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.its.dsw2.Dao.AlumnoDaoLocal;
import mx.its.dsw2.Modelo.Alumno;
import mx.its.dsw2.escuela.enumeracion.estadoHistorialMedico;

/**
 *
 * @author  franciscojavier
 */
@Stateless
public class AlumnoBl implements AlumnoBlLocal {
    @EJB
    private AlumnoDaoLocal alumnoDao;

    @Override
    public estadoHistorialMedico register(Alumno student) {
        if(alumnoDao.findDuplicity(student)){
           return estadoHistorialMedico.INCOMPLETO;
       }else{
           alumnoDao.create(student);
           return estadoHistorialMedico.COMPLETO;
       }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public estadoHistorialMedico modify(Alumno student) {
        if(student.getId()==null || alumnoDao.find(student.getId())==null){
        return estadoHistorialMedico.INCOMPLETO;
        }
        else{
            alumnoDao.edit(student);
            return estadoHistorialMedico.COMPLETO;
        }
    }

    @Override
    public estadoHistorialMedico delete(Alumno student) {
        if(student.getId()==null || alumnoDao.find(student.getId())==null){
        return estadoHistorialMedico.INCOMPLETO;
        }
        else{
            alumnoDao.remove(student);
            return estadoHistorialMedico.COMPLETO;
        }
    }

    @Override
    public List<Alumno> getAll() {
        return alumnoDao.findAll();
    }  
    
     @Override
    public Alumno findById(int idAlumno) {
        return alumnoDao.find(idAlumno);
    }
    
}
