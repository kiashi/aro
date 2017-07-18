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
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id")
    , @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom")
    , @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom")
    , @NamedQuery(name = "Client.findByAdresse", query = "SELECT c FROM Client c WHERE c.adresse = :adresse")
    , @NamedQuery(name = "Client.findByProfession", query = "SELECT c FROM Client c WHERE c.profession = :profession")
    , @NamedQuery(name = "Client.findByDateNaissance", query = "SELECT c FROM Client c WHERE c.dateNaissance = :dateNaissance")
    , @NamedQuery(name = "Client.findByLieuNaissance", query = "SELECT c FROM Client c WHERE c.lieuNaissance = :lieuNaissance")
    , @NamedQuery(name = "Client.findByCin", query = "SELECT c FROM Client c WHERE c.cin = :cin")
    , @NamedQuery(name = "Client.findByTel", query = "SELECT c FROM Client c WHERE c.tel = :tel")
    , @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email")
    , @NamedQuery(name = "Client.findByMdp", query = "SELECT c FROM Client c WHERE c.mdp = :mdp")
    , @NamedQuery(name = "Client.findByNoclient", query = "SELECT c FROM Client c WHERE c.noclient = :noclient")
    , @NamedQuery(name = "Client.findByDateSouscription", query = "SELECT c FROM Client c WHERE c.dateSouscription = :dateSouscription")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 50)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 80)
    @Column(name = "ADRESSE")
    private String adresse;
    @Size(max = 80)
    @Column(name = "PROFESSION")
    private String profession;
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Size(max = 50)
    @Column(name = "LIEU_NAISSANCE")
    private String lieuNaissance;
    @Size(max = 12)
    @Column(name = "CIN")
    private String cin;
    @Size(max = 20)
    @Column(name = "TEL")
    private String tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 30)
    @Column(name = "MDP")
    private String mdp;
//    @Size(max = 6)
//    @Column(name = "NOPOLICE")
//    private String nopolice;
    @Size(max = 10)
    @Column(name = "NOCLIENT")
    private String noclient;
    @Column(name = "DATE_SOUSCRIPTION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSouscription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<AmSinistre> amSinistreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<ClBalance> clBalanceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<SouscriptionProduit> souscriptionProduitList;
    @JoinColumn(name = "AGENCE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Agence agence;
    @JoinColumn(name = "CL_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ClType clType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<RtContrat> rtContratList;

    public Client() {
    }

    public Client(Integer id) {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNoclient() {
        return noclient;
    }

    public void setNoclient(String noclient) {
        this.noclient = noclient;
    }

    public Date getDateSouscription() {
        return dateSouscription;
    }

    public void setDateSouscription(Date dateSouscription) {
        this.dateSouscription = dateSouscription;
    }

    @XmlTransient
    public List<AmSinistre> getAmSinistreList() {
        return amSinistreList;
    }

    public void setAmSinistreList(List<AmSinistre> amSinistreList) {
        this.amSinistreList = amSinistreList;
    }

    @XmlTransient
    public List<ClBalance> getClBalanceList() {
        return clBalanceList;
    }

    public void setClBalanceList(List<ClBalance> clBalanceList) {
        this.clBalanceList = clBalanceList;
    }

    @XmlTransient
    public List<SouscriptionProduit> getSouscriptionProduitList() {
        return souscriptionProduitList;
    }

    public void setSouscriptionProduitList(List<SouscriptionProduit> souscriptionProduitList) {
        this.souscriptionProduitList = souscriptionProduitList;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public ClType getClType() {
        return clType;
    }

    public void setClType(ClType clType) {
        this.clType = clType;
    }

    @XmlTransient
    public List<RtContrat> getRtContratList() {
        return rtContratList;
    }

    public void setRtContratList(List<RtContrat> rtContratList) {
        this.rtContratList = rtContratList;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Client[ id=" + id + " ]";
    }
    
}
