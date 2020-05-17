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
 * @author Paula
 */
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByCCategoria", query = "SELECT c FROM Categoria c WHERE c.cCategoria = :cCategoria")
    , @NamedQuery(name = "Categoria.findByNombre", query = "SELECT c FROM Categoria c WHERE c.nombre = :nombre")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_categoria")
    private Integer cCategoria;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "padre")
    private List<Categoria> categoriaList;
    @JoinColumn(name = "padre", referencedColumnName = "c_categoria")
    @ManyToOne(optional = false)
    private Categoria padre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cCategoria")
    private List<Articulo> articuloList;

    public Categoria() {
    }

    public Categoria(Integer cCategoria) {
        this.cCategoria = cCategoria;
    }

    public Categoria(Integer cCategoria, String nombre) {
        this.cCategoria = cCategoria;
        this.nombre = nombre;
    }

    public Integer getCCategoria() {
        return cCategoria;
    }

    public void setCCategoria(Integer cCategoria) {
        this.cCategoria = cCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public Categoria getPadre() {
        return padre;
    }

    public void setPadre(Categoria padre) {
        this.padre = padre;
    }

    @XmlTransient
    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCategoria != null ? cCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.cCategoria == null && other.cCategoria != null) || (this.cCategoria != null && !this.cCategoria.equals(other.cCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Categoria[ cCategoria=" + cCategoria + " ]";
    }
    
}
