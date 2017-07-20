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
@Table(name = "RT_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RtType.findAll", query = "SELECT r FROM RtType r")
    , @NamedQuery(name = "RtType.findById", query = "SELECT r FROM RtType r WHERE r.id = :id")
    , @NamedQuery(name = "RtType.findByLibelle", query = "SELECT r FROM RtType r WHERE r.libelle = :libelle")
    , @NamedQuery(name = "RtType.findByTaux", query = "SELECT r FROM RtType r WHERE r.taux = :taux")
    , @NamedQuery(name = "RtType.findByDescription", query = "SELECT r FROM RtType r WHERE r.description = :description")
    , @NamedQuery(name = "RtType.findByCode", query = "SELECT r FROM RtType r WHERE r.code = :code")})
public class RtType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "LIBELLE")
    private String libelle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAUX")
    private Double taux;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 2)
    @Column(name = "CODE")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rtType")
    private List<RtContrat> rtContratList;

    public RtType() {
    }

    public RtType(Integer id) {
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

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        if (!(object instanceof RtType)) {
            return false;
        }
        RtType other = (RtType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RtType[ id=" + id + " ]";
    }
    
}
