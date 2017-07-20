/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "AM_SINISTRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmSinistre.findAll", query = "SELECT a FROM AmSinistre a")
    , @NamedQuery(name = "AmSinistre.findById", query = "SELECT a FROM AmSinistre a WHERE a.id = :id")
    , @NamedQuery(name = "AmSinistre.findByLibelle", query = "SELECT a FROM AmSinistre a WHERE a.libelle = :libelle")
    , @NamedQuery(name = "AmSinistre.findByDetails", query = "SELECT a FROM AmSinistre a WHERE a.details = :details")
    , @NamedQuery(name = "AmSinistre.findByDaty", query = "SELECT a FROM AmSinistre a WHERE a.daty = :daty")
    , @NamedQuery(name = "AmSinistre.findByLieu", query = "SELECT a FROM AmSinistre a WHERE a.lieu = :lieu")})
public class AmSinistre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "LIBELLE")
    private String libelle;
    @Size(max = 500)
    @Column(name = "DETAILS")
    private String details;
    @Column(name = "DATY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date daty;
    @Size(max = 80)
    @Column(name = "LIEU")
    private String lieu;
    @JoinColumn(name = "AM_VEHICULE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AmVehicule amVehicule;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Client client;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amSinistre")
    private List<PhotoSinistre> photoSinistreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amSinistre")
    private List<SinSuivi> sinSuiviList;

    public AmSinistre() {
    }

    public AmSinistre(Integer id) {
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public AmVehicule getAmVehicule() {
        return amVehicule;
    }

    public void setAmVehicule(AmVehicule amVehicule) {
        this.amVehicule = amVehicule;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @XmlTransient
    public List<PhotoSinistre> getPhotoSinistreList() {
        return photoSinistreList;
    }

    public void setPhotoSinistreList(List<PhotoSinistre> photoSinistreList) {
        this.photoSinistreList = photoSinistreList;
    }

    @XmlTransient
    public List<SinSuivi> getSinSuiviList() {
        return sinSuiviList;
    }

    public void setSinSuiviList(List<SinSuivi> sinSuiviList) {
        this.sinSuiviList = sinSuiviList;
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
        if (!(object instanceof AmSinistre)) {
            return false;
        }
        AmSinistre other = (AmSinistre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AmSinistre[ id=" + id + " ]";
    }
    
}
