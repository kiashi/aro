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
@Table(name = "AM_VEHICULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmVehicule.findAll", query = "SELECT a FROM AmVehicule a")
    , @NamedQuery(name = "AmVehicule.findById", query = "SELECT a FROM AmVehicule a WHERE a.id = :id")
    , @NamedQuery(name = "AmVehicule.findByNoimm", query = "SELECT a FROM AmVehicule a WHERE a.noimm = :noimm")
    , @NamedQuery(name = "AmVehicule.findByMarque", query = "SELECT a FROM AmVehicule a WHERE a.marque = :marque")
    , @NamedQuery(name = "AmVehicule.findByType", query = "SELECT a FROM AmVehicule a WHERE a.type = :type")
    , @NamedQuery(name = "AmVehicule.findByCarrosserie", query = "SELECT a FROM AmVehicule a WHERE a.carrosserie = :carrosserie")
    , @NamedQuery(name = "AmVehicule.findByNoserie", query = "SELECT a FROM AmVehicule a WHERE a.noserie = :noserie")
    , @NamedQuery(name = "AmVehicule.findByDateMiseEnCirc", query = "SELECT a FROM AmVehicule a WHERE a.dateMiseEnCirc = :dateMiseEnCirc")
    , @NamedQuery(name = "AmVehicule.findByPuissanceFisc", query = "SELECT a FROM AmVehicule a WHERE a.puissanceFisc = :puissanceFisc")
    , @NamedQuery(name = "AmVehicule.findBySourceEnergie", query = "SELECT a FROM AmVehicule a WHERE a.sourceEnergie = :sourceEnergie")
    , @NamedQuery(name = "AmVehicule.findByPoidsVide", query = "SELECT a FROM AmVehicule a WHERE a.poidsVide = :poidsVide")
    , @NamedQuery(name = "AmVehicule.findByPoidsCharge", query = "SELECT a FROM AmVehicule a WHERE a.poidsCharge = :poidsCharge")
    , @NamedQuery(name = "AmVehicule.findByNbPlace", query = "SELECT a FROM AmVehicule a WHERE a.nbPlace = :nbPlace")
    , @NamedQuery(name = "AmVehicule.findByRemorque", query = "SELECT a FROM AmVehicule a WHERE a.remorque = :remorque")
    , @NamedQuery(name = "AmVehicule.findByDebutVisiteTech", query = "SELECT a FROM AmVehicule a WHERE a.debutVisiteTech = :debutVisiteTech")
    , @NamedQuery(name = "AmVehicule.findByFinVisiteTech", query = "SELECT a FROM AmVehicule a WHERE a.finVisiteTech = :finVisiteTech")})
public class AmVehicule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 10)
    @Column(name = "NOIMM")
    private String noimm;
    @Size(max = 20)
    @Column(name = "MARQUE")
    private String marque;
    @Size(max = 20)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 30)
    @Column(name = "CARROSSERIE")
    private String carrosserie;
    @Size(max = 20)
    @Column(name = "NOSERIE")
    private String noserie;
    @Column(name = "DATE_MISE_EN_CIRC")
    
    private Date dateMiseEnCirc;
    @Column(name = "PUISSANCE_FISC")
    private Integer puissanceFisc;
    @Size(max = 10)
    @Column(name = "SOURCE_ENERGIE")
    private String sourceEnergie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "POIDS_VIDE")
    private Double poidsVide;
    @Column(name = "POIDS_CHARGE")
    private Double poidsCharge;
    @Column(name = "NB_PLACE")
    private Integer nbPlace;
    @Column(name = "REMORQUE")
    private Integer remorque;
    @Column(name = "DEBUT_VISITE_TECH")
    
    private Date debutVisiteTech;
    @Column(name = "FIN_VISITE_TECH")
   
    private Date finVisiteTech;
    @JoinColumn(name = "SOUSCRIPTION_PRODUIT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SouscriptionProduit souscriptionProduit;
    @Column(name = "NBROUES")
    private Integer nbroues;

    public Integer getNbroues() {
        return nbroues;
    }

    public void setNbroues(Integer nbroues) {
        this.nbroues = nbroues;
    }

    public AmVehicule() {
    }

    public AmVehicule(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoimm() {
        return noimm;
    }

    public void setNoimm(String noimm) {
        this.noimm = noimm;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarrosserie() {
        return carrosserie;
    }

    public void setCarrosserie(String carrosserie) {
        this.carrosserie = carrosserie;
    }

    public String getNoserie() {
        return noserie;
    }

    public void setNoserie(String noserie) {
        this.noserie = noserie;
    }

    public Date getDateMiseEnCirc() {
        return dateMiseEnCirc;
    }

    public void setDateMiseEnCirc(Date dateMiseEnCirc) {
        this.dateMiseEnCirc = dateMiseEnCirc;
    }

    public Integer getPuissanceFisc() {
        return puissanceFisc;
    }

    public void setPuissanceFisc(Integer puissanceFisc) {
        this.puissanceFisc = puissanceFisc;
    }

    public String getSourceEnergie() {
        return sourceEnergie;
    }

    public void setSourceEnergie(String sourceEnergie) {
        this.sourceEnergie = sourceEnergie;
    }

    public Double getPoidsVide() {
        return poidsVide;
    }

    public void setPoidsVide(Double poidsVide) {
        this.poidsVide = poidsVide;
    }

    public Double getPoidsCharge() {
        return poidsCharge;
    }

    public void setPoidsCharge(Double poidsCharge) {
        this.poidsCharge = poidsCharge;
    }

    public Integer getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(Integer nbPlace) {
        this.nbPlace = nbPlace;
    }

    public Integer getRemorque() {
        return remorque;
    }

    public void setRemorque(Integer remorque) {
        this.remorque = remorque;
    }

    public Date getDebutVisiteTech() {
        return debutVisiteTech;
    }

    public void setDebutVisiteTech(Date debutVisiteTech) {
        this.debutVisiteTech = debutVisiteTech;
    }

    public Date getFinVisiteTech() {
        return finVisiteTech;
    }

    public void setFinVisiteTech(Date finVisiteTech) {
        this.finVisiteTech = finVisiteTech;
    }


    public SouscriptionProduit getSouscriptionProduit() {
        return souscriptionProduit;
    }

    public void setSouscriptionProduit(SouscriptionProduit souscriptionProduit) {
        this.souscriptionProduit = souscriptionProduit;
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
        if (!(object instanceof AmVehicule)) {
            return false;
        }
        AmVehicule other = (AmVehicule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AmVehicule[ id=" + id + " ]";
    }
    
}
