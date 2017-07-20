/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.ClType;
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
public class ClTypeBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

     public ClType findById(Integer id) {
        Query cl = em.createNamedQuery("ClType.findById");
        cl.setParameter("id", id);
        return (ClType) cl.getResultList().get(0);
    }

    public List<ClType> findAll() {
        Query cl = em.createNamedQuery("ClType.findAll");
        return (List<ClType>) cl.getResultList();

    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
