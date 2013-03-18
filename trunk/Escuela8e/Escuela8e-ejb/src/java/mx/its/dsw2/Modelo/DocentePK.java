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

/**
 *
 * @author franciscojavier
 */
@Embeddable
public class DocentePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HistorialMedico_id")
    private int historialMedicoid;

    public DocentePK() {
    }

    public DocentePK(int id, int historialMedicoid) {
        this.id = id;
        this.historialMedicoid = historialMedicoid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        hash += (int) id;
        hash += (int) historialMedicoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocentePK)) {
            return false;
        }
        DocentePK other = (DocentePK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.historialMedicoid != other.historialMedicoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.its.dsw2.Modelo.DocentePK[ id=" + id + ", historialMedicoid=" + historialMedicoid + " ]";
    }
    
}
