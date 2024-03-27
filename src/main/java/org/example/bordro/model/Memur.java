package org.example.bordro.model;

public class Memur extends Personel {
    private Derece derece;

    public Memur(String isim, String soyisim, OdemeDetay odemeDetay, Derece derece  ) {
        super(isim, soyisim, "Memur", odemeDetay);
        this.derece = derece;
    }

    @Override
    public void maasHesapla(Personel personel) {
        CalismaDetay calismaDetay = personel.getCalismaDetay();
        double maas;

        if (calismaDetay.getCalismaSaati() <= 180) {
            maas = calismaDetay.getSaatlikUcret() * calismaDetay.getCalismaSaati();
            personel.getOdemeDetay().setAnaOdeme(maas);
        } else {
            double ekMesaiUcreti = calismaDetay.getSaatlikUcret() * 1.5;
            double normalMaas = calismaDetay.getCalismaSaati() * 180;
            double ekMesaiMaasi = ekMesaiUcreti * (calismaDetay.getCalismaSaati() - 180);
            maas = normalMaas + ekMesaiMaasi;
            personel.getOdemeDetay().setMesai(ekMesaiMaasi);
            personel.getOdemeDetay().setAnaOdeme(normalMaas);
        }
        personel.getOdemeDetay().setToplamOdeme(maas);
        System.out.println(isim + " Memurunun maaşı: " + maas);
    }
}
