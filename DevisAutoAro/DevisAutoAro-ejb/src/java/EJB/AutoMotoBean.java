/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import util.ClientUtil;
import entity.AmGaranti;
import entity.AmGarantiVehicule;
import entity.AmVehicule;
import entity.Client;
import entity.Produit;
import entity.SaisieGaranti;
import entity.SouscriptionProduit;
import entity.Vehicule;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kiashi
 */
@Stateless
@LocalBean
public class AutoMotoBean {

    @EJB
    private DevisAutoBean devisAutoBean;

    
    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;

    public Integer getLastId() {
        Query query = em.createQuery("SELECT max(c.id) FROM SouscriptionProduit c");
        return (Integer) query.getSingleResult();
    }
    public SouscriptionProduit souscrireProduit(SouscriptionProduit souscriptionProduit) {
        souscriptionProduit.setId(getLastId() + 1);
        return (SouscriptionProduit) em.merge(souscriptionProduit);
    }
    
   public void souscrireAuto(Vehicule vehicule, Integer duree, List<SaisieGaranti> garanti) {
        SouscriptionProduit souscriptionProduit = new SouscriptionProduit();
        FacesContext context = FacesContext.getCurrentInstance();
        Client c = (Client) context.getExternalContext().getSessionMap().get("clientSession");
        
        
        Produit produit = new Produit();
        produit.setId(1);
        souscriptionProduit.setClient(c);
        souscriptionProduit.setClientSouscripteur(c);
        souscriptionProduit.setDaty(new Date());
        souscriptionProduit.setDuree(duree);
        souscriptionProduit.setValide(0);
        souscriptionProduit.setNopolice(ClientUtil.buildNoProcedure());
        souscriptionProduit.setPrimenet(devisAutoBean.calculDevis(vehicule,garanti, duree));
        souscriptionProduit.setPrimetotal(devisAutoBean.calculDevis(vehicule,garanti, duree));
//        souscriptionProduit.setReduction(Double.MIN_VALUE);
        souscriptionProduit.setProduit(produit);

//        insert souscription_produit
        souscriptionProduit = souscrireProduit(souscriptionProduit);

        AmVehicule newVehicule = new AmVehicule();
        newVehicule.setDateMiseEnCirc(vehicule.getDateCirculation());
        newVehicule.setMarque(vehicule.getMarque());
        newVehicule.setNbPlace(vehicule.getNbPlace());
        newVehicule.setNoimm(vehicule.getNoImm());
        newVehicule.setNbroues(vehicule.getNbRoues());
        newVehicule.setNoserie(vehicule.getNoSerie());
        newVehicule.setPuissanceFisc(vehicule.getPuissanceFiscale());
        newVehicule.setSourceEnergie(vehicule.getSourceEnergie());
        newVehicule.setType(vehicule.getType());
        newVehicule.setPoidsVide(vehicule.getPoidsVide());
        newVehicule.setSouscriptionProduit(souscriptionProduit);
        newVehicule.setCarrosserie(vehicule.getCarrosserie());

        newVehicule = em.merge(newVehicule);

        for (SaisieGaranti saisigaranti : garanti) {
            AmGarantiVehicule amGarantiVehicule = new AmGarantiVehicule();
            amGarantiVehicule.setSouscriptionProduitId(souscriptionProduit);
            AmGaranti amgaranti = new AmGaranti();
            amgaranti.setId(saisigaranti.getA().getId());
            amGarantiVehicule.setAmGarantiId(amgaranti);
            amGarantiVehicule.setMtlimite(saisigaranti.getLimite());
            em.persist(amGarantiVehicule);
        }

    }

    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
