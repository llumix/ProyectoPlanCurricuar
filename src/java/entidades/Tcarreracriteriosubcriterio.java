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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "tcarreracriteriosubcriterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcarreracriteriosubcriterio.findAll", query = "SELECT t FROM Tcarreracriteriosubcriterio t"),
    @NamedQuery(name = "Tcarreracriteriosubcriterio.findByTcarreracriteriosubcriteriocodigo", query = "SELECT t FROM Tcarreracriteriosubcriterio t WHERE t.tcarreracriteriosubcriteriocodigo = :tcarreracriteriosubcriteriocodigo")})
public class Tcarreracriteriosubcriterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcarreracriteriosubcriteriocodigo")
    private Long tcarreracriteriosubcriteriocodigo;
    @JoinColumn(name = "tcriteriosubcriteriocodigo", referencedColumnName = "tcriteriosubcriteriocodigo")
    @ManyToOne
    private Tcriteriosubcriterio tcriteriosubcriteriocodigo;
    @JoinColumn(name = "tcarreracodigo", referencedColumnName = "tcarreracodigo")
    @ManyToOne
    private Tcarrera tcarreracodigo;

    public Tcarreracriteriosubcriterio() {
    }

    public Tcarreracriteriosubcriterio(Long tcarreracriteriosubcriteriocodigo) {
        this.tcarreracriteriosubcriteriocodigo = tcarreracriteriosubcriteriocodigo;
    }

    public Long getTcarreracriteriosubcriteriocodigo() {
        return tcarreracriteriosubcriteriocodigo;
    }

    public void setTcarreracriteriosubcriteriocodigo(Long tcarreracriteriosubcriteriocodigo) {
        this.tcarreracriteriosubcriteriocodigo = tcarreracriteriosubcriteriocodigo;
    }

    public Tcriteriosubcriterio getTcriteriosubcriteriocodigo() {
        return tcriteriosubcriteriocodigo;
    }

    public void setTcriteriosubcriteriocodigo(Tcriteriosubcriterio tcriteriosubcriteriocodigo) {
        this.tcriteriosubcriteriocodigo = tcriteriosubcriteriocodigo;
    }

    public Tcarrera getTcarreracodigo() {
        return tcarreracodigo;
    }

    public void setTcarreracodigo(Tcarrera tcarreracodigo) {
        this.tcarreracodigo = tcarreracodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcarreracriteriosubcriteriocodigo != null ? tcarreracriteriosubcriteriocodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tcarreracriteriosubcriterio)) {
            return false;
        }
        Tcarreracriteriosubcriterio other = (Tcarreracriteriosubcriterio) object;
        if ((this.tcarreracriteriosubcriteriocodigo == null && other.tcarreracriteriosubcriteriocodigo != null) || (this.tcarreracriteriosubcriteriocodigo != null && !this.tcarreracriteriosubcriteriocodigo.equals(other.tcarreracriteriosubcriteriocodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tcarreracriteriosubcriterio[ tcarreracriteriosubcriteriocodigo=" + tcarreracriteriosubcriteriocodigo + " ]";
    }
    
}
