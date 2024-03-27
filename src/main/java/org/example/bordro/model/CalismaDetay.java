package org.example.bordro.model;

public class CalismaDetay {
    private double saatlikUcret;
    private double calismaSaati;

    public CalismaDetay(double saatlikUcret, double calismaSaati) {
        this.saatlikUcret = saatlikUcret;
        this.calismaSaati = calismaSaati;
    }

    public double getSaatlikUcret() {
        return saatlikUcret;
    }

    public void setSaatlikUcret(double saatlikUcret) {
        this.saatlikUcret = saatlikUcret;
    }

    public double getCalismaSaati() {
        return calismaSaati;
    }

    public void setCalismaSaati(double calismaSaati) {
        this.calismaSaati = calismaSaati;
    }
}
