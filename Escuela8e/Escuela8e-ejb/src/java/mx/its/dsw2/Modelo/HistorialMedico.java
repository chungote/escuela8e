/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author franciscojavier
 */
@Entity
@Table(name = "historialmedico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialMedico.findAll", query = "SELECT h FROM HistorialMedico h"),
    @NamedQuery(name = "HistorialMedico.findById", query = "SELECT h FROM HistorialMedico h WHERE h.id = :id"),
    @NamedQuery(name = "HistorialMedico.findByFecha", query = "SELECT h FROM HistorialMedico h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "HistorialMedico.findByNombre", query = "SELECT h FROM HistorialMedico h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "HistorialMedico.findByApellidoPaterno", query = "SELECT h FROM HistorialMedico h WHERE h.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "HistorialMedico.findByApellidoMaterno", query = "SELECT h FROM HistorialMedico h WHERE h.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "HistorialMedico.findByEdad", query = "SELECT h FROM HistorialMedico h WHERE h.edad = :edad"),
    @NamedQuery(name = "HistorialMedico.findBySexo", query = "SELECT h FROM HistorialMedico h WHERE h.sexo = :sexo"),
    @NamedQuery(name = "HistorialMedico.findByFechaNacimiento", query = "SELECT h FROM HistorialMedico h WHERE h.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "HistorialMedico.findByEnfermedades", query = "SELECT h FROM HistorialMedico h WHERE h.enfermedades = :enfermedades"),
    @NamedQuery(name = "HistorialMedico.findByNoVacunas", query = "SELECT h FROM HistorialMedico h WHERE h.noVacunas = :noVacunas"),
    @NamedQuery(name = "HistorialMedico.findByNomVacunas", query = "SELECT h FROM HistorialMedico h WHERE h.nomVacunas = :nomVacunas"),
    @NamedQuery(name = "HistorialMedico.findDuplicity", query = "SELECT h FROM HistorialMedico h WHERE h.id = :id")})
 
public class HistorialMedico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Enfermedades")
    private String enfermedades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "noVacunas")
    private String noVacunas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomVacunas")
    private String nomVacunas;

    public HistorialMedico() {
    }

    public HistorialMedico(Integer id) {
        this.id = id;
    }

    public HistorialMedico(Integer id, Date fecha, String nombre, String apellidoPaterno, int edad, String sexo, Date fechaNacimiento, String enfermedades, String noVacunas, String nomVacunas) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.enfermedades = enfermedades;
        this.noVacunas = noVacunas;
        this.nomVacunas = nomVacunas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getNoVacunas() {
        return noVacunas;
    }

    public void setNoVacunas(String noVacunas) {
        this.noVacunas = noVacunas;
    }

    public String getNomVacunas() {
        return nomVacunas;
    }

    public void setNomVacunas(String nomVacunas) {
        this.nomVacunas = nomVacunas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialMedico)) {
            return false;
        }
        HistorialMedico other = (HistorialMedico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.its.dsw2.Modelo.HistorialMedico[ id=" + id + " ]";
    }
    
}
