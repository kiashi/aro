/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.RtOptionRetrait;
import entity.RtPeriodiciteCotisation;
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
public class RtPeriodiciteCotisationBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

     public RtPeriodiciteCotisation findById(Integer id) {
        Query cl = em.createNamedQuery("RtPeriodiciteCotisation.findById");
        cl.setParameter("id", id);
        return (RtPeriodiciteCotisation) cl.getResultList().get(0);
    }
     public List<RtPeriodiciteCotisation> findAll() {
        Query cl = em.createNamedQuery("RtPeriodiciteCotisation.findAll");
        return (List<RtPeriodiciteCotisation>) cl.getResultList();

    }
}
