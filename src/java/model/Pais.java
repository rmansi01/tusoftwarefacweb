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
@Table(name = "pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")
    , @NamedQuery(name = "Pais.findByCPais", query = "SELECT p FROM Pais p WHERE p.cPais = :cPais")
    , @NamedQuery(name = "Pais.findByNombre", query = "SELECT p FROM Pais p WHERE p.nombre = :nombre")})
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "c_pais")
    private Integer cPais;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cPais")
    private Ciudad ciudad;

    public Pais() {
    }

    public Pais(Integer cPais) {
        this.cPais = cPais;
    }

    public Pais(Integer cPais, String nombre) {
        this.cPais = cPais;
        this.nombre = nombre;
    }

    public Integer getCPais() {
        return cPais;
    }

    public void setCPais(Integer cPais) {
        this.cPais = cPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPais != null ? cPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.cPais == null && other.cPais != null) || (this.cPais != null && !this.cPais.equals(other.cPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pais[ cPais=" + cPais + " ]";
    }
    
}
