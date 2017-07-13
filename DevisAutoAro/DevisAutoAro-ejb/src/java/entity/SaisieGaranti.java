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
public class SaisieGaranti {
    
    private AmGaranti a;
    Boolean actif;

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }
    Double limite;
    Double primeNette;

    public AmGaranti getA() {
        return a;
    }

    public void setA(AmGaranti a) {
        this.a = a;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getPrimeNette() {
        return primeNette;
    }

    public void setPrimeNette(Double primeNette) {
        this.primeNette = primeNette;
    }
    
}
