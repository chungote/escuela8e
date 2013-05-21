/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Dao;

import java.util.List;
import javax.ejb.Local;
import mx.its.dsw2.Modelo.Perfil;

/**
 *
 * @author franciscojavier
 */
@Local
public interface PerfilDaoLocal {

    void create(Perfil perfil);

    void edit(Perfil perfil);

    void remove(Perfil perfil);

    Perfil find(Object id);

    List<Perfil> findAll();

    List<Perfil> findRange(int[] range);

    int count();
    
    boolean findDuplicity(Perfil profile);
    
    
}
