/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.bl;

import java.util.List;
import javax.ejb.Local;
import mx.its.dsw2.Modelo.Perfil;
import mx.its.dsw2.escuela.enumeracion.estadoHistorialMedico;

/**
 *
 * @author franciscojavier
 */
@Local
public interface PerfilBlLocal {
    estadoHistorialMedico register(Perfil profile);

    estadoHistorialMedico modify(Perfil profile);

    estadoHistorialMedico delete(Perfil profile);

    List<Perfil> getAll();
    
}
