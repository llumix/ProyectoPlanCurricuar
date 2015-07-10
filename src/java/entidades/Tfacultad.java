/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "tfacultad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tfacultad.findAll", query = "SELECT t FROM Tfacultad t"),
    @NamedQuery(name = "Tfacultad.findByTfacultadcodigo", query = "SELECT t FROM Tfacultad t WHERE t.tfacultadcodigo = :tfacultadcodigo"),
    @NamedQuery(name = "Tfacultad.findByTfacultadnombre", query = "SELECT t FROM Tfacultad t WHERE t.tfacultadnombre = :tfacultadnombre")})
public class Tfacultad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tfacultadcodigo")
    private Long tfacultadcodigo;
    @Size(max = 50)
    @Column(name = "tfacultadnombre")
    private String tfacultadnombre;
    @JoinColumn(name = "tfacultadvicedecano", referencedColumnName = "tusuariocedula")
    @ManyToOne
    private Tusuario tfacultadvicedecano;
    @JoinColumn(name = "tfacultaddecano", referencedColumnName = "tusuariocedula")
    @ManyToOne
    private Tusuario tfacultaddecano;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tfacultad")
    private Tescuela tescuela;

    public Tfacultad() {
    }

    public Tfacultad(Long tfacultadcodigo) {
        this.tfacultadcodigo = tfacultadcodigo;
    }

    public Long getTfacultadcodigo() {
        return tfacultadcodigo;
    }

    public void setTfacultadcodigo(Long tfacultadcodigo) {
        this.tfacultadcodigo = tfacultadcodigo;
    }

    public String getTfacultadnombre() {
        return tfacultadnombre;
    }

    public void setTfacultadnombre(String tfacultadnombre) {
        this.tfacultadnombre = tfacultadnombre;
    }

    public Tusuario getTfacultadvicedecano() {
        return tfacultadvicedecano;
    }

    public void setTfacultadvicedecano(Tusuario tfacultadvicedecano) {
        this.tfacultadvicedecano = tfacultadvicedecano;
    }

    public Tusuario getTfacultaddecano() {
        return tfacultaddecano;
    }

    public void setTfacultaddecano(Tusuario tfacultaddecano) {
        this.tfacultaddecano = tfacultaddecano;
    }

    public Tescuela getTescuela() {
        return tescuela;
    }

    public void setTescuela(Tescuela tescuela) {
        this.tescuela = tescuela;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tfacultadcodigo != null ? tfacultadcodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tfacultad)) {
            return false;
        }
        Tfacultad other = (Tfacultad) object;
        if ((this.tfacultadcodigo == null && other.tfacultadcodigo != null) || (this.tfacultadcodigo != null && !this.tfacultadcodigo.equals(other.tfacultadcodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tfacultad[ tfacultadcodigo=" + tfacultadcodigo + " ]";
    }
    
}
