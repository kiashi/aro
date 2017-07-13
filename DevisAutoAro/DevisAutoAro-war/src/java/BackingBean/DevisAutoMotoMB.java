/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import EJB.AmGarantiBean;
import EJB.DevisAutoBean;
import entity.AmCategorietarifaire;
import entity.AmGaranti;
import entity.SaisieGaranti;
import entity.Vehicule;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author kiashi
 */
@Named(value = "devisAutoMotoMB")
@RequestScoped
public class DevisAutoMotoMB {

    @EJB
    private AmGarantiBean amGarantiBean;

    @EJB
    private DevisAutoBean devisAutoBean;
    
    private Double prime = new Double(0);
    

    /**
     * Creates a new instance of DevisAutoMotoMB
     */
    private List<SaisieGaranti> listeSaisieGaranti;

    public List<SaisieGaranti> getListeSaisieGaranti() {
        if(listeSaisieGaranti==null){
            listeSaisieGaranti = new ArrayList<SaisieGaranti>();
            List<AmGaranti> listeGaranti=  amGarantiBean.findAll();
            for(AmGaranti a:listeGaranti){
                SaisieGaranti b = new SaisieGaranti();
                b.setA(a);
                b.setActif(Boolean.FALSE);
                b.setLimite(new Double(0));
                b.setPrimeNette(new Double(0));
                listeSaisieGaranti.add(b);
            }
        }
        return listeSaisieGaranti;
    }

    public void setListeSaisieGaranti(List<SaisieGaranti> listeSaisieGaranti) {
        this.listeSaisieGaranti = listeSaisieGaranti;
    }
    
    

   
    private Vehicule auto= new Vehicule();
    public DevisAutoMotoMB() {
        
    }
   

    public Vehicule getAuto() {
        if(auto.getCategorieTarifaire()==null){
            AmCategorietarifaire amc = new AmCategorietarifaire();
            amc.setIdcodetarifaire(1);
            auto.setCategorieTarifaire(amc);
        }
        return auto;
    }

    public void setAuto(Vehicule auto) {
        this.auto = auto;
    }
    public void calculer(){
        System.out.println("---------"+auto.getSourceEnergie());
        System.out.println("---------"+auto.getNbPlace());
        System.out.println("---------"+auto.getPuissanceFiscale());
        
        prime = devisAutoBean.calculDevis(auto, listeSaisieGaranti);
        System.out.println("_________"+prime);
    }

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }
    
}
