/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paula
 */
@Entity
@Table(name = "valor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valor.findAll", query = "SELECT v FROM Valor v")
    , @NamedQuery(name = "Valor.findByCValor", query = "SELECT v FROM Valor v WHERE v.cValor = :cValor")
    , @NamedQuery(name = "Valor.findByNombre", query = "SELECT v FROM Valor v WHERE v.nombre = :nombre")})
public class Valor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_valor")
    private Integer cValor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cValor")
    private List<Atributo> atributoList;

    public Valor() {
    }

    public Valor(Integer cValor) {
        this.cValor = cValor;
    }

    public Valor(Integer cValor, String nombre) {
        this.cValor = cValor;
        this.nombre = nombre;
    }

    public Integer getCValor() {
        return cValor;
    }

    public void setCValor(Integer cValor) {
        this.cValor = cValor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Atributo> getAtributoList() {
        return atributoList;
    }

    public void setAtributoList(List<Atributo> atributoList) {
        this.atributoList = atributoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cValor != null ? cValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valor)) {
            return false;
        }
        Valor other = (Valor) object;
        if ((this.cValor == null && other.cValor != null) || (this.cValor != null && !this.cValor.equals(other.cValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Valor[ cValor=" + cValor + " ]";
    }
    
}
