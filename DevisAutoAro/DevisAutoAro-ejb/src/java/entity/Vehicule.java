/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author kiashi
 */
public class Vehicule {
    
    private AmCategorietarifaire categorieTarifaire;
    private Integer puissanceFiscale;
    private String sourceEnergie;
    private Double poidsVide;
    private Integer nbPlace;
    private Integer nbRoues;

    public Integer getNbRoues() {
        return nbRoues;
    }

    public void setNbRoues(Integer nbRoues) {
        this.nbRoues = nbRoues;
    }
    private boolean remorque;

    public AmCategorietarifaire getCategorieTarifaire() {
        return categorieTarifaire;
    }

    public void setCategorieTarifaire(AmCategorietarifaire categorieTarifaire) {
        this.categorieTarifaire = categorieTarifaire;
    }

    public Integer getPuissanceFiscale() {
        return puissanceFiscale;
    }

    public void setPuissanceFiscale(Integer puissanceFiscale) {
        this.puissanceFiscale = puissanceFiscale;
    }

    public String getSourceEnergie() {
        return sourceEnergie;
    }

    public void setSourceEnergie(String sourceEnergie) {
        this.sourceEnergie = sourceEnergie;
    }

    public Double getPoidsVide() {
        return poidsVide;
    }

    public void setPoidsVide(Double poidsVide) {
        this.poidsVide = poidsVide;
    }

    public Integer getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(Integer nbPlace) {
        this.nbPlace = nbPlace;
    }

    public boolean isRemorque() {
        return remorque;
    }

    public void setRemorque(boolean remorque) {
        this.remorque = remorque;
    }
    
}
