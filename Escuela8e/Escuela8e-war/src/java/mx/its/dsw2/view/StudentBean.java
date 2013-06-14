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
import mx.its.dsw2.Dao.PerfilDaoLocal;
import mx.its.dsw2.Modelo.Alumno;
import mx.its.dsw2.Modelo.Perfil;
import mx.its.dsw2.bl.AlumnoBlLocal;
import mx.its.dsw2.bl.PerfilBlLocal;

/**
 *
 * @author franciscojavier
 */
@ManagedBean
@SessionScoped
public class StudentBean {
    @EJB
    private PerfilDaoLocal perfilDao;
    @EJB
    private PerfilBlLocal perfilBl;
   

    @EJB
    private AlumnoBlLocal alumnoBl;
    
    private List<Alumno> lista;
    private List<Perfil> listaPerfil;
    private Alumno student;
    private String accion;
    private int perfilSeleccionado;

    /**
     * Creates a new instance of StudentBean
     */
    public StudentBean() {
         student= new Alumno();
    }

    //-------------METODOS GET Y SET--------
    public List<Alumno> getLista() {
        lista = alumnoBl.getAll();
        return lista;
    }

    public Alumno getStudent() {
        return student;
    }

    public void setStudent(Alumno student) {
        this.student = student;
    }

    public int getPerfilSeleccionado() {
        return perfilSeleccionado;
    }

    public void setPerfilSeleccionado(int perfilSeleccionado) {
        this.perfilSeleccionado = perfilSeleccionado;
    }

    public List<Perfil> getListaPerfil() {
        listaPerfil = perfilBl.getAll();
        return listaPerfil;
    }

    public void setListaPerfil(List<Perfil> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }
    
   
    

    //-----------------ACCIONES---------------
//public String prepararNuevo(){
//    author=new Autor();
//    return "AutorCrearEditar";
    public String procesarAccion() {
        if (accion.equalsIgnoreCase("Nuevo")) {
            alumnoBl.register(student);
        } else {
            if (accion.equalsIgnoreCase("Editar")) {
                alumnoBl.modify(student);
            } else {

                if (accion.equalsIgnoreCase("Eliminar")) {
                    alumnoBl.delete(student);
                }
            }
        }
        accion = "";
        return "UsuarioLista";

    }
    public void agregarPerfil(ActionEvent evet){
        student.setIdPerfil(perfilDao.find(perfilSeleccionado));
    }


//------------LISTENERS------------------
    public void prepararNuevo(ActionEvent evt) {
        accion = "Nuevo";
        student = new Alumno();
    }

    public void prepararEditar(ActionEvent evt) {
        accion = "Editar";
        int index = Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
        student = lista.get(index);

//    System.out.println(evt.getComponent().getClientId());
//    String arr[]=evt.getComponent().getClientId().split(":");
//    String id=arr[2];
//    int index=Integer.parseInt(id);   
    }

    public void prepararEliminar(ActionEvent evt) {
        accion = "Eliminar";
        int index = Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
        student = lista.get(index);
    }
}
