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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raúl Mansilla
 */
@Entity
@Table(name = "atributo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atributo.findAll", query = "SELECT a FROM Atributo a")
    , @NamedQuery(name = "Atributo.findByCAtributo", query = "SELECT a FROM Atributo a WHERE a.cAtributo = :cAtributo")
    , @NamedQuery(name = "Atributo.findByNombre", query = "SELECT a FROM Atributo a WHERE a.nombre = :nombre")})
public class Atributo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_atributo")
    private Integer cAtributo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cAtributo")
    private List<Articulo> articuloList;
    @JoinColumn(name = "c_valor", referencedColumnName = "c_valor")
    @ManyToOne(optional = false)
    private Valor cValor;

    public Atributo() {
    }

    public Atributo(Integer cAtributo) {
        this.cAtributo = cAtributo;
    }

    public Atributo(Integer cAtributo, String nombre) {
        this.cAtributo = cAtributo;
        this.nombre = nombre;
    }

    public Integer getCAtributo() {
        return cAtributo;
    }

    public void setCAtributo(Integer cAtributo) {
        this.cAtributo = cAtributo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

    public Valor getCValor() {
        return cValor;
    }

    public void setCValor(Valor cValor) {
        this.cValor = cValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cAtributo != null ? cAtributo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atributo)) {
            return false;
        }
        Atributo other = (Atributo) object;
        if ((this.cAtributo == null && other.cAtributo != null) || (this.cAtributo != null && !this.cAtributo.equals(other.cAtributo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Atributo[ cAtributo=" + cAtributo + " ]";
    }
    
}
