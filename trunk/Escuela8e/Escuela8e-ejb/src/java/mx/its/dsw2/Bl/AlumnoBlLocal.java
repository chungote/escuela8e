/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Bl;

import javax.ejb.Local;
import mx.its.dsw2.Modelo.Alumno;

/**
 *
 * @author franciscojavier
 */
@Local
public interface AlumnoBlLocal {

    void Register(Alumno student);
    
}
