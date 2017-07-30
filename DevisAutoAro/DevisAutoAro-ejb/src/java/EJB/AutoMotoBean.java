/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.AmGarantiVehicule;
import entity.AmVehicule;
import entity.RtContrat;
import entity.SouscriptionProduit;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kiashi
 */
@Stateless
@LocalBean
public class AutoMotoBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void save(AmVehicule vehicule, AmGarantiVehicule garanti) {
        SouscriptionProduit p =new SouscriptionProduit();
        AmVehicule v=em.merge(vehicule);
        AmGarantiVehicule garantiVehicule = em.merge(garanti);
        
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
