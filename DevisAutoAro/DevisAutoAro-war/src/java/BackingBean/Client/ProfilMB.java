/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Client;

import EJB.ProfilBean;
import entity.Client;
import entity.SouscriptionProduit;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kiashi
 */
@Named(value = "profilMB")
@RequestScoped
public class ProfilMB {

    @EJB
    private ProfilBean profilBean;

    private Client client = new Client();
    private List<SouscriptionProduit> listeContrat;
    SouscriptionProduit souscription = new SouscriptionProduit();

    public SouscriptionProduit getSouscription() {
        return souscription;
    }

    public void setSouscription(SouscriptionProduit souscription) {
        this.souscription = souscription;
    }

    public List<SouscriptionProduit> getListeContrat() {
        if (listeContrat == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            client = (Client) context.getExternalContext().getSessionMap().get("clientSession");
            listeContrat = profilBean.getListContratClient(client.getId());
        }
        return listeContrat;
    }

    public void setListeContrat(List<SouscriptionProduit> listeContrat) {
        this.listeContrat = listeContrat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Creates a new instance of ProfilMB
     */
    public ProfilMB() {
    }

    public String information() {
        FacesContext context = FacesContext.getCurrentInstance();
        client = (Client) context.getExternalContext().getSessionMap().get("clientSession");
        profilBean.getInformationClient(client.getId());
        return "/JSF/Front/profil?faces-redirect=true";
    }

   
}
