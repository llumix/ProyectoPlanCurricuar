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
@Table(name = "tevidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tevidencia.findAll", query = "SELECT t FROM Tevidencia t"),
    @NamedQuery(name = "Tevidencia.findByTevidenciacodigo", query = "SELECT t FROM Tevidencia t WHERE t.tevidenciacodigo = :tevidenciacodigo"),
    @NamedQuery(name = "Tevidencia.findByTevidencianombre", query = "SELECT t FROM Tevidencia t WHERE t.tevidencianombre = :tevidencianombre"),
    @NamedQuery(name = "Tevidencia.findByTevidenciaruta", query = "SELECT t FROM Tevidencia t WHERE t.tevidenciaruta = :tevidenciaruta")})
public class Tevidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tevidenciacodigo")
    private Long tevidenciacodigo;
    @Size(max = 50)
    @Column(name = "tevidencianombre")
    private String tevidencianombre;
    @Size(max = 100)
    @Column(name = "tevidenciaruta")
    private String tevidenciaruta;
    @JoinColumn(name = "tcalificacioncodigo", referencedColumnName = "tcalificacioncodigo")
    @ManyToOne
    private Tcalificacion tcalificacioncodigo;

    public Tevidencia() {
    }

    public Tevidencia(Long tevidenciacodigo) {
        this.tevidenciacodigo = tevidenciacodigo;
    }

    public Long getTevidenciacodigo() {
        return tevidenciacodigo;
    }

    public void setTevidenciacodigo(Long tevidenciacodigo) {
        this.tevidenciacodigo = tevidenciacodigo;
    }

    public String getTevidencianombre() {
        return tevidencianombre;
    }

    public void setTevidencianombre(String tevidencianombre) {
        this.tevidencianombre = tevidencianombre;
    }

    public String getTevidenciaruta() {
        return tevidenciaruta;
    }

    public void setTevidenciaruta(String tevidenciaruta) {
        this.tevidenciaruta = tevidenciaruta;
    }

    public Tcalificacion getTcalificacioncodigo() {
        return tcalificacioncodigo;
    }

    public void setTcalificacioncodigo(Tcalificacion tcalificacioncodigo) {
        this.tcalificacioncodigo = tcalificacioncodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tevidenciacodigo != null ? tevidenciacodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tevidencia)) {
            return false;
        }
        Tevidencia other = (Tevidencia) object;
        if ((this.tevidenciacodigo == null && other.tevidenciacodigo != null) || (this.tevidenciacodigo != null && !this.tevidenciacodigo.equals(other.tevidenciacodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tevidencia[ tevidenciacodigo=" + tevidenciacodigo + " ]";
    }
    
}
