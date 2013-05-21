/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.bl;

import java.util.List;
import javax.ejb.Local;
import mx.its.dsw2.Modelo.HistorialMedico;
import mx.its.dsw2.escuela.enumeracion.estadoHistorialMedico;

/**
 *
 * @author franciscojavier
 */
@Local
public interface HistorialMedicoBlLocal {
    estadoHistorialMedico register(HistorialMedico medicalhistory);

    estadoHistorialMedico modify(HistorialMedico medicalhistory);

    estadoHistorialMedico delete(HistorialMedico medicalhistory);

    List<HistorialMedico> getAll();
    
}
