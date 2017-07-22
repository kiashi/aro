/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.Client;
import entity.SouscriptionProduit;
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
public class ProfilBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Client getInformationClient(Integer idClient) {
        try {

            Query cl = em.createQuery("SELECT c FROM Client c WHERE c.id = :idClient");
            cl.setParameter("idClient", idClient);
            return (Client) cl.getSingleResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<SouscriptionProduit> getListContratClient(Integer idClient) {
        try {

            Query cl = em.createQuery("SELECT c FROM SouscriptionProduit c WHERE c.client.id = :idClient");
            cl.setParameter("idClient", idClient);
            return (List<SouscriptionProduit>) cl.getResultList();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }
}
