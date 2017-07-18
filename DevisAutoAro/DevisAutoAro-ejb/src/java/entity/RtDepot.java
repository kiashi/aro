/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Misaina
 */
@Entity
@Table(name = "RT_DEPOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RtDepot.findAll", query = "SELECT r FROM RtDepot r")
    , @NamedQuery(name = "RtDepot.findById", query = "SELECT r FROM RtDepot r WHERE r.id = :id")
    , @NamedQuery(name = "RtDepot.findByValeur", query = "SELECT r FROM RtDepot r WHERE r.valeur = :valeur")
    , @NamedQuery(name = "RtDepot.findByDaty", query = "SELECT r FROM RtDepot r WHERE r.daty = :daty")})
public class RtDepot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALEUR")
    private Double valeur;
    @Column(name = "DATY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date daty;
    @JoinColumn(name = "RT_CONTRAT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RtContrat rtContrat;

    public RtDepot() {
    }

    public RtDepot(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public RtContrat getRtContrat() {
        return rtContrat;
    }

    public void setRtContrat(RtContrat rtContrat) {
        this.rtContrat = rtContrat;
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
        if (!(object instanceof RtDepot)) {
            return false;
        }
        RtDepot other = (RtDepot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RtDepot[ id=" + id + " ]";
    }
    
}
