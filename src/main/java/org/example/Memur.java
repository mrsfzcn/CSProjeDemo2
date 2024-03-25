package org.example;

import java.util.Scanner;

public class Memur extends Personel {
    private Derece derece;

    public Memur(String isim, String soyisim, OdemeDetay odemeDetay, Derece derece  ) {
        super(isim, soyisim, "Memur", odemeDetay);
        this.derece = derece;
    }

    @Override
    public void maasHesapla(Personel personel) {
        double saatlikUcret;
        int calismaSaati;
        Scanner scanner = new Scanner(System.in);
        System.out.print(isim + " " + soyisim +" memuru için saatlik ücreti girin: ");
        saatlikUcret = scanner.nextInt();
        System.out.print(isim + " " + soyisim + " memuru için çalışma saatini girin: ");
        calismaSaati = scanner.nextInt();
        double maas;

        if (calismaSaati <= 180) {
            maas = saatlikUcret * calismaSaati;
            personel.getOdemeDetay().setAnaOdeme(maas);
        } else {
            double ekMesaiUcreti = saatlikUcret * 1.5;
            double normalMaas = saatlikUcret * 180;
            double ekMesaiMaasi = ekMesaiUcreti * (calismaSaati - 180);
            maas = normalMaas + ekMesaiMaasi;
            personel.getOdemeDetay().setMesai(ekMesaiMaasi);
            personel.getOdemeDetay().setAnaOdeme(normalMaas);
        }
        personel.getOdemeDetay().setSaatlikUcret(saatlikUcret);
        personel.getOdemeDetay().setCalismaSaati(calismaSaati);
        personel.getOdemeDetay().setToplamOdeme(maas);
        System.out.println(isim + " Memurunun maaşı: " + maas);
    }
}
