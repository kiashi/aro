/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.sinistre;

import EJB.SinistreBean;
import entity.AmSinistre;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import util.Util;

/**
 *
 * @author misa
 */
@Named(value = "listeSinistreMB")
@ViewScoped
public class ListeSinistreMB implements Serializable{

    @EJB
    private SinistreBean sinistreBean;
    
    private Util util = new Util();

    private List<AmSinistre> listeSinistres;
    private Integer idSouscription;

    /**
     * Creates a new instance of ListeSinistreMB
     */
    public ListeSinistreMB() {
    }


    public List<AmSinistre> getListeSinistres() {
        if(listeSinistres == null){
            listeSinistres = sinistreBean.getSinistresBySouscription(idSouscription);
        }
        return listeSinistres;
    }

    public void setListeSinistres(List<AmSinistre> listeSinistres) {
        this.listeSinistres = listeSinistres;
    }

    public Integer getIdSouscription() {
        return idSouscription;
    }

    public void setIdSouscription(Integer idSouscription) {
        this.idSouscription = idSouscription;
    }

    public Util getUtil() {
        return util;
    }

    public void setUtil(Util util) {
        this.util = util;
    }
    

}
