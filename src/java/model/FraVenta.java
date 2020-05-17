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
@Table(name = "fra_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FraVenta.findAll", query = "SELECT f FROM FraVenta f")
    , @NamedQuery(name = "FraVenta.findByTotal", query = "SELECT f FROM FraVenta f WHERE f.total = :total")
    , @NamedQuery(name = "FraVenta.findByFecha", query = "SELECT f FROM FraVenta f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "FraVenta.findByCFrav", query = "SELECT f FROM FraVenta f WHERE f.cFrav = :cFrav")})
public class FraVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "total")
    private long total;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "c_frav")
    private Integer cFrav;
    @JoinColumn(name = "nifcif", referencedColumnName = "nifcif")
    @OneToOne(optional = false)
    private Cliente nifcif;
    @JoinColumn(name = "nif", referencedColumnName = "nif")
    @OneToOne(optional = false)
    private Usuario nif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cFrav")
    private List<Movimiento> movimientoList;

    public FraVenta() {
    }

    public FraVenta(Integer cFrav) {
        this.cFrav = cFrav;
    }

    public FraVenta(Integer cFrav, long total, Date fecha) {
        this.cFrav = cFrav;
        this.total = total;
        this.fecha = fecha;
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

    public Integer getCFrav() {
        return cFrav;
    }

    public void setCFrav(Integer cFrav) {
        this.cFrav = cFrav;
    }

    public Cliente getNifcif() {
        return nifcif;
    }

    public void setNifcif(Cliente nifcif) {
        this.nifcif = nifcif;
    }

    public Usuario getNif() {
        return nif;
    }

    public void setNif(Usuario nif) {
        this.nif = nif;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cFrav != null ? cFrav.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FraVenta)) {
            return false;
        }
        FraVenta other = (FraVenta) object;
        if ((this.cFrav == null && other.cFrav != null) || (this.cFrav != null && !this.cFrav.equals(other.cFrav))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FraVenta[ cFrav=" + cFrav + " ]";
    }
    
}
