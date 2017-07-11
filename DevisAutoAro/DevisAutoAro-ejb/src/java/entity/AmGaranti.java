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
import javax.persistence.FetchType;
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
 * @author kiashi
 */
@Entity
@Table(name = "AM_GARANTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmGaranti.findAll", query = "SELECT a FROM AmGaranti a")
    , @NamedQuery(name = "AmGaranti.findByIdamgaranti", query = "SELECT a FROM AmGaranti a WHERE a.idamgaranti = :idamgaranti")
    , @NamedQuery(name = "AmGaranti.findByLibelle", query = "SELECT a FROM AmGaranti a WHERE a.libelle = :libelle")
    , @NamedQuery(name = "AmGaranti.findByCode", query = "SELECT a FROM AmGaranti a WHERE a.code = :code")})
public class AmGaranti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDAMGARANTI")
    private Integer idamgaranti;
    @Size(max = 150)
    @Column(name = "LIBELLE")
    private String libelle;
    @Size(max = 20)
    @Column(name = "CODE")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idamgaranti", fetch = FetchType.LAZY)
    private List<AmTauxgaranti> amTauxgarantiList;

    public AmGaranti() {
    }

    public AmGaranti(Integer idamgaranti) {
        this.idamgaranti = idamgaranti;
    }

    public Integer getIdamgaranti() {
        return idamgaranti;
    }

    public void setIdamgaranti(Integer idamgaranti) {
        this.idamgaranti = idamgaranti;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public List<AmTauxgaranti> getAmTauxgarantiList() {
        return amTauxgarantiList;
    }

    public void setAmTauxgarantiList(List<AmTauxgaranti> amTauxgarantiList) {
        this.amTauxgarantiList = amTauxgarantiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idamgaranti != null ? idamgaranti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmGaranti)) {
            return false;
        }
        AmGaranti other = (AmGaranti) object;
        if ((this.idamgaranti == null && other.idamgaranti != null) || (this.idamgaranti != null && !this.idamgaranti.equals(other.idamgaranti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AmGaranti[ idamgaranti=" + idamgaranti + " ]";
    }
    
}
