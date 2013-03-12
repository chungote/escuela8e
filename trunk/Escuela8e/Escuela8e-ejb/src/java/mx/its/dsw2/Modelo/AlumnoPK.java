/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author franciscojavier
 */
@Embeddable
public class AlumnoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Control")
    private String control;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HistorialMedico_id")
    private int historialMedicoid;

    public AlumnoPK() {
    }

    public AlumnoPK(String control, int historialMedicoid) {
        this.control = control;
        this.historialMedicoid = historialMedicoid;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public int getHistorialMedicoid() {
        return historialMedicoid;
    }

    public void setHistorialMedicoid(int historialMedicoid) {
        this.historialMedicoid = historialMedicoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (control != null ? control.hashCode() : 0);
        hash += (int) historialMedicoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumnoPK)) {
            return false;
        }
        AlumnoPK other = (AlumnoPK) object;
        if ((this.control == null && other.control != null) || (this.control != null && !this.control.equals(other.control))) {
            return false;
        }
        if (this.historialMedicoid != other.historialMedicoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.its.dsw2.Modelo.AlumnoPK[ control=" + control + ", historialMedicoid=" + historialMedicoid + " ]";
    }
    
}
