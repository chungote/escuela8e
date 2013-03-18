/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Bl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.its.dsw2.Dao.AlumnoDao;
import mx.its.dsw2.Dao.AlumnoDaoLocal;
import mx.its.dsw2.Modelo.Alumno;

/**
 *
 * @author franciscojavier
 */
@Stateless
public class AlumnoBl implements AlumnoBlLocal {
    @EJB
    private AlumnoDaoLocal alumnoDao;

    @Override
    public void Register(Alumno student) {
        alumnoDao.create(student);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
