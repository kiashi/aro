/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.bo.sinistre;

import EJB.SinistreBean;
import entity.SinistresView;
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
@Named(value = "listeSinistreBoMB")
@ViewScoped
public class ListeSinistreBoMB implements Serializable{

    @EJB
    private SinistreBean sinistreBean;

    private List<SinistresView> sinistres;
    private Util util = new Util();
    
    /**
     * Creates a new instance of ListeSinistreBoMB
     */
    public ListeSinistreBoMB() {
    }
    

    public List<SinistresView> getSinistres() {
        if(sinistres == null){
            sinistres = sinistreBean.getAllView();
        }
        return sinistres;
    }

    public void setSinistres(List<SinistresView> sinistres) {
        this.sinistres = sinistres;
    }

    public Util getUtil() {
        return util;
    }

    public void setUtil(Util util) {
        this.util = util;
    }
    
    
    
}
