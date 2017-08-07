/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.Produit;

import EJB.RetraiteBean;
import entity.RtContrat;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author kiashi
 */
@Named(value = "rtRachatMB")
@RequestScoped
public class RtRachatMB {

    public int getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }

    public RtContrat getContrat() {
        return contrat;
    }

    public void setContrat(RtContrat contrat) {
        this.contrat = contrat;
    }

    @EJB
    private RetraiteBean retraiteBean;

    /**
     * Creates a new instance of RtRachatMB
     */
    
     private int idContrat;
     private RtContrat contrat = new RtContrat();
      public void loadContrat() {
        this.contrat = retraiteBean.findBySouscriptionId(new Integer(idContrat));
    }
    public RtRachatMB() {
    }
    
    
}
