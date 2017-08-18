package BackingBean.sinistre;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import EJB.SinistreBean;
import entity.AmDommage;
import entity.AmSinistre;
import entity.AmVehicule;
import entity.DommagesSinistre;
import entity.PhotoSinistre;
import entity.SinRapport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import util.FileUtil;
import util.MessageUtil;
import util.Util;

/**
 *
 * @author misa
 */
@Named(value = "ficheSinistreMB")
@ViewScoped
public class FicheSinistreMB implements Serializable {

    @EJB
    private SinistreBean sinistreBean;

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

    private String etat;

    private String classDommage;
    private String classCirconstance;
    private String classPhotos;

    /**
     * Creates a new instance of FicheSinistreMB
     */
    public FicheSinistreMB() {
    }

    public void initData() {
        sinistre = sinistreBean.getSinistreById(idSinistre);
        photos = sinistreBean.getPhotosBySinistre(idSinistre);
        dommages = sinistreBean.getDommagesBySinistre(idSinistre);
        rapports = sinistreBean.getRapportBySinistre(idSinistre);
        vehicule = sinistreBean.getVehiculeByIdSouscription(sinistre.getSouscriptionProduitId().getId());
        estDeclarationTerminee();
    }

    private Converter dommageConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return sinistreBean.getDommagesById(new Integer(value));
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            AmDommage cat = (AmDommage) value;
            return cat.getId() + "";
        }
    };

    public void ajouterDommage(Integer sinistreId) {
        sinistreBean.saveDommageSinistre(sinistreId, dommageSelected.getId());
        dommages = sinistreBean.getDommagesBySinistre(sinistreId);
        idSinistre = sinistreId;
        estDeclarationTerminee();
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            UploadedFile file = event.getFile();

            File f = new File(file.getFileName());
            FileOutputStream fos = new FileOutputStream(f);
            InputStream is = file.getInputstream();
            int BUFFER_SIZE = 8192;
            byte[] buffer = new byte[BUFFER_SIZE];
            int a;
            while (true) {
                a = is.read(buffer);
                if (a < 0) {
                    break;
                }
                fos.write(buffer, 0, a);
                fos.flush();
            }
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String newname = fmt.format(new Date())
                    + event.getFile().getFileName().substring(
                            event.getFile().getFileName().lastIndexOf('.'));

            Path fileToCpy = Paths.get(f.getAbsolutePath());
            Path fileCopy = Paths.get(FileUtil.pathPhotoSinistre + newname);
            Path newFile = Files.copy(fileToCpy, fileCopy);

            sinistreBean.savePhotoSinistre(idSinistre, newname);
            photos = sinistreBean.getPhotosBySinistre(idSinistre);
            estDeclarationTerminee();
            fos.close();
            is.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void validEditCirconstance() {
        sinistreBean.updateSinistre(sinistre);
        estDeclarationTerminee();
        MessageUtil.addFlashInfoMessage("Action effectuée");
    }

    public void estDeclarationTerminee() {
        int ok = 0;

        if (photos.size() != 0) {

            ok++;
        } else {
            classPhotos = "mdl-badge";
        }
        if (dommages.size() != 0) {

            ok++;
        } else {
            classDommage = "mdl-badge";
        }

        if (sinistre.getDetails()!=null && !sinistre.getDetails().isEmpty()) {

            ok++;
        } else {
            classCirconstance = "mdl-badge";
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
            etat = "Déclaration envoyée. Attente des rapports d'expertise.";
        }
        if (sinistre.getTermine() == 1) {
            etat = "Terminée";
        }
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getClassDommage() {
        return classDommage;
    }

    public void setClassDommage(String classDommage) {
        this.classDommage = classDommage;
    }

    public String getClassCirconstance() {
        return classCirconstance;
    }

    public void setClassCirconstance(String classCirconstance) {
        this.classCirconstance = classCirconstance;
    }

    public String getClassPhotos() {
        return classPhotos;
    }

    public void setClassPhotos(String classPhotos) {
        this.classPhotos = classPhotos;
    }

    public Integer getIdSinistre() {
        return idSinistre;
    }

    public void setIdSinistre(Integer idSinistre) {
        this.idSinistre = idSinistre;
    }

    public AmSinistre getSinistre() {
        return sinistre;
    }

    public void setSinistre(AmSinistre sinistre) {
        this.sinistre = sinistre;

    }

    public List<DommagesSinistre> getDommages() {
        if (dommages == null) {
            dommages = sinistreBean.getDommagesBySinistre(idSinistre);
        }
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

    public AmVehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(AmVehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Util getUtil() {
        return util;
    }

    public void setUtil(Util util) {
        this.util = util;
    }

    public List<AmDommage> getListeAmDommages() {
        if (listeAmDommages == null) {
            listeAmDommages = sinistreBean.getDommages();
        }
        return listeAmDommages;
    }

    public void setListeAmDommages(List<AmDommage> listeAmDommages) {
        this.listeAmDommages = listeAmDommages;
    }

    public Converter getDommageConverter() {
        return dommageConverter;
    }

    public void setDommageConverter(Converter dommageConverter) {
        this.dommageConverter = dommageConverter;
    }

    public AmDommage getDommageSelected() {
        return dommageSelected;
    }

    public void setDommageSelected(AmDommage dommageSelected) {
        this.dommageSelected = dommageSelected;
    }

    public FileUtil getFileUtil() {
        return fileUtil;
    }

    public void setFileUtil(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

}
