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
@Table(name = "movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m")
    , @NamedQuery(name = "Movimiento.findByCMovimiento", query = "SELECT m FROM Movimiento m WHERE m.cMovimiento = :cMovimiento")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_movimiento")
    private Integer cMovimiento;
    @JoinColumn(name = "c_frac", referencedColumnName = "c_frac")
    @ManyToOne(optional = false)
    private FraCompra cFrac;
    @JoinColumn(name = "c_frav", referencedColumnName = "c_frav")
    @ManyToOne(optional = false)
    private FraVenta cFrav;

    public Movimiento() {
    }

    public Movimiento(Integer cMovimiento) {
        this.cMovimiento = cMovimiento;
    }

    public Integer getCMovimiento() {
        return cMovimiento;
    }

    public void setCMovimiento(Integer cMovimiento) {
        this.cMovimiento = cMovimiento;
    }

    public FraCompra getCFrac() {
        return cFrac;
    }

    public void setCFrac(FraCompra cFrac) {
        this.cFrac = cFrac;
    }

    public FraVenta getCFrav() {
        return cFrav;
    }

    public void setCFrav(FraVenta cFrav) {
        this.cFrav = cFrav;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cMovimiento != null ? cMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.cMovimiento == null && other.cMovimiento != null) || (this.cMovimiento != null && !this.cMovimiento.equals(other.cMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Movimiento[ cMovimiento=" + cMovimiento + " ]";
    }
    
}
