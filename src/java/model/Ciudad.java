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
 * @author Raúl Mansilla
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByCPostal", query = "SELECT c FROM Ciudad c WHERE c.cPostal = :cPostal")
    , @NamedQuery(name = "Ciudad.findByNombre", query = "SELECT c FROM Ciudad c WHERE c.nombre = :nombre")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_postal")
    private Integer cPostal;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cPostal")
    private Cliente cliente;
    @JoinColumn(name = "c_pais", referencedColumnName = "c_pais")
    @OneToOne(optional = false)
    private Pais cPais;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cPostal")
    private Proveedor proveedor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cPostal")
    private Usuario usuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cPostal")
    private Empresa empresa;

    public Ciudad() {
    }

    public Ciudad(Integer cPostal) {
        this.cPostal = cPostal;
    }

    public Ciudad(Integer cPostal, String nombre) {
        this.cPostal = cPostal;
        this.nombre = nombre;
    }

    public Integer getCPostal() {
        return cPostal;
    }

    public void setCPostal(Integer cPostal) {
        this.cPostal = cPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pais getCPais() {
        return cPais;
    }

    public void setCPais(Pais cPais) {
        this.cPais = cPais;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPostal != null ? cPostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.cPostal == null && other.cPostal != null) || (this.cPostal != null && !this.cPostal.equals(other.cPostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ciudad[ cPostal=" + cPostal + " ]";
    }
    
}
