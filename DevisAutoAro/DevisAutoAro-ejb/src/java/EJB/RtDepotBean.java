/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.RtDepot;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kiashi
 */
@Stateless
@LocalBean
public class RtDepotBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void save(RtDepot depot) {
        em.persist(depot);
    }

     public List<RtDepot> findDepot(Integer idContrat) {
        Query cl = em.createQuery("SELECT c FROM RtDepot c WHERE c.rtContrat.id = :idContrat");
        cl.setParameter("idContrat", idContrat);
        return (List<RtDepot>) cl.getResultList();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
