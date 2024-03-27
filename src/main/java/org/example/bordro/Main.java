package org.example.bordro;

import org.example.bordro.dao.DosyaOku;
import org.example.bordro.model.Personel;
import org.example.bordro.service.CalismaDetayServis;
import org.example.bordro.service.MaasBordroServis;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Personel> personelListesi = DosyaOku.jsonDosyasindanOku("C:/IntelliJ/CSProjeDemo2/src/main/resources/personel.json");

        System.out.println("********************************");
        System.out.println("Dosyadan okunan personel sayısı: " + personelListesi.size());
        System.out.println("********************************");

        CalismaDetayServis.calismaBilgileriniAl(personelListesi);

        MaasBordroServis.maaslariHesapla(personelListesi);
        MaasBordroServis.tumPersonelBordroRaporuOlustur(personelListesi);
        MaasBordroServis.bordroRaporuOlustur(personelListesi);
        MaasBordroServis.raporGoruntule(personelListesi);

    }
}