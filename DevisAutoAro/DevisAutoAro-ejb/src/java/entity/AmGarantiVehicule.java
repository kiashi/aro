/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kiashi
 */
@Entity
@Table(name = "AM_GARANTI_VEHICULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmGarantiVehicule.findAll", query = "SELECT a FROM AmGarantiVehicule a")
    , @NamedQuery(name = "AmGarantiVehicule.findById", query = "SELECT a FROM AmGarantiVehicule a WHERE a.id = :id")})
public class AmGarantiVehicule implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "AM_GARANTI_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AmGaranti amGarantiId;
    @JoinColumn(name = "SOUSCRIPTION_PRODUIT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SouscriptionProduit souscriptionProduitId;
    @Column(name = "MTLIMITE")
    private Double mtlimite;

    public Double getMtlimite() {
        return mtlimite;
    }

    public void setMtlimite(Double mtlimite) {
        this.mtlimite = mtlimite;
    }

    public AmGarantiVehicule() {
    }

    public AmGarantiVehicule(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AmGaranti getAmGarantiId() {
        return amGarantiId;
    }

    public void setAmGarantiId(AmGaranti amGarantiId) {
        this.amGarantiId = amGarantiId;
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
        if (!(object instanceof AmGarantiVehicule)) {
            return false;
        }
        AmGarantiVehicule other = (AmGarantiVehicule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AmGarantiVehicule[ id=" + id + " ]";
    }
    
}
