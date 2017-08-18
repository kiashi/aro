/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    , @NamedQuery(name = "AmSinistre.findByDetails", query = "SELECT a FROM AmSinistre a WHERE a.details = :details")
    , @NamedQuery(name = "AmSinistre.findByDaty", query = "SELECT a FROM AmSinistre a WHERE a.daty = :daty")
    , @NamedQuery(name = "AmSinistre.findByLieu", query = "SELECT a FROM AmSinistre a WHERE a.lieu = :lieu")})
public class AmSinistre extends BaseModele implements Serializable {

    @Size(max = 10)
    @Column(name = "HEURE")
    private String heure;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LATITUDE")
    private Double latitude;
    @Column(name = "LONGITUDE")
    private Double longitude;
    @Column(name = "TERMINE")
    private Integer termine;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amSinistreId")
    private transient List<DommagesSinistre> dommagesSinistreList;
    @JoinColumn(name = "SOUSCRIPTION_PRODUIT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SouscriptionProduit souscriptionProduitId;
    @JoinColumn(name = "SIN_CATEGORIE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SinCategorie categorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amSinistreId")
    private transient List<SinRapport> sinRapportList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amSinistreId")
    private transient List<SinCirconstance> sinCirconstanceList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 500)
    @Column(name = "DETAILS")
    private String details;
    @Column(name = "DATY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date daty;
    @Size(max = 80)
    @Column(name = "LIEU")
    private String lieu;

    @Column(name = "DEMANDE")
    private Integer demande;
    @Column(name = "CONDUCTEUR")
    private String conducteur;
    @Column(name = "NOM")
    private String nomConducteur;
    @Column(name = "PRENOM")
    private String prenomConducteur;
    @Column(name = "ADRESSE")
    private String adresseConducteur;
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dnConducteur;
    @Column(name = "NOPERMIS")
    private String nopermis;
    @Column(name = "NODUPLICATA")
    private String noduplicata;
    @Column(name = "CATEGORIEPERMIS")
    private String catPermis;
    @Column(name = "CATVALIDEES")
    private String catValidees;
    @Column(name = "DEB_VALIDITE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debValidite;
    @Column(name = "FIN_VALIDITE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finValidite;
    
    @Column(name = "DATE_DELIVRANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDelivrance;
    @Column(name = "LIEU_DELIVRANCE")
    private String lieuDelivrance;
    @Column(name = "CAP_OBTENU")
    private String capObtenu;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amSinistre")
    private transient List<PhotoSinistre> photoSinistreList;

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

    public SinCategorie getCategorie() {
        return categorie;
    }

    public void setCategorie(SinCategorie categorie) {
        this.categorie = categorie;
    }

    public Integer getDemande() {
        return demande;
    }

    public void setDemande(Integer demande) {
        this.demande = demande;
    }

    public String getConducteur() {
        return conducteur;
    }

    public void setConducteur(String conducteur) {
        this.conducteur = conducteur;
    }

    public String getNomConducteur() {
        return nomConducteur;
    }

    public void setNomConducteur(String nomConducteur) {
        this.nomConducteur = nomConducteur;
    }

    public String getPrenomConducteur() {
        return prenomConducteur;
    }

    public void setPrenomConducteur(String prenomConducteur) {
        this.prenomConducteur = prenomConducteur;
    }

    public String getAdresseConducteur() {
        return adresseConducteur;
    }

    public void setAdresseConducteur(String adresseConducteur) {
        this.adresseConducteur = adresseConducteur;
    }

    public Date getDnConducteur() {
        return dnConducteur;
    }

    public void setDnConducteur(Date dnConducteur) {
        this.dnConducteur = dnConducteur;
    }

    public String getNopermis() {
        return nopermis;
    }

    public void setNopermis(String nopermis) {
        this.nopermis = nopermis;
    }

    public String getNoduplicata() {
        return noduplicata;
    }

    public void setNoduplicata(String noduplicata) {
        this.noduplicata = noduplicata;
    }

    public String getCatPermis() {
        return catPermis;
    }

    public void setCatPermis(String catPermis) {
        this.catPermis = catPermis;
    }

    public String getCatValidees() {
        return catValidees;
    }

    public void setCatValidees(String catValidees) {
        this.catValidees = catValidees;
    }

    public Date getDebValidite() {
        return debValidite;
    }

    public void setDebValidite(Date debValidite) {
        this.debValidite = debValidite;
    }

    public Date getFinValidite() {
        return finValidite;
    }

    public void setFinValidite(Date finValidite) {
        this.finValidite = finValidite;
    }

    public Date getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public String getLieuDelivrance() {
        return lieuDelivrance;
    }

    public void setLieuDelivrance(String lieuDelivrance) {
        this.lieuDelivrance = lieuDelivrance;
    }

    public String getCapObtenu() {
        return capObtenu;
    }

    public void setCapObtenu(String capObtenu) {
        this.capObtenu = capObtenu;
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
        return "com.misaina.modele.AmSinistre[ id=" + id + " ]";
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getTermine() {
        return termine;
    }

    public void setTermine(Integer termine) {
        this.termine = termine;
    }

    @XmlTransient
    public List<DommagesSinistre> getDommagesSinistreList() {
        return dommagesSinistreList;
    }

    public void setDommagesSinistreList(List<DommagesSinistre> dommagesSinistreList) {
        this.dommagesSinistreList = dommagesSinistreList;
    }

    public SouscriptionProduit getSouscriptionProduitId() {
        return souscriptionProduitId;
    }

    public void setSouscriptionProduitId(SouscriptionProduit souscriptionProduitId) {
        this.souscriptionProduitId = souscriptionProduitId;
    }


}
