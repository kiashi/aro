/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author misa
 */
@Entity
@Table(name = "SINISTRES_VIEW")
public class SinistresView extends BaseModele implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDSINISTRE")
    private Integer id;
    @Column(name = "DATESINISTRE")
    private Date dateSinistre;
    @Column(name = "HEURE")
    private String heure;
    @Column(name = "LIEU")
    private String lieu;
    @Column(name = "NOMCONDUCTEUR")
    private String conducteur;
    @Column(name = "IDSOUSCRIPTION")
    private Integer idSouscription;
    @Column(name = "IDCATEGORIE")
    private Integer idCategorie;
    @Column(name = "NOMCLIENT")
    private String client;
    @Column(name = "NOIMM")
    private String immVehicule;
    @Column(name = "MARQUE")
    private String marque;
    @Column(name = "CATEGORIE")
    private String categorie;
    @Column(name = "TERMINE")
    private Integer termine;
    @Column(name = "DEMANDE")
    private Integer demande;

    public Integer getTermine() {
        return termine;
    }

    public void setTermine(Integer termine) {
        this.termine = termine;
    }

    public Integer getDemande() {
        return demande;
    }

    public void setDemande(Integer demande) {
        this.demande = demande;
    }
    
    

    public Date getDateSinistre() {
        return dateSinistre;
    }

    public void setDateSinistre(Date dateSinistre) {
        this.dateSinistre = dateSinistre;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getConducteur() {
        return conducteur;
    }

    public void setConducteur(String conducteur) {
        this.conducteur = conducteur;
    }

    public Integer getIdSouscription() {
        return idSouscription;
    }

    public void setIdSouscription(Integer idSouscription) {
        this.idSouscription = idSouscription;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getImmVehicule() {
        return immVehicule;
    }

    public void setImmVehicule(String immVehicule) {
        this.immVehicule = immVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof SinistresView)) {
            return false;
        }
        SinistresView other = (SinistresView) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SinistresView[ id=" + id + " ]";
    }

}
