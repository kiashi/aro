/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.RtOptionRetrait;
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
public class RtOptionRetraitBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

     public RtOptionRetrait findById(Integer id) {
        Query cl = em.createNamedQuery("RtOptionRetrait.findById");
        cl.setParameter("id", id);
        return (RtOptionRetrait) cl.getResultList().get(0);
    }
     public List<RtOptionRetrait> findAll() {
        Query cl = em.createNamedQuery("RtOptionRetrait.findAll");
        return (List<RtOptionRetrait>) cl.getResultList();

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
