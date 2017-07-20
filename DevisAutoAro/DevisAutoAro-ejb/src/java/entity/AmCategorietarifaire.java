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
@Table(name = "AM_CATEGORIETARIFAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmCategorietarifaire.findAll", query = "SELECT a FROM AmCategorietarifaire a")
    , @NamedQuery(name = "AmCategorietarifaire.findById", query = "SELECT a FROM AmCategorietarifaire a WHERE a.id = :id")
    , @NamedQuery(name = "AmCategorietarifaire.findByNomenclature", query = "SELECT a FROM AmCategorietarifaire a WHERE a.nomenclature = :nomenclature")
    , @NamedQuery(name = "AmCategorietarifaire.findByLibelle", query = "SELECT a FROM AmCategorietarifaire a WHERE a.libelle = :libelle")
    , @NamedQuery(name = "AmCategorietarifaire.findByNbrouesmin", query = "SELECT a FROM AmCategorietarifaire a WHERE a.nbrouesmin = :nbrouesmin")
    , @NamedQuery(name = "AmCategorietarifaire.findByNbrouesmax", query = "SELECT a FROM AmCategorietarifaire a WHERE a.nbrouesmax = :nbrouesmax")
    , @NamedQuery(name = "AmCategorietarifaire.findByDescription", query = "SELECT a FROM AmCategorietarifaire a WHERE a.description = :description")})
public class AmCategorietarifaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMENCLATURE")
    private String nomenclature;
    @Size(max = 150)
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "NBROUESMIN")
    private BigInteger nbrouesmin;
    @Column(name = "NBROUESMAX")
    private BigInteger nbrouesmax;
    @Size(max = 400)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amCategorietarifaire")
    private List<AmTauxgaranti> amTauxgarantiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amCategorietarifaire")
    private List<AmPrime> amPrimeList;

    public AmCategorietarifaire() {
    }

    public AmCategorietarifaire(Integer id) {
        this.id = id;
    }

    public AmCategorietarifaire(Integer id, String nomenclature) {
        this.id = id;
        this.nomenclature = nomenclature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<AmTauxgaranti> getAmTauxgarantiList() {
        return amTauxgarantiList;
    }

    public void setAmTauxgarantiList(List<AmTauxgaranti> amTauxgarantiList) {
        this.amTauxgarantiList = amTauxgarantiList;
    }

    @XmlTransient
    public List<AmPrime> getAmPrimeList() {
        return amPrimeList;
    }

    public void setAmPrimeList(List<AmPrime> amPrimeList) {
        this.amPrimeList = amPrimeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmCategorietarifaire)) {
            return false;
        }
        AmCategorietarifaire other = (AmCategorietarifaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AmCategorietarifaire[ id=" + id + " ]";
    }
    
}
