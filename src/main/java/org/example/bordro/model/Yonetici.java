package org.example.bordro.model;

import java.util.Scanner;

public class Yonetici extends Personel{

    private double bonus;

    public Yonetici(String isim, String soyisim, OdemeDetay odemeDetay,double bonus) {
        super(isim, soyisim, "Yonetici", odemeDetay);
        this.bonus = bonus;
    }

    @Override
    public void maasHesapla(Personel personel) {

            double anaOdeme = personel.getCalismaDetay().getSaatlikUcret() * personel.getCalismaDetay().getCalismaSaati();
            double toplamOdeme = anaOdeme + bonus;
            personel.getOdemeDetay().setAnaOdeme(anaOdeme);
            personel.getOdemeDetay().setToplamOdeme(toplamOdeme);
            personel.getOdemeDetay().setBonus(bonus);

            System.out.println(personel.getIsim() + " " + personel.getSoyisim() + " için maaş hesaplandı.");
            System.out.println("Ana ödeme: " + anaOdeme);
            System.out.println("Toplam ödeme: " + toplamOdeme);
            System.out.println("Bonus: " + bonus);

            if (personel.getCalismaDetay().getCalismaSaati() < 150) {
                System.out.println("\u001B[31m Uyarı: Çalışma saati 150 saatten az. \u001B[0m");
            }
            personel.getOdemeDetay().setBonus(bonus);
    }
}
