/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SIN_SUIVI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SinSuivi.findAll", query = "SELECT s FROM SinSuivi s")
    , @NamedQuery(name = "SinSuivi.findById", query = "SELECT s FROM SinSuivi s WHERE s.id = :id")
    , @NamedQuery(name = "SinSuivi.findByNoEtape", query = "SELECT s FROM SinSuivi s WHERE s.noEtape = :noEtape")
    , @NamedQuery(name = "SinSuivi.findByLibelle", query = "SELECT s FROM SinSuivi s WHERE s.libelle = :libelle")
    , @NamedQuery(name = "SinSuivi.findByFait", query = "SELECT s FROM SinSuivi s WHERE s.fait = :fait")
    , @NamedQuery(name = "SinSuivi.findByDescription", query = "SELECT s FROM SinSuivi s WHERE s.description = :description")})
public class SinSuivi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 5)
    @Column(name = "NO_ETAPE")
    private String noEtape;
    @Size(max = 60)
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "FAIT")
    private BigInteger fait;
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "AM_SINISTRE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AmSinistre amSinistre;

    public SinSuivi() {
    }

    public SinSuivi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoEtape() {
        return noEtape;
    }

    public void setNoEtape(String noEtape) {
        this.noEtape = noEtape;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigInteger getFait() {
        return fait;
    }

    public void setFait(BigInteger fait) {
        this.fait = fait;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AmSinistre getAmSinistre() {
        return amSinistre;
    }

    public void setAmSinistre(AmSinistre amSinistre) {
        this.amSinistre = amSinistre;
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
        if (!(object instanceof SinSuivi)) {
            return false;
        }
        SinSuivi other = (SinSuivi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SinSuivi[ id=" + id + " ]";
    }
    
}
