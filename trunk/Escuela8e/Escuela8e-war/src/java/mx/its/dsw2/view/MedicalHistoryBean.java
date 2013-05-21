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
import mx.its.dsw2.Modelo.HistorialMedico;
import mx.its.dsw2.bl.HistorialMedicoBlLocal;

/**
 *
 * @author franciscojavier
 */
@ManagedBean
@SessionScoped
public class MedicalHistoryBean {
    @EJB
    private HistorialMedicoBlLocal historialMedicoBl;
   
    
    private List<HistorialMedico> lista;
    private HistorialMedico medicalHistory;
    private String accion;

    /**
     * Creates a new instance of MedicalHistoryBean
     */
    public MedicalHistoryBean() {
        medicalHistory = new HistorialMedico();
    }
    
     public List<HistorialMedico> getLista() {
        lista=historialMedicoBl.getAll();
        return lista;
    }

    public HistorialMedico getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(HistorialMedico medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
     
    
    
    //-----------------ACCIONES---------------
//public String prepararNuevo(){
//    author=new Autor();
//    return "AutorCrearEditar";
    public String procesarAccion(){
       if(accion.equalsIgnoreCase("Nuevo")){
        historialMedicoBl.register(medicalHistory);
       }else{
           if(accion.equalsIgnoreCase("Editar")){
               historialMedicoBl.modify(medicalHistory);
             }else{
      
          if(accion.equalsIgnoreCase("Eliminar")){
               historialMedicoBl.delete(medicalHistory);  
       }
           }
       }
        accion="";
        return "HistorialMedicLista";
    
       }
//}
       



//------------LISTENERS------------------
public void prepararNuevo(ActionEvent evt){
    accion="Nuevo";
    medicalHistory=new HistorialMedico();
}
public void prepararEditar(ActionEvent evt){
    accion="Editar";
    int index=Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
    medicalHistory=lista.get(index);
    
//    System.out.println(evt.getComponent().getClientId());
//    String arr[]=evt.getComponent().getClientId().split(":");
//    String id=arr[2];
//    int index=Integer.parseInt(id);   
}
public void prepararEliminar(ActionEvent evt){
    accion="Eliminar";
    int index=Integer.parseInt(evt.getComponent().getClientId().split(":")[2]);
    medicalHistory=lista.get(index);
}
    
    
}
