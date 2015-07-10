/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "tperiodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tperiodo.findAll", query = "SELECT t FROM Tperiodo t"),
    @NamedQuery(name = "Tperiodo.findByTperiodocodigo", query = "SELECT t FROM Tperiodo t WHERE t.tperiodocodigo = :tperiodocodigo"),
    @NamedQuery(name = "Tperiodo.findByTperiododescripcion", query = "SELECT t FROM Tperiodo t WHERE t.tperiododescripcion = :tperiododescripcion"),
    @NamedQuery(name = "Tperiodo.findByTperiodofechainicio", query = "SELECT t FROM Tperiodo t WHERE t.tperiodofechainicio = :tperiodofechainicio"),
    @NamedQuery(name = "Tperiodo.findByTperiodofechafin", query = "SELECT t FROM Tperiodo t WHERE t.tperiodofechafin = :tperiodofechafin"),
    @NamedQuery(name = "Tperiodo.findByTperiodovigente", query = "SELECT t FROM Tperiodo t WHERE t.tperiodovigente = :tperiodovigente")})
public class Tperiodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tperiodocodigo")
    private Long tperiodocodigo;
    @Size(max = 50)
    @Column(name = "tperiododescripcion")
    private String tperiododescripcion;
    @Column(name = "tperiodofechainicio")
    @Temporal(TemporalType.DATE)
    private Date tperiodofechainicio;
    @Column(name = "tperiodofechafin")
    @Temporal(TemporalType.DATE)
    private Date tperiodofechafin;
    @Size(max = 20)
    @Column(name = "tperiodovigente")
    private String tperiodovigente;
    @OneToMany(mappedBy = "tperiodocodigo")
    private List<Tcarreraperiodo> tcarreraperiodoList;

    public Tperiodo() {
    }

    public Tperiodo(Long tperiodocodigo) {
        this.tperiodocodigo = tperiodocodigo;
    }

    public Long getTperiodocodigo() {
        return tperiodocodigo;
    }

    public void setTperiodocodigo(Long tperiodocodigo) {
        this.tperiodocodigo = tperiodocodigo;
    }

    public String getTperiododescripcion() {
        return tperiododescripcion;
    }

    public void setTperiododescripcion(String tperiododescripcion) {
        this.tperiododescripcion = tperiododescripcion;
    }

    public Date getTperiodofechainicio() {
        return tperiodofechainicio;
    }

    public void setTperiodofechainicio(Date tperiodofechainicio) {
        this.tperiodofechainicio = tperiodofechainicio;
    }

    public Date getTperiodofechafin() {
        return tperiodofechafin;
    }

    public void setTperiodofechafin(Date tperiodofechafin) {
        this.tperiodofechafin = tperiodofechafin;
    }

    public String getTperiodovigente() {
        return tperiodovigente;
    }

    public void setTperiodovigente(String tperiodovigente) {
        this.tperiodovigente = tperiodovigente;
    }

    @XmlTransient
    public List<Tcarreraperiodo> getTcarreraperiodoList() {
        return tcarreraperiodoList;
    }

    public void setTcarreraperiodoList(List<Tcarreraperiodo> tcarreraperiodoList) {
        this.tcarreraperiodoList = tcarreraperiodoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tperiodocodigo != null ? tperiodocodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tperiodo)) {
            return false;
        }
        Tperiodo other = (Tperiodo) object;
        if ((this.tperiodocodigo == null && other.tperiodocodigo != null) || (this.tperiodocodigo != null && !this.tperiodocodigo.equals(other.tperiodocodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tperiodo[ tperiodocodigo=" + tperiodocodigo + " ]";
    }
    
}
