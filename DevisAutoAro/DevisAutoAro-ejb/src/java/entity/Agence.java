/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Misaina
 */
@Entity
@Table(name = "AGENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agence.findAll", query = "SELECT a FROM Agence a")
    , @NamedQuery(name = "Agence.findById", query = "SELECT a FROM Agence a WHERE a.id = :id")
    , @NamedQuery(name = "Agence.findByNom", query = "SELECT a FROM Agence a WHERE a.nom = :nom")
    , @NamedQuery(name = "Agence.findByVille", query = "SELECT a FROM Agence a WHERE a.ville = :ville")
    , @NamedQuery(name = "Agence.findByRue", query = "SELECT a FROM Agence a WHERE a.rue = :rue")
    , @NamedQuery(name = "Agence.findByAdresse", query = "SELECT a FROM Agence a WHERE a.adresse = :adresse")
    , @NamedQuery(name = "Agence.findByLongitude", query = "SELECT a FROM Agence a WHERE a.longitude = :longitude")
    , @NamedQuery(name = "Agence.findByLatitude", query = "SELECT a FROM Agence a WHERE a.latitude = :latitude")
    , @NamedQuery(name = "Agence.findByCode", query = "SELECT a FROM Agence a WHERE a.code = :code")})
public class Agence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 80)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 30)
    @Column(name = "VILLE")
    private String ville;
    @Size(max = 50)
    @Column(name = "RUE")
    private String rue;
    @Size(max = 80)
    @Column(name = "ADRESSE")
    private String adresse;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LONGITUDE")
    private Double longitude;
    @Column(name = "LATITUDE")
    private Double latitude;
    @Size(max = 10)
    @Column(name = "CODE")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agence")
    private List<Client> clientList;

    public Agence() {
    }

    public Agence(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
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
        if (!(object instanceof Agence)) {
            return false;
        }
        Agence other = (Agence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Agence[ id=" + id + " ]";
    }
    
}
