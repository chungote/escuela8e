/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Dao;

import java.util.List;
import javax.ejb.Local;
import mx.its.dsw2.Modelo.Alumno;

/**
 *
 * @author franciscojavier
 */
@Local
public interface AlumnoDaoLocal {

    void create(Alumno alumno);

    void edit(Alumno alumno);

    void remove(Alumno alumno);

    Alumno find(Object id);

    List<Alumno> findAll();

    List<Alumno> findRange(int[] range);

    int count();
    
}
