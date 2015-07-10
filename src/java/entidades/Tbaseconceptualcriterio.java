/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "tbaseconceptualcriterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbaseconceptualcriterio.findAll", query = "SELECT t FROM Tbaseconceptualcriterio t"),
    @NamedQuery(name = "Tbaseconceptualcriterio.findByTbaseconceptualcriteriocodigo", query = "SELECT t FROM Tbaseconceptualcriterio t WHERE t.tbaseconceptualcriteriocodigo = :tbaseconceptualcriteriocodigo"),
    @NamedQuery(name = "Tbaseconceptualcriterio.findByTbaseconceptualcriterionombre", query = "SELECT t FROM Tbaseconceptualcriterio t WHERE t.tbaseconceptualcriterionombre = :tbaseconceptualcriterionombre"),
    @NamedQuery(name = "Tbaseconceptualcriterio.findByTbaseconceptualcriteriodescripcion", query = "SELECT t FROM Tbaseconceptualcriterio t WHERE t.tbaseconceptualcriteriodescripcion = :tbaseconceptualcriteriodescripcion")})
public class Tbaseconceptualcriterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tbaseconceptualcriteriocodigo")
    private Long tbaseconceptualcriteriocodigo;
    @Size(max = 50)
    @Column(name = "tbaseconceptualcriterionombre")
    private String tbaseconceptualcriterionombre;
    @Size(max = 500)
    @Column(name = "tbaseconceptualcriteriodescripcion")
    private String tbaseconceptualcriteriodescripcion;
    @JoinColumn(name = "tcriteriosubcriteriocodigo", referencedColumnName = "tcriteriosubcriteriocodigo")
    @ManyToOne
    private Tcriteriosubcriterio tcriteriosubcriteriocodigo;

    public Tbaseconceptualcriterio() {
    }

    public Tbaseconceptualcriterio(Long tbaseconceptualcriteriocodigo) {
        this.tbaseconceptualcriteriocodigo = tbaseconceptualcriteriocodigo;
    }

    public Long getTbaseconceptualcriteriocodigo() {
        return tbaseconceptualcriteriocodigo;
    }

    public void setTbaseconceptualcriteriocodigo(Long tbaseconceptualcriteriocodigo) {
        this.tbaseconceptualcriteriocodigo = tbaseconceptualcriteriocodigo;
    }

    public String getTbaseconceptualcriterionombre() {
        return tbaseconceptualcriterionombre;
    }

    public void setTbaseconceptualcriterionombre(String tbaseconceptualcriterionombre) {
        this.tbaseconceptualcriterionombre = tbaseconceptualcriterionombre;
    }

    public String getTbaseconceptualcriteriodescripcion() {
        return tbaseconceptualcriteriodescripcion;
    }

    public void setTbaseconceptualcriteriodescripcion(String tbaseconceptualcriteriodescripcion) {
        this.tbaseconceptualcriteriodescripcion = tbaseconceptualcriteriodescripcion;
    }

    public Tcriteriosubcriterio getTcriteriosubcriteriocodigo() {
        return tcriteriosubcriteriocodigo;
    }

    public void setTcriteriosubcriteriocodigo(Tcriteriosubcriterio tcriteriosubcriteriocodigo) {
        this.tcriteriosubcriteriocodigo = tcriteriosubcriteriocodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbaseconceptualcriteriocodigo != null ? tbaseconceptualcriteriocodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbaseconceptualcriterio)) {
            return false;
        }
        Tbaseconceptualcriterio other = (Tbaseconceptualcriterio) object;
        if ((this.tbaseconceptualcriteriocodigo == null && other.tbaseconceptualcriteriocodigo != null) || (this.tbaseconceptualcriteriocodigo != null && !this.tbaseconceptualcriteriocodigo.equals(other.tbaseconceptualcriteriocodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tbaseconceptualcriterio[ tbaseconceptualcriteriocodigo=" + tbaseconceptualcriteriocodigo + " ]";
    }
    
}
