/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paula
 */
@Entity
@Table(name = "fra_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FraCompra.findAll", query = "SELECT f FROM FraCompra f")
    , @NamedQuery(name = "FraCompra.findByCFrac", query = "SELECT f FROM FraCompra f WHERE f.cFrac = :cFrac")
    , @NamedQuery(name = "FraCompra.findByTotal", query = "SELECT f FROM FraCompra f WHERE f.total = :total")
    , @NamedQuery(name = "FraCompra.findByFecha", query = "SELECT f FROM FraCompra f WHERE f.fecha = :fecha")})
public class FraCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_frac")
    private Integer cFrac;
    @Basic(optional = false)
    @Column(name = "total")
    private long total;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cFrac")
    private List<Movimiento> movimientoList;
    @JoinColumn(name = "c_proveedor", referencedColumnName = "c_proveedor")
    @OneToOne(optional = false)
    private Proveedor cProveedor;

    public FraCompra() {
    }

    public FraCompra(Integer cFrac) {
        this.cFrac = cFrac;
    }

    public FraCompra(Integer cFrac, long total, Date fecha) {
        this.cFrac = cFrac;
        this.total = total;
        this.fecha = fecha;
    }

    public Integer getCFrac() {
        return cFrac;
    }

    public void setCFrac(Integer cFrac) {
        this.cFrac = cFrac;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    public Proveedor getCProveedor() {
        return cProveedor;
    }

    public void setCProveedor(Proveedor cProveedor) {
        this.cProveedor = cProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cFrac != null ? cFrac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FraCompra)) {
            return false;
        }
        FraCompra other = (FraCompra) object;
        if ((this.cFrac == null && other.cFrac != null) || (this.cFrac != null && !this.cFrac.equals(other.cFrac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FraCompra[ cFrac=" + cFrac + " ]";
    }
    
}
