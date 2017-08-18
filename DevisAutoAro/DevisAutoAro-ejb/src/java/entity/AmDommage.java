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
@Table(name = "AM_DOMMAGE")
@NamedQueries({
    @NamedQuery(name = "AmDommage.findAll", query = "SELECT a FROM AmDommage a")
    , @NamedQuery(name = "AmDommage.findById", query = "SELECT a FROM AmDommage a WHERE a.id = :id")
    , @NamedQuery(name = "AmDommage.findByLibelle", query = "SELECT a FROM AmDommage a WHERE a.libelle = :libelle")})
public class AmDommage implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 80)
    @Column(name = "LIBELLE")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amDommageId")
    private List<DommagesSinistre> dommagesSinistreList;

    public AmDommage() {
    }

    public AmDommage(Integer id) {
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

    public List<DommagesSinistre> getDommagesSinistreList() {
        return dommagesSinistreList;
    }

    public void setDommagesSinistreList(List<DommagesSinistre> dommagesSinistreList) {
        this.dommagesSinistreList = dommagesSinistreList;
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
        if (!(object instanceof AmDommage)) {
            return false;
        }
        AmDommage other = (AmDommage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.misaina.modele.AmDommage[ id=" + id + " ]";
    }
    
}
