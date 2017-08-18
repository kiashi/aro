/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.AmDommage;
import entity.AmSinistre;
import entity.AmVehicule;
import entity.DommagesSinistre;
import entity.PhotoSinistre;
import entity.SinCategorie;
import entity.SinRapport;
import entity.SinistresView;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author misa
 */
@Stateless
@LocalBean
public class SinistreBean {

    @PersistenceContext(unitName = "DevisAutoAro-ejbPU")
    private EntityManager em;
    
    
    public void ajouterRapport(SinRapport r){
        em.persist(r);
                
    }
    public void updateSinistre(AmSinistre sinistre){
        em.merge(sinistre);
    }
    
    public List<SinistresView> getAllView(){
        Query q = em.createQuery("select s from SinistresView s where s.demande=1 order by s.dateSinistre");
        return q.getResultList();
    }

    public void saveDommageSinistre(Integer idSinistre, Integer idDommage){
        AmSinistre sinistre = new AmSinistre();
        sinistre.setId(idSinistre);
        AmDommage dommage = new AmDommage();
        dommage.setId(idDommage);
        DommagesSinistre d = new DommagesSinistre();
        d.setAmDommageId(dommage);
        d.setAmSinistreId(sinistre);
        em.persist(d);
    }
    
    public AmSinistre saveSinistre(AmSinistre sinistre) {
        em.persist(sinistre);
        em.flush();
        return sinistre;
    }
    
    public void savePhotoSinistre(Integer idsinistre, String fileName){
        AmSinistre sin = new AmSinistre();
        sin.setId(idsinistre);
        PhotoSinistre photoSinistre = new PhotoSinistre();
        photoSinistre.setAmSinistre(sin);
        photoSinistre.setPhoto(fileName);
        em.persist(photoSinistre);       
                
    }
    
    public AmDommage getDommagesById(Integer id){
        return (AmDommage)em.find(AmDommage.class, id);
    }
    
    public List<AmDommage> getDommages() {
        Query q = em.createQuery("select d from AmDommage d ");
        return q.getResultList();
    }
    
    public SinCategorie getCategorieById(Integer id){
        return (SinCategorie)em.find(SinCategorie.class, id);
    }

    public List<SinCategorie> getCategories() {
        Query q = em.createQuery("select d from SinCategorie d ");
        return q.getResultList();
    }

    public AmVehicule getVehiculeByIdSouscription(Integer idsouscription) {
        Query q = em.createQuery("select d from AmVehicule d where d.souscriptionProduit.id = :idsouscription");
        q.setParameter("idsouscription", idsouscription);
        return (AmVehicule) q.getSingleResult();
    }

    public List<SinRapport> getRapportBySinistre(Integer idsinistre) {
        Query q = em.createQuery("select d from SinRapport d where d.amSinistreId.id = :idsinistre");
        q.setParameter("idsinistre", idsinistre);
        return q.getResultList();
    }

    public List<PhotoSinistre> getPhotosBySinistre(Integer idsinistre) {
        Query q = em.createQuery("select d from PhotoSinistre d where d.amSinistre.id = :idsinistre");
        q.setParameter("idsinistre", idsinistre);
        return q.getResultList();
    }

    public List<DommagesSinistre> getDommagesBySinistre(Integer idsinistre) {
        Query q = em.createQuery("select d from DommagesSinistre d where d.amSinistreId.id = :idsinistre");
        q.setParameter("idsinistre", idsinistre);
        return q.getResultList();
    }

    public AmSinistre getSinistreById(Integer idsinistre) {
        AmSinistre q = em.find(AmSinistre.class, idsinistre);
        return q;
    }

    public List<AmSinistre> getSinistresBySouscription(Integer idsouscription) {
        Query query = em.createQuery("SELECT s FROM AmSinistre s WHERE s.souscriptionProduitId.id = :idsouscription");
        query.setParameter("idsouscription", idsouscription);
        return query.getResultList();
    }

}
