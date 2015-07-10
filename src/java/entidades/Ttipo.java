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
@Table(name = "ttipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ttipo.findAll", query = "SELECT t FROM Ttipo t"),
    @NamedQuery(name = "Ttipo.findByTtipocodigo", query = "SELECT t FROM Ttipo t WHERE t.ttipocodigo = :ttipocodigo"),
    @NamedQuery(name = "Ttipo.findByTtipodescripcion", query = "SELECT t FROM Ttipo t WHERE t.ttipodescripcion = :ttipodescripcion")})
public class Ttipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ttipocodigo")
    private Long ttipocodigo;
    @Size(max = 20)
    @Column(name = "ttipodescripcion")
    private String ttipodescripcion;
    @OneToMany(mappedBy = "ttipocodigo")
    private List<Tusuario> tusuarioList;

    public Ttipo() {
    }

    public Ttipo(Long ttipocodigo) {
        this.ttipocodigo = ttipocodigo;
    }

    public Long getTtipocodigo() {
        return ttipocodigo;
    }

    public void setTtipocodigo(Long ttipocodigo) {
        this.ttipocodigo = ttipocodigo;
    }

    public String getTtipodescripcion() {
        return ttipodescripcion;
    }

    public void setTtipodescripcion(String ttipodescripcion) {
        this.ttipodescripcion = ttipodescripcion;
    }

    @XmlTransient
    public List<Tusuario> getTusuarioList() {
        return tusuarioList;
    }

    public void setTusuarioList(List<Tusuario> tusuarioList) {
        this.tusuarioList = tusuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttipocodigo != null ? ttipocodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ttipo)) {
            return false;
        }
        Ttipo other = (Ttipo) object;
        if ((this.ttipocodigo == null && other.ttipocodigo != null) || (this.ttipocodigo != null && !this.ttipocodigo.equals(other.ttipocodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Ttipo[ ttipocodigo=" + ttipocodigo + " ]";
    }
    
}
