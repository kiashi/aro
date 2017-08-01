/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import EJB.ProduitBean;
import entity.Produit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author LENOVO
 */
public class Actions {

    ProduitBean produitBean = lookupProduitBeanBean();

    public List<Message> listeProduit() {
        // à remplacer getAllFopla
        List<Produit> produits = produitBean.getAllFopla();
        List<Message> messages = new ArrayList<Message>();
        for (Produit p : produits) {
            Message m = new Message(0, p.getIntitule());
            List<String> boutons = new ArrayList<String>();
            boutons.add("Info");
            boutons.add("Souscrire");
            List<String> actions = new ArrayList<String>();
            actions.add("info");
            actions.add("souscrire");
        }
        return messages;
    }

    public List<Message> ficheProduit(Integer idProduit) {
        // à remplacer getAllFopla
        List<Produit> produits = produitBean.getAllFopla();
        List<Message> res = new ArrayList<Message>();
        for (Produit p : produits) {
            if (idProduit.equals(p.getId())) {
                Message m = new Message(0, p.getIntitule());
                List<String> boutons = new ArrayList<String>();
                boutons.add("Info");
                boutons.add("Souscrire");
                List<String> actions = new ArrayList<String>();
                actions.add("info");
                actions.add("souscrire");
                m.setActions(actions);
                m.setBoutons(boutons);
                res.add(m);
                return res;
            }
        }
        return res;
    }

    private ProduitBean lookupProduitBeanBean() {
        try {
            Context c = new InitialContext();
            return (ProduitBean) c.lookup("java:global/DevisAutoAro/DevisAutoAro-ejb/ProduitBean!EJB.ProduitBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
