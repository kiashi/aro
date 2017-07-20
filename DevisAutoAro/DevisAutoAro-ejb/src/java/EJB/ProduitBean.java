/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.Produit;
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
public class ProduitBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void save(Produit produit) {
        em.persist(produit);
    }
    
    public List<Produit> getAll(){
        Query query = em.createQuery("SELECT c FROM Produit c");
        return (List<Produit>)query.getResultList();
    }
    
    public Produit findById(Integer id){
        Query cl = em.createNamedQuery("Produit.findById");
        cl.setParameter("id", id);
        return (Produit) cl.getResultList().get(0);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
