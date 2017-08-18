/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Misaina
 */
@Entity
@Table(name = "SIN_CIRCONSTANCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SinCirconstance.findAll", query = "SELECT s FROM SinCirconstance s")
    , @NamedQuery(name = "SinCirconstance.findById", query = "SELECT s FROM SinCirconstance s WHERE s.id = :id")
    , @NamedQuery(name = "SinCirconstance.findByEtape", query = "SELECT s FROM SinCirconstance s WHERE s.etape = :etape")
    , @NamedQuery(name = "SinCirconstance.findByDescription", query = "SELECT s FROM SinCirconstance s WHERE s.description = :description")})
public class SinCirconstance implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ETAPE")
    private Integer etape;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "AM_SINISTRE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AmSinistre amSinistreId;

    public SinCirconstance() {
    }

    public SinCirconstance(Integer id) {
        this.id = id;
    }

    public SinCirconstance(Integer id, Integer etape, String description) {
        this.id = id;
        this.etape = etape;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEtape() {
        return etape;
    }

    public void setEtape(Integer etape) {
        this.etape = etape;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AmSinistre getAmSinistreId() {
        return amSinistreId;
    }

    public void setAmSinistreId(AmSinistre amSinistreId) {
        this.amSinistreId = amSinistreId;
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
        if (!(object instanceof SinCirconstance)) {
            return false;
        }
        SinCirconstance other = (SinCirconstance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.misaina.modele.SinCirconstance[ id=" + id + " ]";
    }
    
}
