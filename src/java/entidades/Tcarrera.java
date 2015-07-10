/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "tcarrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcarrera.findAll", query = "SELECT t FROM Tcarrera t"),
    @NamedQuery(name = "Tcarrera.findByTcarreracodigo", query = "SELECT t FROM Tcarrera t WHERE t.tcarreracodigo = :tcarreracodigo"),
    @NamedQuery(name = "Tcarrera.findByTcarreranombre", query = "SELECT t FROM Tcarrera t WHERE t.tcarreranombre = :tcarreranombre"),
    @NamedQuery(name = "Tcarrera.findByTcarreratitulo", query = "SELECT t FROM Tcarrera t WHERE t.tcarreratitulo = :tcarreratitulo"),
    @NamedQuery(name = "Tcarrera.findByTcarreraareaconocimiento", query = "SELECT t FROM Tcarrera t WHERE t.tcarreraareaconocimiento = :tcarreraareaconocimiento"),
    @NamedQuery(name = "Tcarrera.findByTcarrerasubareaconocimiento", query = "SELECT t FROM Tcarrera t WHERE t.tcarrerasubareaconocimiento = :tcarrerasubareaconocimiento"),
    @NamedQuery(name = "Tcarrera.findByTcarreranivelformacion", query = "SELECT t FROM Tcarrera t WHERE t.tcarreranivelformacion = :tcarreranivelformacion"),
    @NamedQuery(name = "Tcarrera.findByTcarreramodalidad", query = "SELECT t FROM Tcarrera t WHERE t.tcarreramodalidad = :tcarreramodalidad"),
    @NamedQuery(name = "Tcarrera.findByTcarreraduracion", query = "SELECT t FROM Tcarrera t WHERE t.tcarreraduracion = :tcarreraduracion"),
    @NamedQuery(name = "Tcarrera.findByTcarrerafecharesolucionaprobacion", query = "SELECT t FROM Tcarrera t WHERE t.tcarrerafecharesolucionaprobacion = :tcarrerafecharesolucionaprobacion"),
    @NamedQuery(name = "Tcarrera.findByTcarreranumeroresolucionaprobacion", query = "SELECT t FROM Tcarrera t WHERE t.tcarreranumeroresolucionaprobacion = :tcarreranumeroresolucionaprobacion"),
    @NamedQuery(name = "Tcarrera.findByTcarreratiposede", query = "SELECT t FROM Tcarrera t WHERE t.tcarreratiposede = :tcarreratiposede"),
    @NamedQuery(name = "Tcarrera.findByTcarreranombresede", query = "SELECT t FROM Tcarrera t WHERE t.tcarreranombresede = :tcarreranombresede")})
public class Tcarrera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcarreracodigo")
    private Long tcarreracodigo;
    @Size(max = 50)
    @Column(name = "tcarreranombre")
    private String tcarreranombre;
    @Size(max = 50)
    @Column(name = "tcarreratitulo")
    private String tcarreratitulo;
    @Size(max = 100)
    @Column(name = "tcarreraareaconocimiento")
    private String tcarreraareaconocimiento;
    @Size(max = 100)
    @Column(name = "tcarrerasubareaconocimiento")
    private String tcarrerasubareaconocimiento;
    @Size(max = 50)
    @Column(name = "tcarreranivelformacion")
    private String tcarreranivelformacion;
    @Size(max = 50)
    @Column(name = "tcarreramodalidad")
    private String tcarreramodalidad;
    @Size(max = 20)
    @Column(name = "tcarreraduracion")
    private String tcarreraduracion;
    @Column(name = "tcarrerafecharesolucionaprobacion")
    @Temporal(TemporalType.DATE)
    private Date tcarrerafecharesolucionaprobacion;
    @Size(max = 20)
    @Column(name = "tcarreranumeroresolucionaprobacion")
    private String tcarreranumeroresolucionaprobacion;
    @Size(max = 20)
    @Column(name = "tcarreratiposede")
    private String tcarreratiposede;
    @Size(max = 50)
    @Column(name = "tcarreranombresede")
    private String tcarreranombresede;
    @JoinColumn(name = "tescuelacodigo", referencedColumnName = "tescuelacodigo")
    @ManyToOne
    private Tescuela tescuelacodigo;
    @OneToMany(mappedBy = "tcarreracodigo")
    private List<Tcarreraperiodo> tcarreraperiodoList;
    @OneToMany(mappedBy = "tcarreracodigo")
    private List<Tcarreracriteriosubcriterio> tcarreracriteriosubcriterioList;

    public Tcarrera() {
    }

    public Tcarrera(Long tcarreracodigo) {
        this.tcarreracodigo = tcarreracodigo;
    }

    public Long getTcarreracodigo() {
        return tcarreracodigo;
    }

    public void setTcarreracodigo(Long tcarreracodigo) {
        this.tcarreracodigo = tcarreracodigo;
    }

    public String getTcarreranombre() {
        return tcarreranombre;
    }

    public void setTcarreranombre(String tcarreranombre) {
        this.tcarreranombre = tcarreranombre;
    }

    public String getTcarreratitulo() {
        return tcarreratitulo;
    }

    public void setTcarreratitulo(String tcarreratitulo) {
        this.tcarreratitulo = tcarreratitulo;
    }

    public String getTcarreraareaconocimiento() {
        return tcarreraareaconocimiento;
    }

    public void setTcarreraareaconocimiento(String tcarreraareaconocimiento) {
        this.tcarreraareaconocimiento = tcarreraareaconocimiento;
    }

    public String getTcarrerasubareaconocimiento() {
        return tcarrerasubareaconocimiento;
    }

    public void setTcarrerasubareaconocimiento(String tcarrerasubareaconocimiento) {
        this.tcarrerasubareaconocimiento = tcarrerasubareaconocimiento;
    }

    public String getTcarreranivelformacion() {
        return tcarreranivelformacion;
    }

    public void setTcarreranivelformacion(String tcarreranivelformacion) {
        this.tcarreranivelformacion = tcarreranivelformacion;
    }

    public String getTcarreramodalidad() {
        return tcarreramodalidad;
    }

    public void setTcarreramodalidad(String tcarreramodalidad) {
        this.tcarreramodalidad = tcarreramodalidad;
    }

    public String getTcarreraduracion() {
        return tcarreraduracion;
    }

    public void setTcarreraduracion(String tcarreraduracion) {
        this.tcarreraduracion = tcarreraduracion;
    }

    public Date getTcarrerafecharesolucionaprobacion() {
        return tcarrerafecharesolucionaprobacion;
    }

    public void setTcarrerafecharesolucionaprobacion(Date tcarrerafecharesolucionaprobacion) {
        this.tcarrerafecharesolucionaprobacion = tcarrerafecharesolucionaprobacion;
    }

    public String getTcarreranumeroresolucionaprobacion() {
        return tcarreranumeroresolucionaprobacion;
    }

    public void setTcarreranumeroresolucionaprobacion(String tcarreranumeroresolucionaprobacion) {
        this.tcarreranumeroresolucionaprobacion = tcarreranumeroresolucionaprobacion;
    }

    public String getTcarreratiposede() {
        return tcarreratiposede;
    }

    public void setTcarreratiposede(String tcarreratiposede) {
        this.tcarreratiposede = tcarreratiposede;
    }

    public String getTcarreranombresede() {
        return tcarreranombresede;
    }

    public void setTcarreranombresede(String tcarreranombresede) {
        this.tcarreranombresede = tcarreranombresede;
    }

    public Tescuela getTescuelacodigo() {
        return tescuelacodigo;
    }

    public void setTescuelacodigo(Tescuela tescuelacodigo) {
        this.tescuelacodigo = tescuelacodigo;
    }

    @XmlTransient
    public List<Tcarreraperiodo> getTcarreraperiodoList() {
        return tcarreraperiodoList;
    }

    public void setTcarreraperiodoList(List<Tcarreraperiodo> tcarreraperiodoList) {
        this.tcarreraperiodoList = tcarreraperiodoList;
    }

    @XmlTransient
    public List<Tcarreracriteriosubcriterio> getTcarreracriteriosubcriterioList() {
        return tcarreracriteriosubcriterioList;
    }

    public void setTcarreracriteriosubcriterioList(List<Tcarreracriteriosubcriterio> tcarreracriteriosubcriterioList) {
        this.tcarreracriteriosubcriterioList = tcarreracriteriosubcriterioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcarreracodigo != null ? tcarreracodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tcarrera)) {
            return false;
        }
        Tcarrera other = (Tcarrera) object;
        if ((this.tcarreracodigo == null && other.tcarreracodigo != null) || (this.tcarreracodigo != null && !this.tcarreracodigo.equals(other.tcarreracodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tcarrera[ tcarreracodigo=" + tcarreracodigo + " ]";
    }
    
}
