/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
 * @author Misaina
 */
@Entity
@Table(name = "DOMMAGES_SINISTRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DommagesSinistre.findAll", query = "SELECT d FROM DommagesSinistre d")
    , @NamedQuery(name = "DommagesSinistre.findById", query = "SELECT d FROM DommagesSinistre d WHERE d.id = :id")})
public class DommagesSinistre implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "AM_DOMMAGE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AmDommage amDommageId;
    @JoinColumn(name = "AM_SINISTRE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AmSinistre amSinistreId;

    public DommagesSinistre() {
    }

    public DommagesSinistre(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AmDommage getAmDommageId() {
        return amDommageId;
    }

    public void setAmDommageId(AmDommage amDommageId) {
        this.amDommageId = amDommageId;
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
        if (!(object instanceof DommagesSinistre)) {
            return false;
        }
        DommagesSinistre other = (DommagesSinistre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.misaina.modele.DommagesSinistre[ id=" + id + " ]";
    }
    
}
