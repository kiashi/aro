/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Misaina
 */
@Entity
@Table(name = "CL_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClType.findAll", query = "SELECT c FROM ClType c")
    , @NamedQuery(name = "ClType.findById", query = "SELECT c FROM ClType c WHERE c.id = :id")
    , @NamedQuery(name = "ClType.findByLibelle", query = "SELECT c FROM ClType c WHERE c.libelle = :libelle")})
public class ClType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "LIBELLE")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clType")
    private List<Client> clientList;

    public ClType() {
    }

    public ClType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /*@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClType)) {
            return false;
        }
        ClType other = (ClType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "entity.ClType[ id=" + id + " ]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this.id == ((ClType) obj).id) {
            return true;
        } else {
            return false;
        }
    }
}
