package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        String dosyaYolu = "personel.json";
        List<Personel> personelListesi = DosyaOku.jsonDosyasindanOku("C:/IntelliJ/CSProjeDemo2/src/main/resources/personel.json");

        System.out.println("********************************");
        System.out.println("Dosyadan okunan personel sayısı: " + personelListesi.size());
        System.out.println("********************************");

        MaasBordro maasBordro = new MaasBordro();
        maasBordro.maaslariHesapla(personelListesi);
        maasBordro.ayrintiliRapor(personelListesi);
        maasBordro.maasBilgileriniKaydet(personelListesi);

        maasBordro.raporGoruntule(personelListesi);

    }
}