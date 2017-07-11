/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kiashi
 */
@Entity
@Table(name = "AM_TAUXGARANTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmTauxgaranti.findAll", query = "SELECT a FROM AmTauxgaranti a")
    , @NamedQuery(name = "AmTauxgaranti.findByIdgaranti", query = "SELECT a FROM AmTauxgaranti a WHERE a.idgaranti = :idgaranti")
    , @NamedQuery(name = "AmTauxgaranti.findByLibelle", query = "SELECT a FROM AmTauxgaranti a WHERE a.libelle = :libelle")
    , @NamedQuery(name = "AmTauxgaranti.findByTaux", query = "SELECT a FROM AmTauxgaranti a WHERE a.taux = :taux")})
public class AmTauxgaranti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDGARANTI")
    private Integer idgaranti;
    @Size(max = 150)
    @Column(name = "LIBELLE")
    private String libelle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAUX")
    private Double taux;
    @JoinColumn(name = "IDCODETARIFAIRE", referencedColumnName = "IDCODETARIFAIRE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AmCategorietarifaire idcodetarifaire;
    @JoinColumn(name = "IDAMGARANTI", referencedColumnName = "IDAMGARANTI")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AmGaranti idamgaranti;

    public AmTauxgaranti() {
    }

    public AmTauxgaranti(Integer idgaranti) {
        this.idgaranti = idgaranti;
    }

    public Integer getIdgaranti() {
        return idgaranti;
    }

    public void setIdgaranti(Integer idgaranti) {
        this.idgaranti = idgaranti;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public AmCategorietarifaire getIdcodetarifaire() {
        return idcodetarifaire;
    }

    public void setIdcodetarifaire(AmCategorietarifaire idcodetarifaire) {
        this.idcodetarifaire = idcodetarifaire;
    }

    public AmGaranti getIdamgaranti() {
        return idamgaranti;
    }

    public void setIdamgaranti(AmGaranti idamgaranti) {
        this.idamgaranti = idamgaranti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgaranti != null ? idgaranti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmTauxgaranti)) {
            return false;
        }
        AmTauxgaranti other = (AmTauxgaranti) object;
        if ((this.idgaranti == null && other.idgaranti != null) || (this.idgaranti != null && !this.idgaranti.equals(other.idgaranti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AmTauxgaranti[ idgaranti=" + idgaranti + " ]";
    }
    
}
