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
import javax.validation.constraints.Size;

/**
 *
 * @author Misaina
 */
@Entity
@Table(name = "PHOTO_SINISTRE")
@NamedQueries({
    @NamedQuery(name = "PhotoSinistre.findAll", query = "SELECT p FROM PhotoSinistre p")
    , @NamedQuery(name = "PhotoSinistre.findById", query = "SELECT p FROM PhotoSinistre p WHERE p.id = :id")})
public class PhotoSinistre extends BaseModele implements Serializable {

    @Size(max = 200)
    @Column(name = "PHOTO")
    private String photo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "AM_SINISTRE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AmSinistre amSinistre;

    public PhotoSinistre() {
    }

    public PhotoSinistre(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AmSinistre getAmSinistre() {
        return amSinistre;
    }

    public void setAmSinistre(AmSinistre amSinistre) {
        this.amSinistre = amSinistre;
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
        if (!(object instanceof PhotoSinistre)) {
            return false;
        }
        PhotoSinistre other = (PhotoSinistre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.misaina.modele.PhotoSinistre[ id=" + id + " ]";
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}
