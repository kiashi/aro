/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.AmCategorietarifaire;
import entity.AmCategorietarifaire_;
import entity.AmPrime;
import entity.AmTauxgaranti;
import entity.Vehicule;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    public Double primeNettes(Integer idCategorieTar, Integer idGaranti, Double limite){
        //List<AmPrime> list = amPrimeBean.findByVehicule(a);
        //List<AmCategorietarifaire> listCat = amCategorietarifaireBean.findByRoues(a.getNbRoues());
        List<AmTauxgaranti> listTaux = amTauxGarantiBean.findByTaux(idCategorieTar, idGaranti);
        Double res= limite*listTaux.get(0).getTaux();
        return new Double(0);
    }
    
    public Double calculDevis(Vehicule a, Integer[] listGaranti, Double[] listLimite){
        List<AmPrime> list = amPrimeBean.findByVehicule(a);
        Double primeNet = new Double(0);
        for(int i=0;i<listGaranti.length;i++){
            primeNet+=primeNettes(a.getCategorieTarifaire().getIdcodetarifaire(), listGaranti[i], listLimite[i]);
        }
        return primeNet + list.get(0).getPrimepayant();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

