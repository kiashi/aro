/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Produit;

import EJB.AmGarantiBean;
import EJB.AutoMotoBean;
import EJB.ProduitBean;
import entity.AmCategorietarifaire;
import entity.AmGaranti;
import entity.Produit;
import entity.SaisieGaranti;
import entity.Vehicule;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import util.MessageUtil;

/**
 *
 * @author kiashi
 */
@Named(value = "autoMotoMB")
@RequestScoped
public class AutoMotoMB {

    @EJB
    private AmGarantiBean amGarantiBean;

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
    private List<SaisieGaranti> garanti;
    Vehicule vehicule=new Vehicule();
    private Double prime = new Double(0);

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }

    public List<SaisieGaranti> getGaranti() {
        if (garanti == null) {
            garanti = new ArrayList<SaisieGaranti>();
            List<AmGaranti> listeGaranti = amGarantiBean.findAll();
            for (AmGaranti a : listeGaranti) {
                SaisieGaranti b = new SaisieGaranti();
                b.setA(a);
                b.setActif(Boolean.FALSE);
                b.setLimite(new Double(0));
                b.setPrimeNette(new Double(0));
                garanti.add(b);
            }
        }
        return garanti;
    }

    public void setGaranti(List<SaisieGaranti> garanti) {
        this.garanti = garanti;
    }

    public Vehicule getVehicule() {
         if (vehicule.getCategorieTarifaire() == null) {
            AmCategorietarifaire amc = new AmCategorietarifaire();
            amc.setId(1);
            vehicule.setCategorieTarifaire(amc);
        }
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

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
        
        autoMotoBean.souscrireAuto(vehicule, 12, garanti);
        System.out.println("_________" + prime);
        
        MessageUtil.addFlashInfoMessage("Ajouter");
        return "/JSF/Client/contrat?faces-redirect=true";
    }

    
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
}
