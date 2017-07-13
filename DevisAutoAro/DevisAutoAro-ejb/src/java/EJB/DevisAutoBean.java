/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.AmCategorietarifaire;

import entity.AmPrime;
import entity.AmTauxgaranti;
import entity.SaisieGaranti;
import entity.Vehicule;
import java.util.List;
import javax.ejb.EJB;
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
public class DevisAutoBean {

    @EJB
    private AmTauxGarantiBean amTauxGarantiBean;

    @EJB
    private AmCategorietarifaireBean amCategorietarifaireBean;

    @EJB
    private AmPrimeBean amPrimeBean;

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public Double primeNettes(Integer idCategorieTar, Integer idGaranti, Double limite) {
        //List<AmPrime> list = amPrimeBean.findByVehicule(a);
        //List<AmCategorietarifaire> listCat = amCategorietarifaireBean.findByRoues(a.getNbRoues());
        List<AmTauxgaranti> listTaux = amTauxGarantiBean.findByTaux(idCategorieTar, idGaranti);
        Double res = limite * listTaux.get(0).getTaux();
        System.out.println("calcul : limite " + limite + " taux : " + listTaux.get(0).getTaux());
        return res;
    }

    public Double calculDevis(Vehicule a, List<SaisieGaranti> listeGaranti, Integer nbMois) {
        List<AmPrime> list = amPrimeBean.findByVehicule(a);
        Double primeNet = new Double(0);
        for (SaisieGaranti saisi : listeGaranti) {
            
            primeNet += primeNettes(a.getCategorieTarifaire().getIdcodetarifaire(), saisi.getA().getIdamgaranti(), saisi.getLimite());
            saisi.setPrimeNette(primeNettes(a.getCategorieTarifaire().getIdcodetarifaire(), saisi.getA().getIdamgaranti(), saisi.getLimite()));
            System.out.println("idcategorie : "+a.getCategorieTarifaire().getIdcodetarifaire()+" - idgaranti "+saisi.getA().getIdamgaranti());
        }
        System.out.println("prime net : " + primeNet);
        return (primeNet + list.get(0).getPrimepayant())*nbMois/12;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    /*public Vehicule getInformationVehicule() {
        try {

            Query cl = em.createQuery("SELECT c FROM Magasin c");
            return (Vehicule) cl.getSingleResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
