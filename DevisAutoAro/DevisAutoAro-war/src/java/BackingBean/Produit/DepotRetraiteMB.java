/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Produit;

import EJB.RetraiteBean;
import entity.Client;
import entity.RtContrat;
import entity.RtDepot;
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
    private RetraiteBean retraiteBean;

    private RtContrat contrat = new RtContrat();
    private RtDepot depot = new RtDepot();

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
        this.contrat = retraiteBean.findById(new Integer(idContrat));
    }

    public String ajouterDepot() {
        depot.setRtContrat(contrat);
        System.out.println("------contrat"+contrat.getId());
         System.out.println("------depot"+depot.getId());
        return "";
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
    public DepotRetraiteMB() {
    }

}
