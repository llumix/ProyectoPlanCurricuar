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
@Table(name = "tmarcolegal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmarcolegal.findAll", query = "SELECT t FROM Tmarcolegal t"),
    @NamedQuery(name = "Tmarcolegal.findByTmarcolegalcodigo", query = "SELECT t FROM Tmarcolegal t WHERE t.tmarcolegalcodigo = :tmarcolegalcodigo"),
    @NamedQuery(name = "Tmarcolegal.findByTmarcolegaldescripcion", query = "SELECT t FROM Tmarcolegal t WHERE t.tmarcolegaldescripcion = :tmarcolegaldescripcion")})
public class Tmarcolegal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tmarcolegalcodigo")
    private Long tmarcolegalcodigo;
    @Size(max = 500)
    @Column(name = "tmarcolegaldescripcion")
    private String tmarcolegaldescripcion;
    @JoinColumn(name = "tcriteriosubcriteriocodigo", referencedColumnName = "tcriteriosubcriteriocodigo")
    @ManyToOne
    private Tcriteriosubcriterio tcriteriosubcriteriocodigo;

    public Tmarcolegal() {
    }

    public Tmarcolegal(Long tmarcolegalcodigo) {
        this.tmarcolegalcodigo = tmarcolegalcodigo;
    }

    public Long getTmarcolegalcodigo() {
        return tmarcolegalcodigo;
    }

    public void setTmarcolegalcodigo(Long tmarcolegalcodigo) {
        this.tmarcolegalcodigo = tmarcolegalcodigo;
    }

    public String getTmarcolegaldescripcion() {
        return tmarcolegaldescripcion;
    }

    public void setTmarcolegaldescripcion(String tmarcolegaldescripcion) {
        this.tmarcolegaldescripcion = tmarcolegaldescripcion;
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
        hash += (tmarcolegalcodigo != null ? tmarcolegalcodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tmarcolegal)) {
            return false;
        }
        Tmarcolegal other = (Tmarcolegal) object;
        if ((this.tmarcolegalcodigo == null && other.tmarcolegalcodigo != null) || (this.tmarcolegalcodigo != null && !this.tmarcolegalcodigo.equals(other.tmarcolegalcodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tmarcolegal[ tmarcolegalcodigo=" + tmarcolegalcodigo + " ]";
    }
    
}
