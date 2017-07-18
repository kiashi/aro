/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Misaina
 */
@Entity
@Table(name = "CL_BALANCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClBalance.findAll", query = "SELECT c FROM ClBalance c")
    , @NamedQuery(name = "ClBalance.findById", query = "SELECT c FROM ClBalance c WHERE c.id = :id")
    , @NamedQuery(name = "ClBalance.findByLibelle", query = "SELECT c FROM ClBalance c WHERE c.libelle = :libelle")
    , @NamedQuery(name = "ClBalance.findByMotif", query = "SELECT c FROM ClBalance c WHERE c.motif = :motif")
    , @NamedQuery(name = "ClBalance.findByValeur", query = "SELECT c FROM ClBalance c WHERE c.valeur = :valeur")
    , @NamedQuery(name = "ClBalance.findByDaty", query = "SELECT c FROM ClBalance c WHERE c.daty = :daty")
    , @NamedQuery(name = "ClBalance.findByRetire", query = "SELECT c FROM ClBalance c WHERE c.retire = :retire")})
public class ClBalance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 80)
    @Column(name = "LIBELLE")
    private String libelle;
    @Size(max = 200)
    @Column(name = "MOTIF")
    private String motif;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALEUR")
    private Double valeur;
    @Column(name = "DATY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date daty;
    @Column(name = "RETIRE")
    private BigInteger retire;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Client client;

    public ClBalance() {
    }

    public ClBalance(Integer id) {
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

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
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

    public BigInteger getRetire() {
        return retire;
    }

    public void setRetire(BigInteger retire) {
        this.retire = retire;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        if (!(object instanceof ClBalance)) {
            return false;
        }
        ClBalance other = (ClBalance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClBalance[ id=" + id + " ]";
    }
    
}
