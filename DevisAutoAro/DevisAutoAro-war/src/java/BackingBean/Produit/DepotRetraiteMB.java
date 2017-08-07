/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Produit;

import EJB.CompteClientBean;
import EJB.RetraiteBean;
import EJB.RtDepotBean;
import entity.Client;
import entity.RtContrat;
import entity.RtDepot;
import entity.SouscriptionProduit;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import javax.faces.context.FacesContext;

/**
 *
 * @author kiashi
 */
@Named(value = "depotRetraiteMB")
@RequestScoped
public class DepotRetraiteMB {

    @EJB
    private RtDepotBean rtDepotBean;


    @EJB
    private RetraiteBean retraiteBean;
    

    private RtContrat contrat = new RtContrat();
    private RtDepot depot = new RtDepot();
    private Double valeur =new Double(0);
    private List<RtDepot> listeDepot;
    private Double total = new Double(0);

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<RtDepot> getListeDepot() {
        if(listeDepot==null){
            
            listeDepot=rtDepotBean.findDepot(contrat.getId());
            for(RtDepot a:listeDepot){
                total = total + a.getValeur();
            }
        }
        return listeDepot;
    }

    public void setListeDepot(List<RtDepot> listeDepot) {
        this.listeDepot = listeDepot;
    }
    

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

   

    public RtContrat getContrat() {
        return contrat;
    }

    public void setContrat(RtContrat contrat) {
        this.contrat = contrat;
    }

   
    public int getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }
    
    private int idContrat;

    public void loadContrat() {
        this.contrat = retraiteBean.findBySouscriptionId(new Integer(idContrat));
    }

    public String ajouterDepot(Integer id) {
        
        this.contrat = retraiteBean.findBySouscriptionId(id);
        this.produit = compteClientBean.findBySouscriptionId(id);
        System.out.println("------contrat"+contrat.getId());
         System.out.println("------depot"+depot.getId());
         
        depot.setRtContrat(contrat);
        System.out.println("__________"+nocompte);
         System.out.println("__________"+mdp);
         compteClientBean.payer(produit,depot.getValeur(), nocompte,mdp);
        depot.setDaty(new Date());
        rtDepotBean.save(depot);
        
        return "/JSF/Produit/retraite/depot?idContrat="+id+"";
    }

    
    
    
    public RtDepot getDepot() {
        return depot;
    }

    public void setDepot(RtDepot depot) {
        this.depot = depot;
    }

    /**
     * Creates a new instance of DepotRetraiteMB
     */
    
    
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

  
    
    
    private String nocompte;
    private String mdp;
    
    /**
     * Creates a new instance of PaiementMB
  **/
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
    
    
    public DepotRetraiteMB() {
    }

}
