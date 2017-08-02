/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Produit;

import EJB.AmContratBean;
import entity.AmGarantiVehicule;
import entity.AmVehicule;
import entity.SouscriptionProduit;
import entity.Vehicule;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author kiashi
 */
@Named(value = "amContrat")
@RequestScoped
public class AmContrat {

    @EJB
    private AmContratBean amContratBean;

    
    SouscriptionProduit souscription= new SouscriptionProduit();
    AmVehicule vehicule;
    private List<AmGarantiVehicule> listegaranti;
     private int idContrat;
    
     public void loadContrat() {
        this.souscription = amContratBean.findSouscriptionByID(new Integer(idContrat));
    }

    public SouscriptionProduit getSouscription() {
        if(souscription==null){
            souscription = amContratBean.findSouscriptionByID(idContrat);
        }
        return souscription;
    }

    public void setSouscription(SouscriptionProduit souscription) {
        this.souscription = souscription;
    }

    public AmVehicule getVehicule() {
        if(vehicule==null){
            vehicule = amContratBean.findVehiculeBySouscriptionID(idContrat);
            System.out.println("--------SE"+vehicule.getSourceEnergie());
        }
        return vehicule;
    }

    public void setVehicule(AmVehicule vehicule) {
        this.vehicule = vehicule;
    }

    public List<AmGarantiVehicule> getListegaranti() {
        if(listegaranti==null){
            listegaranti=amContratBean.findGarantiBySouscriptionID(idContrat);
        }
        return listegaranti;
    }

    public void setListegaranti(List<AmGarantiVehicule> listegaranti) {
        this.listegaranti = listegaranti;
    }

    public int getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }
    
     
    /**
     * Creates a new instance of AmContrat
     */
    public AmContrat() {
    }
    
}
