/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Client;

import EJB.ClTypeBean;
import EJB.ClientBean;
import entity.Agence;
import entity.ClType;
import entity.Client;
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
 * @author kiashi
 */
@Named(value = "clientMB")
@RequestScoped
public class ClientMB {

    @EJB
    private ClTypeBean clTypeBean;

    @EJB
    private ClientBean clientBean;
    
    

    
    private Client client = new Client();
    

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String connectClient() {
        Client cli = clientBean.findClient(client.getEmail(), client.getMdp());
        
        if (cli != null) {
            System.out.println("____"+client.getEmail() +client.getMdp());
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("clientSession", cli);
            Client a= (Client)context.getExternalContext().getSessionMap().get("clientSession");
           
            System.out.println("______"+a.getEmail() +a.getMdp());
            return "/JSF/Front/accueil?faces-redirect=true";
            
        } else {
            return "/JSF/Front/accueil?faces-redirect=true";
        }
    }

    
    
    /**
     * Creates a new instance of ClientMB
     */
    public ClientMB() {
    }
    
    public String ajouterClient() {
        System.out.println("___________"+client);
        Agence agence = new Agence();
        
        //fixe type client
        ClType type = new ClType();
        type.setId(1);
        //fin
        
        agence.setId(1);
       
        client.setClType(type);
        client.setAgence(agence);
        clientBean.save(client);

        MessageUtil.addFlashInfoMessage("Ajouter");
        return "/JSF/Front/accueil?faces-redirect=true";
    }
    private List<ClType> listeTypeClient;

    public List<ClType> getListeTypeClient() {
        return listeTypeClient;
    }

    public void setListeTypeClient(List<ClType> listeTypeClient) {
        this.listeTypeClient = listeTypeClient;
    }
    private ClType cltypeSelect;

    public ClType getCltypeSelect() {
        if(listeTypeClient == null){
            listeTypeClient = clTypeBean.findAll();
        }
        return cltypeSelect;
    }

    public Converter getCltypeConverter() {
        return cltypeConverter;
    }

    public void setCltypeConverter(Converter cltypeConverter) {
        this.cltypeConverter = cltypeConverter;
    }

    public void setCltypeSelect(ClType cltypeSelect) {
        this.cltypeSelect = cltypeSelect;
    }

    private Converter cltypeConverter = new Converter() {
        /**
         * Convertit une String en Magasin.
         *
         * @param value valeur à convertir
         */
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return clTypeBean.findById(new Integer(value));
        }

        /**
         * Convertit un Magasin en String.
         *
         * @param value valeur à convertir
         */
        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            ClType catTarifaire = (ClType) value;
            return catTarifaire.getId() + "";
        }
    };
}
