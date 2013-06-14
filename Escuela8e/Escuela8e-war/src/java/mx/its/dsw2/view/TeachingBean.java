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
import mx.its.dsw2.Modelo.Docente;
import mx.its.dsw2.Modelo.Perfil;
import mx.its.dsw2.bl.DocenteBlLocal;
import mx.its.dsw2.bl.PerfilBlLocal;

/**
 *
 * @author franciscojavier
 */
@ManagedBean
@SessionScoped
public class TeachingBean {
    @EJB
    private PerfilDaoLocal perfilDao;
    @EJB
    private PerfilBlLocal perfilBl;

    @EJB
    private DocenteBlLocal docenteBl;
    
    
    private List<Docente> lista;
    private List<Perfil> listaPerfil;
    private Docente teaching;
    private String accion;
    private int perfilSeleccionado;

    /**
     * Creates a new instance of TeachingBean
     */
    public TeachingBean() {
         teaching= new Docente();
    }

    public List<Docente> getLista() {
        lista = docenteBl.getAll();
        return lista;
    }

    public Docente getTeaching() {
        return teaching;
    }

    public List<Perfil> getListaPerfil() {
        listaPerfil = perfilBl.getAll();
        return listaPerfil;
    }

    public void setListaPerfil(List<Perfil> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }

    public int getPerfilSeleccionado() {
        return perfilSeleccionado;
    }

    public void setPerfilSeleccionado(int perfilSeleccionado) {
        this.perfilSeleccionado = perfilSeleccionado;
    }
    

    //-----------------ACCIONES---------------
//public String prepararNuevo(){
//    author=new Autor();
//    return "AutorCrearEditar";
    public String procesarAccion() {
        if (accion.equalsIgnoreCase("Nuevo")) {
            docenteBl.register(teaching);
        } else {
            if (accion.equalsIgnoreCase("Editar")) {
                docenteBl.modify(teaching);
            } else {

                if (accion.equalsIgnoreCase("Eliminar")) {
                    docenteBl.delete(teaching);
                }
            }
        }
        accion = "";
        return "DocenteLista";

    }
    public void agregarPerfil(ActionEvent evet){
        teaching.setIdPerfil(perfilDao.find(perfilSeleccionado));
    }
//}

//------------LISTENERS------------------
    public void prepararNuevo(ActionEvent evt) {
        accion = "Nuevo";
        teaching = new Docente();
    }

    public void prepararEditar(ActionEvent evt) {
        accion = "Editar";
        int index = Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
        teaching = lista.get(index);

//    System.out.println(evt.getComponent().getClientId());
//    String arr[]=evt.getComponent().getClientId().split(":");
//    String id=arr[2];
//    int index=Integer.parseInt(id);   
    }

    public void prepararEliminar(ActionEvent evt) {
        accion = "Eliminar";
        int index = Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
        teaching = lista.get(index);
    }
}
