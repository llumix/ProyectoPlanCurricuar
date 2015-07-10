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
@Table(name = "tcarreraperiodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcarreraperiodo.findAll", query = "SELECT t FROM Tcarreraperiodo t"),
    @NamedQuery(name = "Tcarreraperiodo.findByTcarreraperiodocodigo", query = "SELECT t FROM Tcarreraperiodo t WHERE t.tcarreraperiodocodigo = :tcarreraperiodocodigo")})
public class Tcarreraperiodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcarreraperiodocodigo")
    private Long tcarreraperiodocodigo;
    @JoinColumn(name = "tperiodocodigo", referencedColumnName = "tperiodocodigo")
    @ManyToOne
    private Tperiodo tperiodocodigo;
    @JoinColumn(name = "tcarreracodigo", referencedColumnName = "tcarreracodigo")
    @ManyToOne
    private Tcarrera tcarreracodigo;

    public Tcarreraperiodo() {
    }

    public Tcarreraperiodo(Long tcarreraperiodocodigo) {
        this.tcarreraperiodocodigo = tcarreraperiodocodigo;
    }

    public Long getTcarreraperiodocodigo() {
        return tcarreraperiodocodigo;
    }

    public void setTcarreraperiodocodigo(Long tcarreraperiodocodigo) {
        this.tcarreraperiodocodigo = tcarreraperiodocodigo;
    }

    public Tperiodo getTperiodocodigo() {
        return tperiodocodigo;
    }

    public void setTperiodocodigo(Tperiodo tperiodocodigo) {
        this.tperiodocodigo = tperiodocodigo;
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
        hash += (tcarreraperiodocodigo != null ? tcarreraperiodocodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tcarreraperiodo)) {
            return false;
        }
        Tcarreraperiodo other = (Tcarreraperiodo) object;
        if ((this.tcarreraperiodocodigo == null && other.tcarreraperiodocodigo != null) || (this.tcarreraperiodocodigo != null && !this.tcarreraperiodocodigo.equals(other.tcarreraperiodocodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tcarreraperiodo[ tcarreraperiodocodigo=" + tcarreraperiodocodigo + " ]";
    }
    
}
