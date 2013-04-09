/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.bl;

import java.util.List;
import javax.ejb.Local;
import mx.its.dsw2.Modelo.Alumno;
import mx.its.dsw2.school.enumeracion.estadoHistorialMedico;

/**
 *
 * @author franciscojavier
 */
@Local
public interface AlumnoBlLocal {

    estadoHistorialMedico register(Alumno student);

    estadoHistorialMedico modify(Alumno student);

    estadoHistorialMedico delete(Alumno student);

    List<Alumno> getAll();
    
}
