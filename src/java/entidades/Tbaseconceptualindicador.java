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
@Table(name = "tbaseconceptualindicador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbaseconceptualindicador.findAll", query = "SELECT t FROM Tbaseconceptualindicador t"),
    @NamedQuery(name = "Tbaseconceptualindicador.findByTbaseconceptualindicadorcodigo", query = "SELECT t FROM Tbaseconceptualindicador t WHERE t.tbaseconceptualindicadorcodigo = :tbaseconceptualindicadorcodigo"),
    @NamedQuery(name = "Tbaseconceptualindicador.findByTbaseconceptualindicadornombre", query = "SELECT t FROM Tbaseconceptualindicador t WHERE t.tbaseconceptualindicadornombre = :tbaseconceptualindicadornombre"),
    @NamedQuery(name = "Tbaseconceptualindicador.findByTbaseconceptualindicadordescripcion", query = "SELECT t FROM Tbaseconceptualindicador t WHERE t.tbaseconceptualindicadordescripcion = :tbaseconceptualindicadordescripcion")})
public class Tbaseconceptualindicador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tbaseconceptualindicadorcodigo")
    private Long tbaseconceptualindicadorcodigo;
    @Size(max = 50)
    @Column(name = "tbaseconceptualindicadornombre")
    private String tbaseconceptualindicadornombre;
    @Size(max = 500)
    @Column(name = "tbaseconceptualindicadordescripcion")
    private String tbaseconceptualindicadordescripcion;
    @JoinColumn(name = "tindicadorcodigo", referencedColumnName = "tindicadorcodigo")
    @ManyToOne
    private Tindicador tindicadorcodigo;

    public Tbaseconceptualindicador() {
    }

    public Tbaseconceptualindicador(Long tbaseconceptualindicadorcodigo) {
        this.tbaseconceptualindicadorcodigo = tbaseconceptualindicadorcodigo;
    }

    public Long getTbaseconceptualindicadorcodigo() {
        return tbaseconceptualindicadorcodigo;
    }

    public void setTbaseconceptualindicadorcodigo(Long tbaseconceptualindicadorcodigo) {
        this.tbaseconceptualindicadorcodigo = tbaseconceptualindicadorcodigo;
    }

    public String getTbaseconceptualindicadornombre() {
        return tbaseconceptualindicadornombre;
    }

    public void setTbaseconceptualindicadornombre(String tbaseconceptualindicadornombre) {
        this.tbaseconceptualindicadornombre = tbaseconceptualindicadornombre;
    }

    public String getTbaseconceptualindicadordescripcion() {
        return tbaseconceptualindicadordescripcion;
    }

    public void setTbaseconceptualindicadordescripcion(String tbaseconceptualindicadordescripcion) {
        this.tbaseconceptualindicadordescripcion = tbaseconceptualindicadordescripcion;
    }

    public Tindicador getTindicadorcodigo() {
        return tindicadorcodigo;
    }

    public void setTindicadorcodigo(Tindicador tindicadorcodigo) {
        this.tindicadorcodigo = tindicadorcodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbaseconceptualindicadorcodigo != null ? tbaseconceptualindicadorcodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbaseconceptualindicador)) {
            return false;
        }
        Tbaseconceptualindicador other = (Tbaseconceptualindicador) object;
        if ((this.tbaseconceptualindicadorcodigo == null && other.tbaseconceptualindicadorcodigo != null) || (this.tbaseconceptualindicadorcodigo != null && !this.tbaseconceptualindicadorcodigo.equals(other.tbaseconceptualindicadorcodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tbaseconceptualindicador[ tbaseconceptualindicadorcodigo=" + tbaseconceptualindicadorcodigo + " ]";
    }
    
}
