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
@Table(name = "AM_PRIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmPrime.findAll", query = "SELECT a FROM AmPrime a")
    , @NamedQuery(name = "AmPrime.findById", query = "SELECT a FROM AmPrime a WHERE a.id = :id")
    , @NamedQuery(name = "AmPrime.findBySourceenergie", query = "SELECT a FROM AmPrime a WHERE a.sourceenergie = :sourceenergie")
    , @NamedQuery(name = "AmPrime.findByPuissmin", query = "SELECT a FROM AmPrime a WHERE a.puissmin = :puissmin")
    , @NamedQuery(name = "AmPrime.findByPuissmax", query = "SELECT a FROM AmPrime a WHERE a.puissmax = :puissmax")
    , @NamedQuery(name = "AmPrime.findByPrimegratuit", query = "SELECT a FROM AmPrime a WHERE a.primegratuit = :primegratuit")
    , @NamedQuery(name = "AmPrime.findByPrimepayant", query = "SELECT a FROM AmPrime a WHERE a.primepayant = :primepayant")})
public class AmPrime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
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
    @JoinColumn(name = "AM_CATEGORIETARIFAIRE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AmCategorietarifaire amCategorietarifaire;

    public AmPrime() {
    }

    public AmPrime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public AmCategorietarifaire getAmCategorietarifaire() {
        return amCategorietarifaire;
    }

    public void setAmCategorietarifaire(AmCategorietarifaire amCategorietarifaire) {
        this.amCategorietarifaire = amCategorietarifaire;
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
        if (!(object instanceof AmPrime)) {
            return false;
        }
        AmPrime other = (AmPrime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AmPrime[ id=" + id + " ]";
    }
    
}
