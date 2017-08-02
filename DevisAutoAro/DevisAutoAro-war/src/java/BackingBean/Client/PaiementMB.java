/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Client;

import EJB.CompteClientBean;
import EJB.RetraiteBean;
import entity.Compteclient;
import entity.Historiquepaiement;
import entity.SouscriptionProduit;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author kiashi
 */
@Named(value = "paiementMB")
@RequestScoped
public class PaiementMB {

   

    @EJB
    private CompteClientBean compteClientBean;

    
    SouscriptionProduit produit = new SouscriptionProduit();

    public SouscriptionProduit getProduit() {
        return produit;
    }

    public void setProduit(SouscriptionProduit produit) {
        this.produit = produit;
    }

    public String getNocompte() {
        return nocompte;
    }

    public void setNocompte(String nocompte) {
        this.nocompte = nocompte;
    }

    public int getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }
    
    
    private String nocompte;
    private String mdp;
     private int idContrat;

    public void loadContrat() {
        this.produit = compteClientBean.findBySouscriptionId(new Integer(idContrat));
    }
    
    /**
     * Creates a new instance of PaiementMB
     */
    public String ajouterpaiement(Integer i) {
        this.produit = compteClientBean.findBySouscriptionId(i);
        System.out.println("------------"+produit.getId());
        
        compteClientBean.payer(produit,produit.getPrimetotal(), nocompte,mdp);
        return "/JSF/Client/contrat.xhtml";
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public PaiementMB() {
    }
    
}
