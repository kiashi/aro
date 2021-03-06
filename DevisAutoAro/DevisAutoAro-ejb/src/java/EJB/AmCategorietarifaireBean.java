/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.AmCategorietarifaire;
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
public class AmCategorietarifaireBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public AmCategorietarifaire findByRoues(Integer nbRoues){
        Query query = em.createQuery("SELECT c FROM AmCategorietarifaire c WHERE"
                + " c.nbrouesmin <= :nbroues "
                + "AND c.nbrouesmax >= :nbroues");
        query.setParameter("nbroues", nbRoues);
        return (AmCategorietarifaire) query.getSingleResult();
    }

//    public List<AmCategorietarifaire> findByRoues(Integer a) {
//        Query cl = em.createQuery("SELECT p FROM AmCategorietarifaire p WHERE "
//                + " p.nbrouesmin <= :roues"
//                + " AND p.nbrouesmax >= :roues");
//        cl.setParameter("roues", a);
//
//        return (List<AmCategorietarifaire>) cl.getResultList();
//
//    }

    public AmCategorietarifaire findById(Integer id) {
        Query cl = em.createNamedQuery("AmCategorietarifaire.findById");
        cl.setParameter("id", id);
        return (AmCategorietarifaire) cl.getResultList().get(0);
    }

    public List<AmCategorietarifaire> findAll() {
        Query cl = em.createNamedQuery("AmCategorietarifaire.findAll");
        return (List<AmCategorietarifaire>) cl.getResultList();

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
