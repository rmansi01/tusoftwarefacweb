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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paula
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByNifcif", query = "SELECT c FROM Cliente c WHERE c.nifcif = :nifcif")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByApe1", query = "SELECT c FROM Cliente c WHERE c.ape1 = :ape1")
    , @NamedQuery(name = "Cliente.findByApe2", query = "SELECT c FROM Cliente c WHERE c.ape2 = :ape2")
    , @NamedQuery(name = "Cliente.findByDir", query = "SELECT c FROM Cliente c WHERE c.dir = :dir")
    , @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Cliente.findByMail", query = "SELECT c FROM Cliente c WHERE c.mail = :mail")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nifcif")
    private String nifcif;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ape1")
    private String ape1;
    @Column(name = "ape2")
    private String ape2;
    @Basic(optional = false)
    @Column(name = "dir")
    private String dir;
    @Basic(optional = false)
    @Column(name = "telefono")
    private long telefono;
    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;
    @JoinColumn(name = "c_postal", referencedColumnName = "c_postal")
    @OneToOne(optional = false)
    private Ciudad cPostal;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "nifcif")
    private FraVenta fraVenta;

    public Cliente() {
    }

    public Cliente(String nifcif) {
        this.nifcif = nifcif;
    }

    public Cliente(String nifcif, String nombre, String ape1, String dir, long telefono, String mail) {
        this.nifcif = nifcif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.dir = dir;
        this.telefono = telefono;
        this.mail = mail;
    }

    public String getNifcif() {
        return nifcif;
    }

    public void setNifcif(String nifcif) {
        this.nifcif = nifcif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
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

    public Ciudad getCPostal() {
        return cPostal;
    }

    public void setCPostal(Ciudad cPostal) {
        this.cPostal = cPostal;
    }

    public FraVenta getFraVenta() {
        return fraVenta;
    }

    public void setFraVenta(FraVenta fraVenta) {
        this.fraVenta = fraVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nifcif != null ? nifcif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.nifcif == null && other.nifcif != null) || (this.nifcif != null && !this.nifcif.equals(other.nifcif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cliente[ nifcif=" + nifcif + " ]";
    }
    
}
