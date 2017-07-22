/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.RtContrat;
import entity.RtDepot;
import entity.SouscriptionProduit;
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
public class RetraiteBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void save(RtContrat contrat, SouscriptionProduit produit) {
        em.persist(contrat);
        em.persist(produit);
    }
    
    public void depot(RtDepot depot) {
        em.persist(depot);
        
    }
    public RtContrat findById(Integer id){
        Query cl = em.createNamedQuery("RtContrat.findById");
        cl.setParameter("id", id);
        System.out.println(""+id);
        return (RtContrat) cl.getResultList().get(0);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
