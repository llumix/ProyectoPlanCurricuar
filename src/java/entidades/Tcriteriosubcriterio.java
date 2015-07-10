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
@Table(name = "tcriteriosubcriterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcriteriosubcriterio.findAll", query = "SELECT t FROM Tcriteriosubcriterio t"),
    @NamedQuery(name = "Tcriteriosubcriterio.findByTcriteriosubcriteriocodigo", query = "SELECT t FROM Tcriteriosubcriterio t WHERE t.tcriteriosubcriteriocodigo = :tcriteriosubcriteriocodigo"),
    @NamedQuery(name = "Tcriteriosubcriterio.findByTcriteriosubcriterionombre", query = "SELECT t FROM Tcriteriosubcriterio t WHERE t.tcriteriosubcriterionombre = :tcriteriosubcriterionombre"),
    @NamedQuery(name = "Tcriteriosubcriterio.findByTcriteriosubcriteriodescripcion", query = "SELECT t FROM Tcriteriosubcriterio t WHERE t.tcriteriosubcriteriodescripcion = :tcriteriosubcriteriodescripcion")})
public class Tcriteriosubcriterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcriteriosubcriteriocodigo")
    private Long tcriteriosubcriteriocodigo;
    @Size(max = 50)
    @Column(name = "tcriteriosubcriterionombre")
    private String tcriteriosubcriterionombre;
    @Size(max = 500)
    @Column(name = "tcriteriosubcriteriodescripcion")
    private String tcriteriosubcriteriodescripcion;
    @OneToMany(mappedBy = "tcriteriosubcriteriocodigo")
    private List<Tbaseconceptualcriterio> tbaseconceptualcriterioList;
    @OneToMany(mappedBy = "tcriteriosubcriteriocodigo")
    private List<Tcarreracriteriosubcriterio> tcarreracriteriosubcriterioList;
    @OneToMany(mappedBy = "tcriteriosubcriteriocodigo")
    private List<Tindicador> tindicadorList;
    @OneToMany(mappedBy = "tcriteriosubcriteriocodigo")
    private List<Tmarcolegal> tmarcolegalList;

    public Tcriteriosubcriterio() {
    }

    public Tcriteriosubcriterio(Long tcriteriosubcriteriocodigo) {
        this.tcriteriosubcriteriocodigo = tcriteriosubcriteriocodigo;
    }

    public Long getTcriteriosubcriteriocodigo() {
        return tcriteriosubcriteriocodigo;
    }

    public void setTcriteriosubcriteriocodigo(Long tcriteriosubcriteriocodigo) {
        this.tcriteriosubcriteriocodigo = tcriteriosubcriteriocodigo;
    }

    public String getTcriteriosubcriterionombre() {
        return tcriteriosubcriterionombre;
    }

    public void setTcriteriosubcriterionombre(String tcriteriosubcriterionombre) {
        this.tcriteriosubcriterionombre = tcriteriosubcriterionombre;
    }

    public String getTcriteriosubcriteriodescripcion() {
        return tcriteriosubcriteriodescripcion;
    }

    public void setTcriteriosubcriteriodescripcion(String tcriteriosubcriteriodescripcion) {
        this.tcriteriosubcriteriodescripcion = tcriteriosubcriteriodescripcion;
    }

    @XmlTransient
    public List<Tbaseconceptualcriterio> getTbaseconceptualcriterioList() {
        return tbaseconceptualcriterioList;
    }

    public void setTbaseconceptualcriterioList(List<Tbaseconceptualcriterio> tbaseconceptualcriterioList) {
        this.tbaseconceptualcriterioList = tbaseconceptualcriterioList;
    }

    @XmlTransient
    public List<Tcarreracriteriosubcriterio> getTcarreracriteriosubcriterioList() {
        return tcarreracriteriosubcriterioList;
    }

    public void setTcarreracriteriosubcriterioList(List<Tcarreracriteriosubcriterio> tcarreracriteriosubcriterioList) {
        this.tcarreracriteriosubcriterioList = tcarreracriteriosubcriterioList;
    }

    @XmlTransient
    public List<Tindicador> getTindicadorList() {
        return tindicadorList;
    }

    public void setTindicadorList(List<Tindicador> tindicadorList) {
        this.tindicadorList = tindicadorList;
    }

    @XmlTransient
    public List<Tmarcolegal> getTmarcolegalList() {
        return tmarcolegalList;
    }

    public void setTmarcolegalList(List<Tmarcolegal> tmarcolegalList) {
        this.tmarcolegalList = tmarcolegalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcriteriosubcriteriocodigo != null ? tcriteriosubcriteriocodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tcriteriosubcriterio)) {
            return false;
        }
        Tcriteriosubcriterio other = (Tcriteriosubcriterio) object;
        if ((this.tcriteriosubcriteriocodigo == null && other.tcriteriosubcriteriocodigo != null) || (this.tcriteriosubcriteriocodigo != null && !this.tcriteriosubcriteriocodigo.equals(other.tcriteriosubcriteriocodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tcriteriosubcriterio[ tcriteriosubcriteriocodigo=" + tcriteriosubcriteriocodigo + " ]";
    }
    
}
