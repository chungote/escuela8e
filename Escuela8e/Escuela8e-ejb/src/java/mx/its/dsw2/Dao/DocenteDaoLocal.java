/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Dao;

import java.util.List;
import javax.ejb.Local;
import mx.its.dsw2.Modelo.Docente;

/**
 *
 * @author franciscojavier
 */
@Local
public interface DocenteDaoLocal {

    void create(Docente docente);

    void edit(Docente docente);

    void remove(Docente docente);

    Docente find(Object id);

    List<Docente> findAll();

    List<Docente> findRange(int[] range);

    int count();
    
    boolean findDuplicity(Docente teaching);
    
}
