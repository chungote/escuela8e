/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.Modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "HistorialMedico.findByHora", query = "SELECT h FROM HistorialMedico h WHERE h.hora = :hora"),
    @NamedQuery(name = "HistorialMedico.findByNombre", query = "SELECT h FROM HistorialMedico h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "HistorialMedico.findByApellidoPaterno", query = "SELECT h FROM HistorialMedico h WHERE h.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "HistorialMedico.findByApellidoMaterno", query = "SELECT h FROM HistorialMedico h WHERE h.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "HistorialMedico.findByEdad", query = "SELECT h FROM HistorialMedico h WHERE h.edad = :edad"),
    @NamedQuery(name = "HistorialMedico.findBySexo", query = "SELECT h FROM HistorialMedico h WHERE h.sexo = :sexo"),
    @NamedQuery(name = "HistorialMedico.findByPeso", query = "SELECT h FROM HistorialMedico h WHERE h.peso = :peso"),
    @NamedQuery(name = "HistorialMedico.findByEstatura", query = "SELECT h FROM HistorialMedico h WHERE h.estatura = :estatura"),
    @NamedQuery(name = "HistorialMedico.findByFechaNacimiento", query = "SELECT h FROM HistorialMedico h WHERE h.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "HistorialMedico.findByTelefono", query = "SELECT h FROM HistorialMedico h WHERE h.telefono = :telefono"),
    @NamedQuery(name = "HistorialMedico.findByPadeceEnfermedad", query = "SELECT h FROM HistorialMedico h WHERE h.padeceEnfermedad = :padeceEnfermedad"),
    @NamedQuery(name = "HistorialMedico.findByTomaAlgunMedicamento", query = "SELECT h FROM HistorialMedico h WHERE h.tomaAlgunMedicamento = :tomaAlgunMedicamento"),
    @NamedQuery(name = "HistorialMedico.findByVacunasAdministradas", query = "SELECT h FROM HistorialMedico h WHERE h.vacunasAdministradas = :vacunasAdministradas"),
    @NamedQuery(name = "HistorialMedico.findByNombreVacunas", query = "SELECT h FROM HistorialMedico h WHERE h.nombreVacunas = :nombreVacunas"),
    @NamedQuery(name = "HistorialMedico.findByAntecedentesFamilia", query = "SELECT h FROM HistorialMedico h WHERE h.antecedentesFamilia = :antecedentesFamilia")})
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
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
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
    @Column(name = "peso")
    private long peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatura")
    private long estatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "padeceEnfermedad")
    private String padeceEnfermedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tomaAlgunMedicamento")
    private String tomaAlgunMedicamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VacunasAdministradas")
    private int vacunasAdministradas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreVacunas")
    private String nombreVacunas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "antecedentesFamilia")
    private String antecedentesFamilia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historialMedico")
    private Collection<Alumno> alumnoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historialMedico")
    private Collection<Docente> docenteCollection;

    public HistorialMedico() {
    }

    public HistorialMedico(Integer id) {
        this.id = id;
    }

    public HistorialMedico(Integer id, Date fecha, Date hora, String nombre, String apellidoPaterno, int edad, String sexo, long peso, long estatura, String fechaNacimiento, String padeceEnfermedad, String tomaAlgunMedicamento, int vacunasAdministradas, String nombreVacunas, String antecedentesFamilia) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.estatura = estatura;
        this.fechaNacimiento = fechaNacimiento;
        this.padeceEnfermedad = padeceEnfermedad;
        this.tomaAlgunMedicamento = tomaAlgunMedicamento;
        this.vacunasAdministradas = vacunasAdministradas;
        this.nombreVacunas = nombreVacunas;
        this.antecedentesFamilia = antecedentesFamilia;
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

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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

    public long getPeso() {
        return peso;
    }

    public void setPeso(long peso) {
        this.peso = peso;
    }

    public long getEstatura() {
        return estatura;
    }

    public void setEstatura(long estatura) {
        this.estatura = estatura;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPadeceEnfermedad() {
        return padeceEnfermedad;
    }

    public void setPadeceEnfermedad(String padeceEnfermedad) {
        this.padeceEnfermedad = padeceEnfermedad;
    }

    public String getTomaAlgunMedicamento() {
        return tomaAlgunMedicamento;
    }

    public void setTomaAlgunMedicamento(String tomaAlgunMedicamento) {
        this.tomaAlgunMedicamento = tomaAlgunMedicamento;
    }

    public int getVacunasAdministradas() {
        return vacunasAdministradas;
    }

    public void setVacunasAdministradas(int vacunasAdministradas) {
        this.vacunasAdministradas = vacunasAdministradas;
    }

    public String getNombreVacunas() {
        return nombreVacunas;
    }

    public void setNombreVacunas(String nombreVacunas) {
        this.nombreVacunas = nombreVacunas;
    }

    public String getAntecedentesFamilia() {
        return antecedentesFamilia;
    }

    public void setAntecedentesFamilia(String antecedentesFamilia) {
        this.antecedentesFamilia = antecedentesFamilia;
    }

    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }

    @XmlTransient
    public Collection<Docente> getDocenteCollection() {
        return docenteCollection;
    }

    public void setDocenteCollection(Collection<Docente> docenteCollection) {
        this.docenteCollection = docenteCollection;
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
