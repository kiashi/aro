/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Produit;

import EJB.AutoMotoBean;
import EJB.ProduitBean;
import entity.Client;
import entity.Produit;
import entity.RtContrat;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import util.MessageUtil;

/**
 *
 * @author kiashi
 */
@Named(value = "autoMotoMB")
@RequestScoped
public class AutoMotoMB {

    @EJB
    private AutoMotoBean autoMotoBean;

    @EJB
    private ProduitBean produitBean;

    /**
     * Creates a new instance of AutoMotoMB
     */
    public AutoMotoMB() {
    }
    private Produit produit;
    private int idProduit;

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void loadProduit() {
        this.produit = produitBean.findById(new Integer(idProduit));
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String ajouterContratAutoMoto() {
        FacesContext context = FacesContext.getCurrentInstance();
        Client c = (Client) context.getExternalContext().getSessionMap().get("clientSession");
        RtContrat contrat = new RtContrat();
        contrat.setClient(c);

        //autoMotoBean.save(contrat);

        MessageUtil.addFlashInfoMessage("Ajouter");
        return "/JSF/Front/contrat?faces-redirect=true";
    }

}
