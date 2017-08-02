/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.AmGarantiVehicule;
import entity.AmVehicule;
import entity.SouscriptionProduit;
import entity.Vehicule;
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
public class AmContratBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
     public SouscriptionProduit findSouscriptionByID(Integer id) {
        try {
            Query query = em.createQuery("SELECT c FROM SouscriptionProduit c WHERE c.id = :id");
            query.setParameter("id", id);
          
            return ((SouscriptionProduit) query.getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     public List<AmGarantiVehicule> findGarantiBySouscriptionID(Integer id) {
        try {
            Query query = em.createQuery("SELECT c FROM AmGarantiVehicule c WHERE c.souscriptionProduitId.id = :id");
            query.setParameter("id", id);
          
            return ((List<AmGarantiVehicule>) query.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     public AmVehicule findVehiculeBySouscriptionID(Integer id) {
        try {
            Query query = em.createQuery("SELECT c FROM AmVehicule c WHERE c.souscriptionProduit.id = :id");
            query.setParameter("id", id);
          
            return ((AmVehicule) query.getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
