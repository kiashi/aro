/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.AmPrime;
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
public class AmPrimeBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<AmPrime> findByVehicule(Vehicule a){
      Query cl= em.createQuery("SELECT p FROM AmPrime p WHERE "
              + "  p.puissmin <= :puissance"
              + " AND p.puissmax >= :puissance"
              + " AND p.idcodetarifaire.idcodetarifaire = :idcat");
      //cl.setParameter("se", a.getSourceEnergie());
      cl.setParameter("puissance", a.getPuissanceFiscale());
      cl.setParameter("idcat", a.getCategorieTarifaire().getIdcodetarifaire());
      return (List<AmPrime>) cl.getResultList();
        
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
}
