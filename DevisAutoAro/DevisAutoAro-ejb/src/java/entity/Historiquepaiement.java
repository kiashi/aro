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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author kiashi
 */
@Entity
@Table(name = "HISTORIQUEPAIEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historiquepaiement.findAll", query = "SELECT h FROM Historiquepaiement h")
    , @NamedQuery(name = "Historiquepaiement.findById", query = "SELECT h FROM Historiquepaiement h WHERE h.id = :id")
    , @NamedQuery(name = "Historiquepaiement.findByDateoperation", query = "SELECT h FROM Historiquepaiement h WHERE h.dateoperation = :dateoperation")
    , @NamedQuery(name = "Historiquepaiement.findByMontant", query = "SELECT h FROM Historiquepaiement h WHERE h.montant = :montant")
    , @NamedQuery(name = "Historiquepaiement.findByMotif", query = "SELECT h FROM Historiquepaiement h WHERE h.motif = :motif")})
public class Historiquepaiement implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATEOPERATION")
    
    private Date dateoperation;
    @Column(name = "MONTANT")
    private Double montant;
    @Size(max = 100)
    @Column(name = "MOTIF")
    private String motif;
    @JoinColumn(name = "SOUSCRIPTION_PRODUIT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SouscriptionProduit souscriptionProduitId;

    public Historiquepaiement() {
    }

    public Historiquepaiement(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateoperation() {
        return dateoperation;
    }

    public void setDateoperation(Date dateoperation) {
        this.dateoperation = dateoperation;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public SouscriptionProduit getSouscriptionProduitId() {
        return souscriptionProduitId;
    }

    public void setSouscriptionProduitId(SouscriptionProduit souscriptionProduitId) {
        this.souscriptionProduitId = souscriptionProduitId;
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
        if (!(object instanceof Historiquepaiement)) {
            return false;
        }
        Historiquepaiement other = (Historiquepaiement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Historiquepaiement[ id=" + id + " ]";
    }
    
}
