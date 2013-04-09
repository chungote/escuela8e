/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.bl;

import java.util.List;
import javax.ejb.Local;
import mx.its.dsw2.Modelo.Docente;
import mx.its.dsw2.school.enumeracion.estadoHistorialMedico;

/**
 *
 * @author franciscojavier
 */
@Local
public interface DocenteBlLocal {
    estadoHistorialMedico register(Docente teaching);

    estadoHistorialMedico modify(Docente teaching);

    estadoHistorialMedico delete(Docente teaching);

    List<Docente> getAll();
}
