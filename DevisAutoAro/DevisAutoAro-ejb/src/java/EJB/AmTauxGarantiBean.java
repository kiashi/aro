/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.AmTauxgaranti;
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
public class AmTauxGarantiBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<AmTauxgaranti> findByTaux(Integer idCodetarifaire, Integer idgaranti){
      Query cl= em.createQuery("SELECT p FROM AmTauxgaranti p WHERE p.idcodetarifaire.idcodetarifaire = :tarif "
              + "AND p.idamgaranti.idamgaranti <= :garanti");
      cl.setParameter("tarif", idCodetarifaire);
      cl.setParameter("garanti", idgaranti);
     
      return (List<AmTauxgaranti>) cl.getResultList();
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
