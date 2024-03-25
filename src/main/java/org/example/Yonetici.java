package org.example;

import java.util.Scanner;

public class Yonetici extends Personel{

    private double bonus;

    public Yonetici(String isim, String soyisim, OdemeDetay odemeDetay,double bonus) {
        super(isim, soyisim, "Yonetici", odemeDetay);
        this.bonus = bonus;
    }

    @Override
    public void maasHesapla(Personel personel) {
        Scanner scanner = new Scanner(System.in);
        double saatlikUcret;

        do {
            System.out.print(personel.getIsim() + " " + personel.getSoyisim() + " yöneticisi için saatlik ücreti girin: ");
            saatlikUcret = scanner.nextDouble();

            if (saatlikUcret < 500) {
                System.out.println("\u001B[31m" + "Hata: " + personel.getIsim() + " " + personel.getSoyisim() + " için yöneticinin saatlik ücreti 500'den küçük olamaz." + "\u001B[0m");
            }
        } while (saatlikUcret < 500);

        System.out.print(personel.getIsim() + " " + personel.getSoyisim() + " yöneticisi için çalışma saatini girin: ");
        int calismaSaati = scanner.nextInt();

        try {
            double anaOdeme = saatlikUcret * calismaSaati;
            double toplamOdeme = anaOdeme + bonus;
            personel.getOdemeDetay().setAnaOdeme(anaOdeme);
            personel.getOdemeDetay().setToplamOdeme(toplamOdeme);
            personel.getOdemeDetay().setBonus(bonus);

            System.out.println(personel.getIsim() + " " + personel.getSoyisim() + " için maaş hesaplandı.");
            System.out.println("Ana ödeme: " + anaOdeme);
            System.out.println("Toplam ödeme: " + toplamOdeme);
            System.out.println("Bonus: " + bonus);

            if (calismaSaati < 150) {
                System.out.println("\u001B[31m Uyarı: Çalışma saati 150 saatten az. \u001B[0m");
            }
            personel.getOdemeDetay().setSaatlikUcret(saatlikUcret);
            personel.getOdemeDetay().setCalismaSaati(calismaSaati);
            personel.getOdemeDetay().setBonus(bonus);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
