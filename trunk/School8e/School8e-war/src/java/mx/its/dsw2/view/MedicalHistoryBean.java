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
    

    /**
     * Creates a new instance of MedicalHistory
     */
    public MedicalHistoryBean() {
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
        historialMedicoBl.register(medicalHistory);
        
        return "HistorialMedicoLista";
    }
//}




//------------LISTENERS------------------
public void prepararNuevo(ActionEvent evt){
    medicalHistory=new HistorialMedico();
}

}
