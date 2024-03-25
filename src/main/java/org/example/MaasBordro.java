package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MaasBordro {
    public void maaslariHesapla(List<Personel> personeller) {
        for (Personel personel : personeller) {
            personel.maasHesapla(personel);
        }
    }

    public void ayrintiliRapor(List<Personel> personeller) {
        try {
            FileWriter writer = new FileWriter("maas_bordrosu.json");

            LocalDateTime simdikiZaman = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            String zamanDamgasi = simdikiZaman.format(formatter);

            JSONObject bordroJSON = new JSONObject();
            bordroJSON.put("bordro", zamanDamgasi);

            JSONArray personelArray = new JSONArray();
            for (Personel personel : personeller) {
                JSONObject personelJSON = new JSONObject();
                personelJSON.put("AD", personel.isim);
                personelJSON.put("SOYAD", personel.soyisim);
                personelJSON.put("Maas", personel.getOdemeDetay().getToplamOdeme());
                personelJSON.put("CalismaSaati", personel.getOdemeDetay().getCalismaSaati());
                personelJSON.put("SaatlikUcret", personel.getOdemeDetay().getSaatlikUcret());
                personelArray.add(personelJSON);
            }

            bordroJSON.put("personel", personelArray);

            writer.write(bordroJSON.toJSONString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void maasBilgileriniKaydet(List<Personel> personelListesi) {
        LocalDateTime simdikiZaman = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        String zamanDamgasi = simdikiZaman.format(formatter);

        for (Personel personel : personelListesi) {
            JSONObject bordroJSON = new JSONObject();
            bordroJSON.put("bordro", zamanDamgasi);

            JSONObject personelJSON = new JSONObject();
            personelJSON.put("AD", personel.getIsim());
            personelJSON.put("SOYAD", personel.getIsim());

            JSONObject odemeDetaylari = new JSONObject();
            odemeDetaylari.put("anaOdeme", personel.getOdemeDetay().getAnaOdeme() + "TL");
            odemeDetaylari.put("toplamOdeme", + personel.getOdemeDetay().getToplamOdeme() + "TL");
            if (personel instanceof Memur) {
                odemeDetaylari.put("mesai", personel.getOdemeDetay().getMesai() + "TL");
            } else if (personel instanceof Yonetici) {
                odemeDetaylari.put("bonus", personel.getOdemeDetay().getBonus() + "TL");
            }

            personelJSON.put("odemeDetaylari", odemeDetaylari);

            bordroJSON.put("personel", personelJSON);

            String dosyaAdi = personel.getIsim() + "_" + personel.getSoyisim() + "_maas.json";

            try (FileWriter file = new FileWriter(dosyaAdi)) {
                file.write(bordroJSON.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void raporGoruntule(List<Personel> personeller) {
        System.out.println("****************************************************");
        System.out.println("Personel Maaş Raporu");
        System.out.println("****************************************************");
        System.out.printf("%-20s%-20s%-15s%-15s%-15s%n", "İsim", "Soyisim", " Çalışma Saati", " Saatlik Ücret", " Toplam Maaş");
        System.out.println("----------------------------------------------------");
        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RED = "\u001B[31m";
        for (Personel personel : personeller) {
            double calismaSaati = personel.getOdemeDetay().getCalismaSaati();
            if (calismaSaati < 150) {
                System.out.print(ANSI_YELLOW);
            }
            if (calismaSaati < 10) {
                System.out.print(ANSI_RED);
            }
            double toplamMaas = personel.getOdemeDetay().getToplamOdeme();
            double saatlikUcret = personel.getOdemeDetay().getSaatlikUcret();
            System.out.printf("%-20s%-20s%-15.2f%-15.2f%-15.2f%n",
                    personel.getIsim(), personel.getSoyisim(), calismaSaati, saatlikUcret, toplamMaas);
            System.out.print(ANSI_RESET);
        }
        System.out.println("****************************************************");
        System.out.println(ANSI_GREEN);
        System.out.println( "Not: 10 saatten az çalışanlar kırmızı ile, 150 saatten az çalışanlar sarı ile işaretlenmiştir!");
        System.out.print(ANSI_RESET);
    }
}

