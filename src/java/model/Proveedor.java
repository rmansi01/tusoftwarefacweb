/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raúl Mansilla
 */
@Entity
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByCProveedor", query = "SELECT p FROM Proveedor p WHERE p.cProveedor = :cProveedor")
    , @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedor.findByDir", query = "SELECT p FROM Proveedor p WHERE p.dir = :dir")
    , @NamedQuery(name = "Proveedor.findByTelefono", query = "SELECT p FROM Proveedor p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Proveedor.findByMail", query = "SELECT p FROM Proveedor p WHERE p.mail = :mail")
    , @NamedQuery(name = "Proveedor.findByWeb", query = "SELECT p FROM Proveedor p WHERE p.web = :web")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_proveedor")
    private Integer cProveedor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "dir")
    private String dir;
    @Basic(optional = false)
    @Column(name = "telefono")
    private long telefono;
    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;
    @Column(name = "web")
    private String web;
    @Lob
    @Column(name = "observaciones")
    private String observaciones;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cProveedor")
    private FraCompra fraCompra;
    @JoinColumn(name = "c_postal", referencedColumnName = "c_postal")
    @OneToOne(optional = false)
    private Ciudad cPostal;

    public Proveedor() {
    }

    public Proveedor(Integer cProveedor) {
        this.cProveedor = cProveedor;
    }

    public Proveedor(Integer cProveedor, String nombre, String dir, long telefono, String mail) {
        this.cProveedor = cProveedor;
        this.nombre = nombre;
        this.dir = dir;
        this.telefono = telefono;
        this.mail = mail;
    }

    public Integer getCProveedor() {
        return cProveedor;
    }

    public void setCProveedor(Integer cProveedor) {
        this.cProveedor = cProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public FraCompra getFraCompra() {
        return fraCompra;
    }

    public void setFraCompra(FraCompra fraCompra) {
        this.fraCompra = fraCompra;
    }

    public Ciudad getCPostal() {
        return cPostal;
    }

    public void setCPostal(Ciudad cPostal) {
        this.cPostal = cPostal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cProveedor != null ? cProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.cProveedor == null && other.cProveedor != null) || (this.cProveedor != null && !this.cProveedor.equals(other.cProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Proveedor[ cProveedor=" + cProveedor + " ]";
    }
    
}
