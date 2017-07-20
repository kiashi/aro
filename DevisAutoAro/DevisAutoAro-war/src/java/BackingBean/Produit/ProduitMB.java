/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Produit;

import EJB.ProduitBean;
import entity.Produit;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author kiashi
 */
@Named(value = "produitMB")
@RequestScoped
public class ProduitMB {

    @EJB
    private ProduitBean produitBean;

    private List<Produit> listeProduit;

    public List<Produit> getListeProduit() {
        if(listeProduit==null){
            listeProduit=produitBean.getAll();
        }
        return listeProduit;
    }

    public void setListeProduit(List<Produit> listeProduit) {
        this.listeProduit = listeProduit;
    }

    
    /**
     * Creates a new instance of ProduitMB
     */
    public ProduitMB() {
    }
    
}
