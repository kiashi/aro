/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "AM_CODETARIFAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmCategorietarifaire.findAll", query = "SELECT a FROM AmCategorietarifaire a")
    , @NamedQuery(name = "AmCategorietarifaire.findByIdcodetarifaire", query = "SELECT a FROM AmCategorietarifaire a WHERE a.idcodetarifaire = :idcodetarifaire")
    , @NamedQuery(name = "AmCategorietarifaire.findByNomenclature", query = "SELECT a FROM AmCategorietarifaire a WHERE a.nomenclature = :nomenclature")
    , @NamedQuery(name = "AmCategorietarifaire.findByLibelle", query = "SELECT a FROM AmCategorietarifaire a WHERE a.libelle = :libelle")
    , @NamedQuery(name = "AmCategorietarifaire.findByNbrouesmin", query = "SELECT a FROM AmCategorietarifaire a WHERE a.nbrouesmin = :nbrouesmin")
    , @NamedQuery(name = "AmCategorietarifaire.findByNbrouesmax", query = "SELECT a FROM AmCategorietarifaire a WHERE a.nbrouesmax = :nbrouesmax")})
public class AmCategorietarifaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCODETARIFAIRE")
    private Integer idcodetarifaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMENCLATURE")
    private String nomenclature;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "NBROUESMIN")
    private BigInteger nbrouesmin;
    @Column(name = "NBROUESMAX")
    private BigInteger nbrouesmax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcodetarifaire", fetch = FetchType.LAZY)
    private List<AmPrime> amPrimeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcodetarifaire", fetch = FetchType.LAZY)
    private List<AmTauxgaranti> amTauxgarantiList;

    public AmCategorietarifaire() {
    }

    public AmCategorietarifaire(Integer idcodetarifaire) {
        this.idcodetarifaire = idcodetarifaire;
    }

    public AmCategorietarifaire(Integer idcodetarifaire, String nomenclature, String libelle) {
        this.idcodetarifaire = idcodetarifaire;
        this.nomenclature = nomenclature;
        this.libelle = libelle;
    }

    public Integer getIdcodetarifaire() {
        return idcodetarifaire;
    }

    public void setIdcodetarifaire(Integer idcodetarifaire) {
        this.idcodetarifaire = idcodetarifaire;
    }

    public String getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigInteger getNbrouesmin() {
        return nbrouesmin;
    }

    public void setNbrouesmin(BigInteger nbrouesmin) {
        this.nbrouesmin = nbrouesmin;
    }

    public BigInteger getNbrouesmax() {
        return nbrouesmax;
    }

    public void setNbrouesmax(BigInteger nbrouesmax) {
        this.nbrouesmax = nbrouesmax;
    }

    @XmlTransient
    public List<AmPrime> getAmPrimeList() {
        return amPrimeList;
    }

    public void setAmPrimeList(List<AmPrime> amPrimeList) {
        this.amPrimeList = amPrimeList;
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
        hash += (idcodetarifaire != null ? idcodetarifaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmCategorietarifaire)) {
            return false;
        }
        AmCategorietarifaire other = (AmCategorietarifaire) object;
        if ((this.idcodetarifaire == null && other.idcodetarifaire != null) || (this.idcodetarifaire != null && !this.idcodetarifaire.equals(other.idcodetarifaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AmCategorietarifaire[ idcodetarifaire=" + idcodetarifaire + " ]";
    }
    
}
