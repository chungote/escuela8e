/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Dao;

import java.util.List;
import javax.ejb.Local;
import mx.its.dsw2.Modelo.HistorialMedico;

/**
 *
 * @author franciscojavier
 */
@Local
public interface HistorialMedicoDaoLocal {

    void create(HistorialMedico historialMedico);

    void edit(HistorialMedico historialMedico);

    void remove(HistorialMedico historialMedico);

    HistorialMedico find(Object id);

    List<HistorialMedico> findAll();

    List<HistorialMedico> findRange(int[] range);

    int count();
    
     boolean findDuplicity(HistorialMedico medicalHistory);
    
}
