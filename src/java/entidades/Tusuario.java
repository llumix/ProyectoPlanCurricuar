/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "tusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tusuario.findAll", query = "SELECT t FROM Tusuario t"),
    @NamedQuery(name = "Tusuario.findByTusuariocedula", query = "SELECT t FROM Tusuario t WHERE t.tusuariocedula = :tusuariocedula"),
    @NamedQuery(name = "Tusuario.findByTusuariopassword", query = "SELECT t FROM Tusuario t WHERE t.tusuariopassword = :tusuariopassword")})
public class Tusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tusuariocedula")
    private String tusuariocedula;
    @Size(max = 20)
    @Column(name = "tusuariopassword")
    private String tusuariopassword;
    @JoinColumn(name = "ttipocodigo", referencedColumnName = "ttipocodigo")
    @ManyToOne
    private Ttipo ttipocodigo;
    @OneToMany(mappedBy = "tfacultadvicedecano")
    private List<Tfacultad> tfacultadList;
    @OneToMany(mappedBy = "tfacultaddecano")
    private List<Tfacultad> tfacultadList1;
    @OneToMany(mappedBy = "tusuariocedula")
    private List<Tcalificacion> tcalificacionList;
    @OneToMany(mappedBy = "tescueladirector")
    private List<Tescuela> tescuelaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tusuario")
    private Tpersona tpersona;

    public Tusuario() {
    }

    public Tusuario(String tusuariocedula) {
        this.tusuariocedula = tusuariocedula;
    }

    public String getTusuariocedula() {
        return tusuariocedula;
    }

    public void setTusuariocedula(String tusuariocedula) {
        this.tusuariocedula = tusuariocedula;
    }

    public String getTusuariopassword() {
        return tusuariopassword;
    }

    public void setTusuariopassword(String tusuariopassword) {
        this.tusuariopassword = tusuariopassword;
    }

    public Ttipo getTtipocodigo() {
        return ttipocodigo;
    }

    public void setTtipocodigo(Ttipo ttipocodigo) {
        this.ttipocodigo = ttipocodigo;
    }

    @XmlTransient
    public List<Tfacultad> getTfacultadList() {
        return tfacultadList;
    }

    public void setTfacultadList(List<Tfacultad> tfacultadList) {
        this.tfacultadList = tfacultadList;
    }

    @XmlTransient
    public List<Tfacultad> getTfacultadList1() {
        return tfacultadList1;
    }

    public void setTfacultadList1(List<Tfacultad> tfacultadList1) {
        this.tfacultadList1 = tfacultadList1;
    }

    @XmlTransient
    public List<Tcalificacion> getTcalificacionList() {
        return tcalificacionList;
    }

    public void setTcalificacionList(List<Tcalificacion> tcalificacionList) {
        this.tcalificacionList = tcalificacionList;
    }

    @XmlTransient
    public List<Tescuela> getTescuelaList() {
        return tescuelaList;
    }

    public void setTescuelaList(List<Tescuela> tescuelaList) {
        this.tescuelaList = tescuelaList;
    }

    public Tpersona getTpersona() {
        return tpersona;
    }

    public void setTpersona(Tpersona tpersona) {
        this.tpersona = tpersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tusuariocedula != null ? tusuariocedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tusuario)) {
            return false;
        }
        Tusuario other = (Tusuario) object;
        if ((this.tusuariocedula == null && other.tusuariocedula != null) || (this.tusuariocedula != null && !this.tusuariocedula.equals(other.tusuariocedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tusuario[ tusuariocedula=" + tusuariocedula + " ]";
    }
    
}
