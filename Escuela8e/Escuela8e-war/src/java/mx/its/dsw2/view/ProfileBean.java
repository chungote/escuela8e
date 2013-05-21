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
import mx.its.dsw2.Modelo.Perfil;
import mx.its.dsw2.bl.PerfilBlLocal;

/**
 *
 * @author franciscojavier
 */
@ManagedBean
@SessionScoped
public class ProfileBean {
    @EJB
    private PerfilBlLocal perfilBl;
    

    private List<Perfil> lista;
    private Perfil profile;
    private String accion;
    /**
     * Creates a new instance of ProfileBean
     */
    public ProfileBean() {
        profile = new Perfil();
    }
    
    //-------------METODOS GET Y SET--------
    public List<Perfil> getLista() {
        lista = perfilBl.getAll();
        return lista;
    }

    public Perfil getProfile() {
        return profile;
    }

    public void setProfile(Perfil profile) {
        this.profile = profile;
    }

    //-----------------ACCIONES---------------
//public String prepararNuevo(){
//    author=new Autor();
//    return "AutorCrearEditar";
    public String procesarAccion() {
        if (accion.equalsIgnoreCase("Nuevo")) {
            perfilBl.register(profile);
        } else {
            if (accion.equalsIgnoreCase("Editar")) {
                perfilBl.modify(profile);
            } else {

                if (accion.equalsIgnoreCase("Eliminar")) {
                    perfilBl.delete(profile);
                }
            }
        }
        accion = "";
        return "PerfilLista";

    }
//}

//------------LISTENERS------------------
    public void prepararNuevo(ActionEvent evt) {
        accion = "Nuevo";
        profile = new Perfil();
    }

    public void prepararEditar(ActionEvent evt) {
        accion = "Editar";
        int index = Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
        profile = lista.get(index);

//    System.out.println(evt.getComponent().getClientId());
//    String arr[]=evt.getComponent().getClientId().split(":");
//    String id=arr[2];
//    int index=Integer.parseInt(id);   
    }

    public void prepararEliminar(ActionEvent evt) {
        accion = "Eliminar";
        int index = Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
        profile = lista.get(index);
    }
}
