/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Misaina
 */
@Entity
@Table(name = "SOUSCRIPTION_PRODUIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SouscriptionProduit.findAll", query = "SELECT s FROM SouscriptionProduit s")
    , @NamedQuery(name = "SouscriptionProduit.findById", query = "SELECT s FROM SouscriptionProduit s WHERE s.id = :id")
    , @NamedQuery(name = "SouscriptionProduit.findByDaty", query = "SELECT s FROM SouscriptionProduit s WHERE s.daty = :daty")
    , @NamedQuery(name = "SouscriptionProduit.findByPrimenet", query = "SELECT s FROM SouscriptionProduit s WHERE s.primenet = :primenet")
    , @NamedQuery(name = "SouscriptionProduit.findByPrimetotal", query = "SELECT s FROM SouscriptionProduit s WHERE s.primetotal = :primetotal")
    , @NamedQuery(name = "SouscriptionProduit.findByDuree", query = "SELECT s FROM SouscriptionProduit s WHERE s.duree = :duree")
    , @NamedQuery(name = "SouscriptionProduit.findByReduction", query = "SELECT s FROM SouscriptionProduit s WHERE s.reduction = :reduction")})
public class SouscriptionProduit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date daty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRIMENET")
    private Double primenet;
    @Column(name = "PRIMETOTAL")
    private Double primetotal;
    @Column(name = "DUREE")
    private BigInteger duree;
    @Column(name = "REDUCTION")
    private Double reduction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "souscriptionProduit")
    private List<AmVehicule> amVehiculeList;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "PRODUIT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Produit produit;
    @Size(max = 6)
    @Column(name = "NOPOLICE")
    private String nopolice;

    public SouscriptionProduit() {
    }

    public SouscriptionProduit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public Double getPrimenet() {
        return primenet;
    }

    public void setPrimenet(Double primenet) {
        this.primenet = primenet;
    }

    public Double getPrimetotal() {
        return primetotal;
    }

    public void setPrimetotal(Double primetotal) {
        this.primetotal = primetotal;
    }

    public BigInteger getDuree() {
        return duree;
    }

    public void setDuree(BigInteger duree) {
        this.duree = duree;
    }

    public Double getReduction() {
        return reduction;
    }

    public void setReduction(Double reduction) {
        this.reduction = reduction;
    }

    @XmlTransient
    public List<AmVehicule> getAmVehiculeList() {
        return amVehiculeList;
    }

    public void setAmVehiculeList(List<AmVehicule> amVehiculeList) {
        this.amVehiculeList = amVehiculeList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getNopolice() {
        return nopolice;
    }

    public void setNopolice(String nopolice) {
        this.nopolice = nopolice;
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
        if (!(object instanceof SouscriptionProduit)) {
            return false;
        }
        SouscriptionProduit other = (SouscriptionProduit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SouscriptionProduit[ id=" + id + " ]";
    }

}
