/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.bo.sinistre;

import EJB.AmContratBean;
import EJB.SinistreBean;
import entity.AmDommage;
import entity.AmGarantiVehicule;
import entity.AmSinistre;
import entity.AmVehicule;
import entity.DommagesSinistre;
import entity.PhotoSinistre;
import entity.SinRapport;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import util.FileUtil;
import util.Util;

/**
 *
 * @author misa
 */
@Named(value = "ficheSinistreBoMB")
@ViewScoped
public class FicheSinistreBoMB implements Serializable {

    @EJB
    private SinistreBean sinistreBean;
    @EJB
    private AmContratBean amContratBean;

    private Util util = new Util();

    private AmSinistre sinistre;
    private AmVehicule vehicule;
    private List<DommagesSinistre> dommages;
    private List<SinRapport> rapports;
    private List<PhotoSinistre> photos;

    private List<AmDommage> listeAmDommages;
    private AmDommage dommageSelected;

    private Integer idSinistre;
    private FileUtil fileUtil;

    private String nouveauRapport;

    private List<AmGarantiVehicule> listegaranti;
    private String etat;

    public void initData() {
        sinistre = sinistreBean.getSinistreById(idSinistre);
        photos = sinistreBean.getPhotosBySinistre(idSinistre);
        dommages = sinistreBean.getDommagesBySinistre(idSinistre);
        rapports = sinistreBean.getRapportBySinistre(idSinistre);
        vehicule = sinistreBean.getVehiculeByIdSouscription(sinistre.getSouscriptionProduitId().getId());
        estDeclarationTerminee();
    }

    public void ajouterRapport(Integer sinistreid) {
        AmSinistre sin = new AmSinistre();
        sin.setId(idSinistre);
        SinRapport rap = new SinRapport();
        rap.setAmSinistreId(sin);
        rap.setDescription(nouveauRapport);
        sinistreBean.ajouterRapport(rap);
        rapports = sinistreBean.getRapportBySinistre(idSinistre);
    }

    public void estDeclarationTerminee() {
        int ok = 0;

        if (photos.size() != 0) {

            ok++;
        }
        if (dommages.size() != 0) {

            ok++;
        }
        if (sinistre.getDetails() != null && !sinistre.getDetails().isEmpty()) {

            ok++;
        }
        if (ok == 3) {
            sinistre.setDemande(1);
            sinistreBean.updateSinistre(sinistre);
        }
        if (ok != 3) {
            sinistre.setDemande(0);
            sinistreBean.updateSinistre(sinistre);
        }
        checkEtat();
    }

    public void checkEtat() {
        if (sinistre.getDemande() == 0) {
            etat = "Déclaration non achevée. Veuillez remplir les autres données nécessaires";
        }
        if (sinistre.getDemande() == 1) {
            etat = "Déclaration envoyée. Attendez les rapports d'expertise.";
        }
        if (sinistre.getTermine() == 1) {
            etat = "Terminée";
        }
    }

    public Util getUtil() {
        return util;
    }

    public void setUtil(Util util) {
        this.util = util;
    }

    public AmSinistre getSinistre() {
        return sinistre;
    }

    public void setSinistre(AmSinistre sinistre) {
        this.sinistre = sinistre;
    }

    public AmVehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(AmVehicule vehicule) {
        this.vehicule = vehicule;
    }

    public List<DommagesSinistre> getDommages() {
        return dommages;
    }

    public void setDommages(List<DommagesSinistre> dommages) {
        this.dommages = dommages;
    }

    public List<SinRapport> getRapports() {
        return rapports;
    }

    public void setRapports(List<SinRapport> rapports) {
        this.rapports = rapports;
    }

    public List<PhotoSinistre> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoSinistre> photos) {
        this.photos = photos;
    }

    public List<AmDommage> getListeAmDommages() {
        return listeAmDommages;
    }

    public void setListeAmDommages(List<AmDommage> listeAmDommages) {
        this.listeAmDommages = listeAmDommages;
    }

    public AmDommage getDommageSelected() {
        return dommageSelected;
    }

    public void setDommageSelected(AmDommage dommageSelected) {
        this.dommageSelected = dommageSelected;
    }

    public Integer getIdSinistre() {
        return idSinistre;
    }

    public void setIdSinistre(Integer idSinistre) {
        this.idSinistre = idSinistre;
    }

    public FileUtil getFileUtil() {
        return fileUtil;
    }

    public void setFileUtil(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getNouveauRapport() {
        return nouveauRapport;
    }

    public void setNouveauRapport(String nouveauRapport) {
        this.nouveauRapport = nouveauRapport;
    }

    public List<AmGarantiVehicule> getListegaranti() {
        if (listegaranti == null) {
            listegaranti = amContratBean.findGarantiBySouscriptionID(sinistre.getSouscriptionProduitId().getId());
        }
        return listegaranti;
    }

    public void setListegaranti(List<AmGarantiVehicule> listegaranti) {
        this.listegaranti = listegaranti;
    }

    /**
     * Creates a new instance of FicheSinistreBoMB
     */
    public FicheSinistreBoMB() {
    }

}
