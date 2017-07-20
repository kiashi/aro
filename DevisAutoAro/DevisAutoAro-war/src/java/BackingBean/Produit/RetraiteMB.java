/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Produit;

import EJB.ProduitBean;
import EJB.RetraiteBean;
import EJB.RtOptionRetraitBean;
import EJB.RtPeriodiciteCotisationBean;
import EJB.RtTypeBean;
import entity.Client;
import entity.Produit;
import entity.RtContrat;
import entity.RtOptionRetrait;
import entity.RtPeriodiciteCotisation;
import entity.RtType;
import entity.SouscriptionProduit;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import util.MessageUtil;
import util.Util;

/**
 *
 * @author kiashi
 */
@Named(value = "retraiteMB")
@RequestScoped
public class RetraiteMB {

    @EJB
    private RtTypeBean rtTypeBean;

    @EJB
    private RtPeriodiciteCotisationBean rtPeriodiciteCotisationBean;

    @EJB
    private RtOptionRetraitBean rtOptionRetraitBean;

    @EJB
    private RetraiteBean retraiteBean;

    @EJB
    private ProduitBean produitBean;
    
    

    
    /**
     * Creates a new instance of RetraiteMB
     */
    public RetraiteMB() {
    }
    private Produit produit= new Produit();
    private int idProduit;
    private RtContrat contrat = new RtContrat();

    public RtContrat getContrat() {
        return contrat;
    }

    public void setContrat(RtContrat contrat) {
        this.contrat = contrat;
    }

    
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
    public void loadProduit() {
        System.out.println("_________huhu"+idProduit);
        this.produit = produitBean.findById(new Integer(idProduit));
        System.out.println("azefaze"+produit.getId());
        
    }
    
     public String ajouterContratRetraite() {
        FacesContext context = FacesContext.getCurrentInstance();
        Client c = (Client) context.getExternalContext().getSessionMap().get("clientSession");
        contrat.setDaty(new Date());
        contrat.setClient(c);
        
        Util util = new Util();
        contrat.setNopolice(util.buildNoPolice());
        contrat.setRtOptionRetrait(rtOptionRetraitSelect);
        contrat.setRtPeriodiciteCotisation(rtperiodeSelect);
        contrat.setRtType(rtTypeSelect);
        
         SouscriptionProduit produitSous = new SouscriptionProduit();
         produitSous.setClient(c);
         //fixe retraite ID
         produit.setId(2);
         /*FIN*/
         produitSous.setProduit(produit);
         produitSous.setPrimenet(new Double(0));
         produitSous.setPrimetotal(new Double(0));
         produitSous.setDuree(BigInteger.valueOf(0));
         produitSous.setReduction(new Double(0));
         produitSous.setNopolice(util.buildNoPolice());
         System.out.println("_______"+produit.getId());
        retraiteBean.save(contrat,produitSous);

        MessageUtil.addFlashInfoMessage("Contrat Ajouter");
        return "/JSF/retraite/contrat?faces-redirect=true";
    }
     
     private List<RtOptionRetrait> listeOptionRetrait;
    private RtOptionRetrait rtOptionRetraitSelect;
    
     private List<RtPeriodiciteCotisation> listertperiode;
    private RtPeriodiciteCotisation rtperiodeSelect;

    public RtTypeBean getRtTypeBean() {
        return rtTypeBean;
    }

    public void setRtTypeBean(RtTypeBean rtTypeBean) {
        this.rtTypeBean = rtTypeBean;
    }

    public RtPeriodiciteCotisationBean getRtPeriodiciteCotisationBean() {
        return rtPeriodiciteCotisationBean;
    }

    public void setRtPeriodiciteCotisationBean(RtPeriodiciteCotisationBean rtPeriodiciteCotisationBean) {
        this.rtPeriodiciteCotisationBean = rtPeriodiciteCotisationBean;
    }

    public List<RtPeriodiciteCotisation> getListertperiode() {
        if(listertperiode==null){
           listertperiode= rtPeriodiciteCotisationBean.findAll();
        }
        return listertperiode;
    }

    public void setListertperiode(List<RtPeriodiciteCotisation> listertperiode) {
        this.listertperiode = listertperiode;
    }

    public RtPeriodiciteCotisation getRtperiodeSelect() {
        return rtperiodeSelect;
    }

    public void setRtperiodeSelect(RtPeriodiciteCotisation rtperiodeSelect) {
        this.rtperiodeSelect = rtperiodeSelect;
    }

    public List<RtType> getListertType() {
         if(listertType==null){
           listertType= rtTypeBean.findAll();
        }
        return listertType;
    }

    public void setListertType(List<RtType> listertType) {
        this.listertType = listertType;
    }

    public RtType getRtTypeSelect() {
        return rtTypeSelect;
    }

    public void setRtTypeSelect(RtType rtTypeSelect) {
        this.rtTypeSelect = rtTypeSelect;
    }

    public Converter getRtperiodeConverter() {
        return rtperiodeConverter;
    }

    public void setRtperiodeConverter(Converter rtperiodeConverter) {
        this.rtperiodeConverter = rtperiodeConverter;
    }

    public Converter getRtTypeConverter() {
        return rtTypeConverter;
    }

    public void setRtTypeConverter(Converter rtTypeConverter) {
        this.rtTypeConverter = rtTypeConverter;
    }
    
     private List<RtType> listertType;
    private RtType rtTypeSelect;

    public RtOptionRetraitBean getRtOptionRetraitBean() {
        return rtOptionRetraitBean;
    }

    public void setRtOptionRetraitBean(RtOptionRetraitBean rtOptionRetraitBean) {
        this.rtOptionRetraitBean = rtOptionRetraitBean;
    }

    public List<RtOptionRetrait> getListeOptionRetrait() {
        if (listeOptionRetrait == null) {
            listeOptionRetrait = rtOptionRetraitBean.findAll();
        }
        return listeOptionRetrait;
    }

    public void setListeOptionRetrait(List<RtOptionRetrait> listeOptionRetrait) {
        this.listeOptionRetrait = listeOptionRetrait;
    }

    public RtOptionRetrait getRtOptionRetraitSelect() {
        return rtOptionRetraitSelect;
    }

    public void setRtOptionRetraitSelect(RtOptionRetrait rtOptionRetraitSelect) {
        this.rtOptionRetraitSelect = rtOptionRetraitSelect;
    }

    public Converter getOptionRetraitConverter() {
        return optionRetraitConverter;
    }

    public void setOptionRetraitConverter(Converter optionRetraitConverter) {
        this.optionRetraitConverter = optionRetraitConverter;
    }

    
    private Converter optionRetraitConverter = new Converter() {
        /**
         * Convertit une String en Magasin.
         *
         * @param value valeur à convertir
         */
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return rtOptionRetraitBean.findById(new Integer(value));
        }

        /**
         * Convertit un Magasin en String.
         *
         * @param value valeur à convertir
         */
        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            RtOptionRetrait catTarifaire = (RtOptionRetrait) value;
            return catTarifaire.getId() + "";
        }
    };

    
    
     private Converter rtperiodeConverter = new Converter() {
        /**
         * Convertit une String en Magasin.
         *
         * @param value valeur à convertir
         */
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return rtPeriodiciteCotisationBean.findById(new Integer(value));
        }

        /**
         * Convertit un Magasin en String.
         *
         * @param value valeur à convertir
         */
        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            RtPeriodiciteCotisation catTarifaire = (RtPeriodiciteCotisation) value;
            return catTarifaire.getId() + "";
        }
    };
 private Converter rtTypeConverter = new Converter() {
        /**
         * Convertit une String en Magasin.
         *
         * @param value valeur à convertir
         */
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return rtTypeBean.findById(new Integer(value));
        }

        /**
         * Convertit un Magasin en String.
         *
         * @param value valeur à convertir
         */
        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            RtType catTarifaire = (RtType) value;
            return catTarifaire.getId() + "";
        }
    };
 
}
