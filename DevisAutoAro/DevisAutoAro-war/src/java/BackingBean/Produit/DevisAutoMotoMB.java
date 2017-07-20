/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Produit;

import EJB.AmCategorietarifaireBean;
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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author kiashi
 */
@Named(value = "devisAutoMotoMB")
@RequestScoped
public class DevisAutoMotoMB {

    @EJB
    private AmCategorietarifaireBean amCategorietarifaireBean;

    @EJB
    private AmGarantiBean amGarantiBean;

    @EJB
    private DevisAutoBean devisAutoBean;

    private Double prime = new Double(0);

    private Integer dureeMois = 12;
    
    private Double tauxE = new Double(0);
    private Double tauxVA = new Double(0);
    private Double primeTotal = new Double(0);

    public Double getTauxE() {
        return tauxE;
    }

    public void setTauxE(Double tauxE) {
        this.tauxE = tauxE;
    }

    public Double getTauxVA() {
        return tauxVA;
    }

    public void setTauxVA(Double tauxVA) {
        this.tauxVA = tauxVA;
    }

    public Double getPrimeTotal() {
        return primeTotal;
    }

    public void setPrimeTotal(Double primeTotal) {
        this.primeTotal = primeTotal;
    }

    

    /**
     * Creates a new instance of DevisAutoMotoMB
     */
    private List<SaisieGaranti> listeSaisieGaranti;
    private List<AmCategorietarifaire> listeCategorieTarifaire;
    private AmCategorietarifaire categorieTarifaireSelect;

    private Converter catTarifaireConverter = new Converter() {
        /**
         * Convertit une String en Magasin.
         *
         * @param value valeur à convertir
         */
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return amCategorietarifaireBean.findById(new Integer(value));
        }

        /**
         * Convertit un Magasin en String.
         *
         * @param value valeur à convertir
         */
        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            AmCategorietarifaire catTarifaire = (AmCategorietarifaire) value;
            return catTarifaire.getId() + "";
        }
    };

    public List<SaisieGaranti> getListeSaisieGaranti() {
        if (listeSaisieGaranti == null) {
            listeSaisieGaranti = new ArrayList<SaisieGaranti>();
            List<AmGaranti> listeGaranti = amGarantiBean.findAll();
            for (AmGaranti a : listeGaranti) {
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

    private Vehicule auto = new Vehicule();

    public DevisAutoMotoMB() {

    }

    public Vehicule getAuto() {
        if (auto.getCategorieTarifaire() == null) {
            AmCategorietarifaire amc = new AmCategorietarifaire();
            amc.setId(1);
            auto.setCategorieTarifaire(amc);
        }
        return auto;
    }

    public void setAuto(Vehicule auto) {
        this.auto = auto;
    }

    public void calculer() {
        System.out.println("---------" + auto.getSourceEnergie());
        System.out.println("---------" + auto.getNbPlace());
        System.out.println("---------" + auto.getPuissanceFiscale());
        auto.setCategorieTarifaire(categorieTarifaireSelect);
        prime = devisAutoBean.calculDevis(auto, listeSaisieGaranti, dureeMois);
        primeTotal= (prime*tauxE)+(prime*tauxVA);
        //System.out.println("_______" + primeTotal);
        System.out.println("_________" + prime);
    }

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }

    public Integer getDureeMois() {
        return dureeMois;
    }

    public void setDureeMois(Integer dureeMois) {
        this.dureeMois = dureeMois;
    }

    public List<AmCategorietarifaire> getListeCategorieTarifaire() {
        if (listeCategorieTarifaire == null) {
            listeCategorieTarifaire = amCategorietarifaireBean.findAll();
        }
        return listeCategorieTarifaire;
    }

    public void setListeCategorieTarifaire(List<AmCategorietarifaire> listeCategorieTarifaire) {
        this.listeCategorieTarifaire = listeCategorieTarifaire;
    }

    public AmCategorietarifaire getCategorieTarifaireSelect() {
        return categorieTarifaireSelect;
    }

    public void setCategorieTarifaireSelect(AmCategorietarifaire categorieTarifaireSelect) {
        this.categorieTarifaireSelect = categorieTarifaireSelect;
    }

    public Converter getCatTarifaireConverter() {
        return catTarifaireConverter;
    }

    public void setCatTarifaireConverter(Converter catTarifaireConverter) {
        this.catTarifaireConverter = catTarifaireConverter;
    }

}
