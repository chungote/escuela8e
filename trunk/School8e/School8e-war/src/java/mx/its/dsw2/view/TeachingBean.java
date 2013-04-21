/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.view;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import mx.its.dsw2.Modelo.Alumno;
import mx.its.dsw2.Modelo.Docente;
import mx.its.dsw2.bl.DocenteBlLocal;

/**
 *
 * @author franciscojavier
 */
@ManagedBean
@SessionScoped
public class TeachingBean {
    @EJB
    private DocenteBlLocal docenteBl;
    
    private List<Docente> lista;
    private Docente teaching;

    /**
     * Creates a new instance of Teaching
     */
    public TeachingBean() {
    }
    
     public List<Docente> getLista() {
        lista=docenteBl.getAll();
        return lista;
    }

    public Docente getTeaching() {
        return teaching;
    }
     
    //-----------------ACCIONES---------------
//public String prepararNuevo(){
//    author=new Autor();
//    return "AutorCrearEditar";
    public String procesarAccion(){
        docenteBl.register(teaching);
        
        return "DocenteLista";
    }
//}




//------------LISTENERS------------------
public void prepararNuevo(ActionEvent evt){
    teaching=new Docente();

}
}
