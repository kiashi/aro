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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kiashi
 */
@Entity
@Table(name = "COMPTECLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compteclient.findAll", query = "SELECT c FROM Compteclient c")
    , @NamedQuery(name = "Compteclient.findById", query = "SELECT c FROM Compteclient c WHERE c.id = :id")
    , @NamedQuery(name = "Compteclient.findByNoclient", query = "SELECT c FROM Compteclient c WHERE c.noclient = :noclient")
    , @NamedQuery(name = "Compteclient.findBySolde", query = "SELECT c FROM Compteclient c WHERE c.solde = :solde")
    , @NamedQuery(name = "Compteclient.findByTypecompte", query = "SELECT c FROM Compteclient c WHERE c.typecompte = :typecompte")
    , @NamedQuery(name = "Compteclient.findByMdp", query = "SELECT c FROM Compteclient c WHERE c.mdp = :mdp")})
public class Compteclient implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "NOCLIENT")
    private String noclient;
    @Column(name = "SOLDE")
    private Double solde;
    @Size(max = 50)
    @Column(name = "TYPECOMPTE")
    private String typecompte;
    @Size(max = 20)
    @Column(name = "MDP")
    private String mdp;

    public Compteclient() {
    }

    public Compteclient(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoclient() {
        return noclient;
    }

    public void setNoclient(String noclient) {
        this.noclient = noclient;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public String getTypecompte() {
        return typecompte;
    }

    public void setTypecompte(String typecompte) {
        this.typecompte = typecompte;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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
        if (!(object instanceof Compteclient)) {
            return false;
        }
        Compteclient other = (Compteclient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Compteclient[ id=" + id + " ]";
    }
    
}
