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
@Table(name = "RT_CONTRAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RtContrat.findAll", query = "SELECT r FROM RtContrat r")
    , @NamedQuery(name = "RtContrat.findById", query = "SELECT r FROM RtContrat r WHERE r.id = :id")
    , @NamedQuery(name = "RtContrat.findByDaty", query = "SELECT r FROM RtContrat r WHERE r.daty = :daty")
    , @NamedQuery(name = "RtContrat.findByNopolice", query = "SELECT r FROM RtContrat r WHERE r.nopolice = :nopolice")
    , @NamedQuery(name = "RtContrat.findByBeneficiaireCasDeces", query = "SELECT r FROM RtContrat r WHERE r.beneficiaireCasDeces = :beneficiaireCasDeces")})
public class RtContrat implements Serializable {

    @JoinColumn(name = "SOUSCRIPTION_PRODUIT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SouscriptionProduit souscriptionProduitId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date daty;
    @Size(max = 6)
    @Column(name = "NOPOLICE")
    private String nopolice;
    @Size(max = 300)
    @Column(name = "BENEFICIAIRE_CAS_DECES")
    private String beneficiaireCasDeces;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rtContrat")
    private List<RtDepot> rtDepotList;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "RT_OPTION_RETRAIT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RtOptionRetrait rtOptionRetrait;
    @JoinColumn(name = "RT_PERIODICITE_COTISATION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RtPeriodiciteCotisation rtPeriodiciteCotisation;
    @JoinColumn(name = "RT_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RtType rtType;

    public RtContrat() {
    }

    public RtContrat(Integer id) {
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

    public String getNopolice() {
        return nopolice;
    }

    public void setNopolice(String nopolice) {
        this.nopolice = nopolice;
    }

    public String getBeneficiaireCasDeces() {
        return beneficiaireCasDeces;
    }

    public void setBeneficiaireCasDeces(String beneficiaireCasDeces) {
        this.beneficiaireCasDeces = beneficiaireCasDeces;
    }

    @XmlTransient
    public List<RtDepot> getRtDepotList() {
        return rtDepotList;
    }

    public void setRtDepotList(List<RtDepot> rtDepotList) {
        this.rtDepotList = rtDepotList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public RtOptionRetrait getRtOptionRetrait() {
        return rtOptionRetrait;
    }

    public void setRtOptionRetrait(RtOptionRetrait rtOptionRetrait) {
        this.rtOptionRetrait = rtOptionRetrait;
    }

    public RtPeriodiciteCotisation getRtPeriodiciteCotisation() {
        return rtPeriodiciteCotisation;
    }

    public void setRtPeriodiciteCotisation(RtPeriodiciteCotisation rtPeriodiciteCotisation) {
        this.rtPeriodiciteCotisation = rtPeriodiciteCotisation;
    }

    public RtType getRtType() {
        return rtType;
    }

    public void setRtType(RtType rtType) {
        this.rtType = rtType;
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
        if (!(object instanceof RtContrat)) {
            return false;
        }
        RtContrat other = (RtContrat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RtContrat[ id=" + id + " ]";
    }

    public SouscriptionProduit getSouscriptionProduitId() {
        return souscriptionProduitId;
    }

    public void setSouscriptionProduitId(SouscriptionProduit souscriptionProduitId) {
        this.souscriptionProduitId = souscriptionProduitId;
    }
    
}
