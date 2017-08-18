/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.sinistre;

import EJB.SinistreBean;
import entity.AmSinistre;
import entity.SinCategorie;
import entity.SouscriptionProduit;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import util.MessageUtil;

/**
 *
 * @author misa
 */
@Named(value = "declarationSinistreMB")
@RequestScoped
public class DeclarationSinistreMB {

    @EJB
    private SinistreBean sinistreBean;

    private Integer idSouscription;
    private AmSinistre nouveauSinistre = new AmSinistre();
    private List<SinCategorie> listeCategories;

    /**
     * Creates a new instance of DeclarationSinistreMB
     */
    public DeclarationSinistreMB() {
    }

    public String declarerSinistre(Integer idSouscr) {
        try {
            SouscriptionProduit souscription = new SouscriptionProduit();
            souscription.setId(idSouscr);
            nouveauSinistre.setDemande(0);
            nouveauSinistre.setTermine(0);
            nouveauSinistre.setSouscriptionProduitId(souscription);
            nouveauSinistre = sinistreBean.saveSinistre(nouveauSinistre);
            System.out.println("new id"+nouveauSinistre.getId());
            MessageUtil.addFlashInfoMessage("Initialisation de la déclaration faite. Veuillez remplir les autres données requises pour la finalisation de la déclaration du sinistre.");
            return "/JSF/Produit/auto-moto/ficheSinistre.xhtml?idSinistre="+nouveauSinistre.getId()+"&faces-redirect=true";
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }

        
    }

    public Integer getIdSouscription() {
        return idSouscription;
    }

    public void setIdSouscription(Integer idSouscription) {
        this.idSouscription = idSouscription;
    }

    public AmSinistre getNouveauSinistre() {
        return nouveauSinistre;
    }

    public void setNouveauSinistre(AmSinistre nouveauSinistre) {
        this.nouveauSinistre = nouveauSinistre;
    }

    private Converter categorieConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return sinistreBean.getCategorieById(new Integer(value));
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            SinCategorie cat = (SinCategorie) value;
            return cat.getId() + "";
        }
    };

    public Converter getCategorieConverter() {
        return categorieConverter;
    }

    public void setCategorieConverter(Converter categorieConverter) {
        this.categorieConverter = categorieConverter;
    }

    public List<SinCategorie> getListeCategories() {
        if (listeCategories == null) {
            listeCategories = sinistreBean.getCategories();
        }
        return listeCategories;
    }

    public void setListeCategories(List<SinCategorie> listeCategories) {
        this.listeCategories = listeCategories;
    }

}
