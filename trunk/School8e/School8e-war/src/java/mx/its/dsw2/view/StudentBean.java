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
import mx.its.dsw2.bl.AlumnoBlLocal;

/**
 *
 * @author franciscojavier
 */
@ManagedBean
@SessionScoped
public class StudentBean {
    @EJB
    private AlumnoBlLocal alumnoBl;
    
    
    private List<Alumno> lista;
    private Alumno student;

    /**
     * Creates a new instance of StudentBean
     */
    public StudentBean() {
    }
    
    //-------------METODOS GET Y SET--------
    public List<Alumno> getLista() {
        lista=alumnoBl.getAll();
        return lista;
    }

    public Alumno getStudent() {
        return student;
    }

    public void setStudent(Alumno student) {
        this.student = student;
    }
    
    


//-----------------ACCIONES---------------
//public String prepararNuevo(){
//    author=new Autor();
//    return "AutorCrearEditar";
    public String procesarAccion(){
        alumnoBl.register(student);
        
        return "AlumnoLista";
    }
//}




//------------LISTENERS------------------
public void prepararNuevo(ActionEvent evt){
    student=new Alumno();
}
    
    
    }

