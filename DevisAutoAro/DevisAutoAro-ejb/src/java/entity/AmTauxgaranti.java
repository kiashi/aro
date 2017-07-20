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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Misaina
 */
@Entity
@Table(name = "AM_TAUXGARANTI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmTauxgaranti.findAll", query = "SELECT a FROM AmTauxgaranti a")
    , @NamedQuery(name = "AmTauxgaranti.findById", query = "SELECT a FROM AmTauxgaranti a WHERE a.id = :id")
    , @NamedQuery(name = "AmTauxgaranti.findByLibelle", query = "SELECT a FROM AmTauxgaranti a WHERE a.libelle = :libelle")
    , @NamedQuery(name = "AmTauxgaranti.findByTaux", query = "SELECT a FROM AmTauxgaranti a WHERE a.taux = :taux")})
public class AmTauxgaranti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 150)
    @Column(name = "LIBELLE")
    private String libelle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAUX")
    private Double taux;
    @JoinColumn(name = "AM_CATEGORIETARIFAIRE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AmCategorietarifaire amCategorietarifaire;
    @JoinColumn(name = "AM_GARANTI_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AmGaranti amGaranti;

    public AmTauxgaranti() {
    }

    public AmTauxgaranti(Integer id) {
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

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public AmCategorietarifaire getAmCategorietarifaire() {
        return amCategorietarifaire;
    }

    public void setAmCategorietarifaire(AmCategorietarifaire amCategorietarifaire) {
        this.amCategorietarifaire = amCategorietarifaire;
    }

    public AmGaranti getAmGaranti() {
        return amGaranti;
    }

    public void setAmGaranti(AmGaranti amGaranti) {
        this.amGaranti = amGaranti;
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
        if (!(object instanceof AmTauxgaranti)) {
            return false;
        }
        AmTauxgaranti other = (AmTauxgaranti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AmTauxgaranti[ id=" + id + " ]";
    }
    
}
