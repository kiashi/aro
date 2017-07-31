/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author kiashi
 */
public class Vehicule {
    
    private AmCategorietarifaire categorieTarifaire;
    private Integer puissanceFiscale;
    private String sourceEnergie;
    private Double poidsVide;
    private String carrosserie;

    public String getCarrosserie() {
        return carrosserie;
    }

    public void setCarrosserie(String carrosserie) {
        this.carrosserie = carrosserie;
    }

    public String getNoImm() {
        return noImm;
    }

    public void setNoImm(String noImm) {
        this.noImm = noImm;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public Date getDateCirculation() {
        return dateCirculation;
    }

    public void setDateCirculation(Date dateCirculation) {
        this.dateCirculation = dateCirculation;
    }
    private Integer nbPlace;
    private Integer nbRoues;
    private String noImm;
    private String marque;
    private String type;
    private String noSerie;
    private Date dateCirculation;
   

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
