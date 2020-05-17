/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paula
 */
@Entity
@Table(name = "articulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
    , @NamedQuery(name = "Articulo.findById", query = "SELECT a FROM Articulo a WHERE a.id = :id")
    , @NamedQuery(name = "Articulo.findByNombre", query = "SELECT a FROM Articulo a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Articulo.findByRef", query = "SELECT a FROM Articulo a WHERE a.ref = :ref")
    , @NamedQuery(name = "Articulo.findByStock", query = "SELECT a FROM Articulo a WHERE a.stock = :stock")
    , @NamedQuery(name = "Articulo.findByCost", query = "SELECT a FROM Articulo a WHERE a.cost = :cost")
    , @NamedQuery(name = "Articulo.findByPvp", query = "SELECT a FROM Articulo a WHERE a.pvp = :pvp")
    , @NamedQuery(name = "Articulo.findByImg", query = "SELECT a FROM Articulo a WHERE a.img = :img")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Column(name = "descripcion_larga")
    private String descripcionLarga;
    @Basic(optional = false)
    @Column(name = "ref")
    private long ref;
    @Basic(optional = false)
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @Column(name = "cost")
    private long cost;
    @Basic(optional = false)
    @Column(name = "pvp")
    private long pvp;
    @Column(name = "img")
    private String img;
    @JoinColumn(name = "c_atributo", referencedColumnName = "c_atributo")
    @ManyToOne(optional = false)
    private Atributo cAtributo;
    @JoinColumn(name = "c_categoria", referencedColumnName = "c_categoria")
    @ManyToOne(optional = false)
    private Categoria cCategoria;
    @JoinColumn(name = "c_marca", referencedColumnName = "c_marca")
    @ManyToOne(optional = false)
    private Marca cMarca;

    public Articulo() {
    }

    public Articulo(Integer id) {
        this.id = id;
    }

    public Articulo(Integer id, String nombre, long ref, int stock, long cost, long pvp) {
        this.id = id;
        this.nombre = nombre;
        this.ref = ref;
        this.stock = stock;
        this.cost = cost;
        this.pvp = pvp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public long getRef() {
        return ref;
    }

    public void setRef(long ref) {
        this.ref = ref;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getPvp() {
        return pvp;
    }

    public void setPvp(long pvp) {
        this.pvp = pvp;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Atributo getCAtributo() {
        return cAtributo;
    }

    public void setCAtributo(Atributo cAtributo) {
        this.cAtributo = cAtributo;
    }

    public Categoria getCCategoria() {
        return cCategoria;
    }

    public void setCCategoria(Categoria cCategoria) {
        this.cCategoria = cCategoria;
    }

    public Marca getCMarca() {
        return cMarca;
    }

    public void setCMarca(Marca cMarca) {
        this.cMarca = cMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Articulo[ id=" + id + " ]";
    }
    
}
