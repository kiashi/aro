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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kiashi
 */
@Entity
@Table(name = "AM_PRIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmPrime.findAll", query = "SELECT a FROM AmPrime a")
    , @NamedQuery(name = "AmPrime.findByIdprime", query = "SELECT a FROM AmPrime a WHERE a.idprime = :idprime")
    , @NamedQuery(name = "AmPrime.findBySourceenergie", query = "SELECT a FROM AmPrime a WHERE a.sourceenergie = :sourceenergie")
    , @NamedQuery(name = "AmPrime.findByPuissmin", query = "SELECT a FROM AmPrime a WHERE a.puissmin = :puissmin")
    , @NamedQuery(name = "AmPrime.findByPuissmax", query = "SELECT a FROM AmPrime a WHERE a.puissmax = :puissmax")
    , @NamedQuery(name = "AmPrime.findByPrimegratuit", query = "SELECT a FROM AmPrime a WHERE a.primegratuit = :primegratuit")
    , @NamedQuery(name = "AmPrime.findByPrimepayant", query = "SELECT a FROM AmPrime a WHERE a.primepayant = :primepayant")})
public class AmPrime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRIME")
    private Integer idprime;
    @Column(name = "SOURCEENERGIE")
    private String sourceenergie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PUISSMIN")
    private Double puissmin;
    @Column(name = "PUISSMAX")
    private Double puissmax;
    @Column(name = "PRIMEGRATUIT")
    private Double primegratuit;
    @Column(name = "PRIMEPAYANT")
    private Double primepayant;
    @JoinColumn(name = "IDCODETARIFAIRE", referencedColumnName = "IDCODETARIFAIRE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AmCategorietarifaire idcodetarifaire;

    public AmPrime() {
    }

    public AmPrime(Integer idprime) {
        this.idprime = idprime;
    }

    public Integer getIdprime() {
        return idprime;
    }

    public void setIdprime(Integer idprime) {
        this.idprime = idprime;
    }

    public String getSourceenergie() {
        return sourceenergie;
    }

    public void setSourceenergie(String sourceenergie) {
        this.sourceenergie = sourceenergie;
    }

    public Double getPuissmin() {
        return puissmin;
    }

    public void setPuissmin(Double puissmin) {
        this.puissmin = puissmin;
    }

    public Double getPuissmax() {
        return puissmax;
    }

    public void setPuissmax(Double puissmax) {
        this.puissmax = puissmax;
    }

    public Double getPrimegratuit() {
        return primegratuit;
    }

    public void setPrimegratuit(Double primegratuit) {
        this.primegratuit = primegratuit;
    }

    public Double getPrimepayant() {
        return primepayant;
    }

    public void setPrimepayant(Double primepayant) {
        this.primepayant = primepayant;
    }

    public AmCategorietarifaire getIdcodetarifaire() {
        return idcodetarifaire;
    }

    public void setIdcodetarifaire(AmCategorietarifaire idcodetarifaire) {
        this.idcodetarifaire = idcodetarifaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprime != null ? idprime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmPrime)) {
            return false;
        }
        AmPrime other = (AmPrime) object;
        if ((this.idprime == null && other.idprime != null) || (this.idprime != null && !this.idprime.equals(other.idprime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AmPrime[ idprime=" + idprime + " ]";
    }
    
}
