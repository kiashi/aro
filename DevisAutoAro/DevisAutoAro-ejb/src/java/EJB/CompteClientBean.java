/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.Compteclient;
import entity.Historiquepaiement;
import entity.SouscriptionProduit;
import java.util.Date;
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
public class CompteClientBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void payer(SouscriptionProduit produit,Double montant, String NoCompte, String mdp) {
        Compteclient c = new Compteclient();
        Historiquepaiement historique = new Historiquepaiement();
        Query query = em.createQuery("SELECT c FROM Compteclient c WHERE c.noclient = :nocompte and c.mdp = :mdp ");
        query.setParameter("nocompte", NoCompte);
        query.setParameter("mdp", mdp);
        c = (Compteclient) query.getSingleResult();
        if (c.getSolde() >= montant) {
            System.out.println("_________solde"+c.getSolde());
            System.out.println("_________vola aloha"+montant);
            produit.setValide(1);
            c.setSolde(c.getSolde() - montant);
            historique.setDateoperation(new Date());
            historique.setMontant(montant);
            historique.setMotif("Paiment Bancaire");
            historique.setSouscriptionProduitId(produit);
            
            System.out.println("_________solde"+c.getSolde());
            System.out.println("_________vola aloha"+montant);
            Double i=c.getSolde()-produit.getPrimetotal();
            System.out.println("_________vola ambony"+i);
            em.merge(produit);
            em.merge(c);
            em.persist(historique);
        }

    }

    public SouscriptionProduit findBySouscriptionId(Integer id) {
        Query cl = em.createNamedQuery("SouscriptionProduit.findById");
        cl.setParameter("id", id);

        return (SouscriptionProduit) cl.getSingleResult();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
