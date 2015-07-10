/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "tindicador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tindicador.findAll", query = "SELECT t FROM Tindicador t"),
    @NamedQuery(name = "Tindicador.findByTindicadorcodigo", query = "SELECT t FROM Tindicador t WHERE t.tindicadorcodigo = :tindicadorcodigo"),
    @NamedQuery(name = "Tindicador.findByTindicadornombre", query = "SELECT t FROM Tindicador t WHERE t.tindicadornombre = :tindicadornombre"),
    @NamedQuery(name = "Tindicador.findByTindicadordescripcion", query = "SELECT t FROM Tindicador t WHERE t.tindicadordescripcion = :tindicadordescripcion")})
public class Tindicador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tindicadorcodigo")
    private Long tindicadorcodigo;
    @Size(max = 50)
    @Column(name = "tindicadornombre")
    private String tindicadornombre;
    @Size(max = 500)
    @Column(name = "tindicadordescripcion")
    private String tindicadordescripcion;
    @OneToMany(mappedBy = "tindicadorcodigo")
    private List<Tbaseconceptualindicador> tbaseconceptualindicadorList;
    @JoinColumn(name = "tcriteriosubcriteriocodigo", referencedColumnName = "tcriteriosubcriteriocodigo")
    @ManyToOne
    private Tcriteriosubcriterio tcriteriosubcriteriocodigo;
    @OneToMany(mappedBy = "tindicadorcodigo")
    private List<Tcalificacion> tcalificacionList;

    public Tindicador() {
    }

    public Tindicador(Long tindicadorcodigo) {
        this.tindicadorcodigo = tindicadorcodigo;
    }

    public Long getTindicadorcodigo() {
        return tindicadorcodigo;
    }

    public void setTindicadorcodigo(Long tindicadorcodigo) {
        this.tindicadorcodigo = tindicadorcodigo;
    }

    public String getTindicadornombre() {
        return tindicadornombre;
    }

    public void setTindicadornombre(String tindicadornombre) {
        this.tindicadornombre = tindicadornombre;
    }

    public String getTindicadordescripcion() {
        return tindicadordescripcion;
    }

    public void setTindicadordescripcion(String tindicadordescripcion) {
        this.tindicadordescripcion = tindicadordescripcion;
    }

    @XmlTransient
    public List<Tbaseconceptualindicador> getTbaseconceptualindicadorList() {
        return tbaseconceptualindicadorList;
    }

    public void setTbaseconceptualindicadorList(List<Tbaseconceptualindicador> tbaseconceptualindicadorList) {
        this.tbaseconceptualindicadorList = tbaseconceptualindicadorList;
    }

    public Tcriteriosubcriterio getTcriteriosubcriteriocodigo() {
        return tcriteriosubcriteriocodigo;
    }

    public void setTcriteriosubcriteriocodigo(Tcriteriosubcriterio tcriteriosubcriteriocodigo) {
        this.tcriteriosubcriteriocodigo = tcriteriosubcriteriocodigo;
    }

    @XmlTransient
    public List<Tcalificacion> getTcalificacionList() {
        return tcalificacionList;
    }

    public void setTcalificacionList(List<Tcalificacion> tcalificacionList) {
        this.tcalificacionList = tcalificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tindicadorcodigo != null ? tindicadorcodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tindicador)) {
            return false;
        }
        Tindicador other = (Tindicador) object;
        if ((this.tindicadorcodigo == null && other.tindicadorcodigo != null) || (this.tindicadorcodigo != null && !this.tindicadorcodigo.equals(other.tindicadorcodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tindicador[ tindicadorcodigo=" + tindicadorcodigo + " ]";
    }
    
}
