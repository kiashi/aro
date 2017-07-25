/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.Client;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
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
public class ClientBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void save(Client client) {

        em.persist(client);
    }

    public Client findClient(String login, String mdp) {
        try {
            Query query = em.createQuery("SELECT c FROM Client c WHERE c.email = :login and c.mdp = :mdp ");
            query.setParameter("login", login);
            query.setParameter("mdp", mdp);
            return ((Client) query.getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Client findById(Integer id) {
        Query cl = em.createNamedQuery("Client.findById");
        cl.setParameter("id", id);
        return (Client) cl.getResultList().get(0);
    }

    public List<Client> findAll() {
        Query cl = em.createNamedQuery("Client.findAll");
        return (List<Client>) cl.getResultList();

    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

   
}
