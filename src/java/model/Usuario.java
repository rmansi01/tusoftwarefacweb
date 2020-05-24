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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByNif", query = "SELECT u FROM Usuario u WHERE u.nif = :nif")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")
    , @NamedQuery(name = "Usuario.findByFirstLogin", query = "SELECT u FROM Usuario u WHERE u.firstLogin = :firstLogin")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApe1", query = "SELECT u FROM Usuario u WHERE u.ape1 = :ape1")
    , @NamedQuery(name = "Usuario.findByApe2", query = "SELECT u FROM Usuario u WHERE u.ape2 = :ape2")
    , @NamedQuery(name = "Usuario.findByDir", query = "SELECT u FROM Usuario u WHERE u.dir = :dir")
    , @NamedQuery(name = "Usuario.findByTel", query = "SELECT u FROM Usuario u WHERE u.tel = :tel")
    , @NamedQuery(name = "Usuario.findByMail", query = "SELECT u FROM Usuario u WHERE u.mail = :mail")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nif")
    private Integer nif;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "first_login")
    private boolean firstLogin;
    @Basic(optional = false)
    @Column(name = "Nombre")
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
    @Column(name = "tel")
    private long tel;
    @Basic(optional = false)
    @Column(name = "mail")
    private String mail;
    @JoinColumn(name = "c_postal", referencedColumnName = "c_postal")
    @OneToOne(optional = false)
    private Ciudad cPostal;

    public Usuario() {
    }

    public Usuario(Integer nif) {
        this.nif = nif;
    }

    public Usuario(Integer nif, String password, boolean firstLogin, String nombre, String ape1, String dir, long tel, String mail) {
        this.nif = nif;
        this.password = password;
        this.firstLogin = firstLogin;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.dir = dir;
        this.tel = tel;
        this.mail = mail;
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
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

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nif != null ? nif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nif == null && other.nif != null) || (this.nif != null && !this.nif.equals(other.nif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuario[ nif=" + nif + " ]";
    }
    
}
