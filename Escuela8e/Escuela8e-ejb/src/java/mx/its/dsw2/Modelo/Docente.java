/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author franciscojavier
 */
@Entity
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findById", query = "SELECT d FROM Docente d WHERE d.docentePK.id = :id"),
    @NamedQuery(name = "Docente.findByControl", query = "SELECT d FROM Docente d WHERE d.control = :control"),
    @NamedQuery(name = "Docente.findByNombre", query = "SELECT d FROM Docente d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Docente.findByApellidoPaterno", query = "SELECT d FROM Docente d WHERE d.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Docente.findByApellidoMaterno", query = "SELECT d FROM Docente d WHERE d.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Docente.findByTelefono", query = "SELECT d FROM Docente d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Docente.findByDireccion", query = "SELECT d FROM Docente d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Docente.findByColonia", query = "SELECT d FROM Docente d WHERE d.colonia = :colonia"),
    @NamedQuery(name = "Docente.findByCodigoPostal", query = "SELECT d FROM Docente d WHERE d.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Docente.findByFechaNacimiento", query = "SELECT d FROM Docente d WHERE d.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Docente.findByHistorialMedicoid", query = "SELECT d FROM Docente d WHERE d.docentePK.historialMedicoid = :historialMedicoid")})
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocentePK docentePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Control")
    private String control;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;
    @Size(max = 20)
    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codigoPostal")
    private String codigoPostal;
    @Size(max = 30)
    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
    @JoinColumn(name = "HistorialMedico_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HistorialMedico historialMedico;

    public Docente() {
    }

    public Docente(DocentePK docentePK) {
        this.docentePK = docentePK;
    }

    public Docente(DocentePK docentePK, String control, String nombre, String apellidoPaterno, String direccion, String colonia, String codigoPostal) {
        this.docentePK = docentePK;
        this.control = control;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.direccion = direccion;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public Docente(int id, int historialMedicoid) {
        this.docentePK = new DocentePK(id, historialMedicoid);
    }

    public DocentePK getDocentePK() {
        return docentePK;
    }

    public void setDocentePK(DocentePK docentePK) {
        this.docentePK = docentePK;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docentePK != null ? docentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.docentePK == null && other.docentePK != null) || (this.docentePK != null && !this.docentePK.equals(other.docentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.its.dsw2.Modelo.Docente[ docentePK=" + docentePK + " ]";
    }
    
}
