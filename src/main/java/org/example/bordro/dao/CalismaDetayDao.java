package org.example.bordro.dao;

import org.example.bordro.model.CalismaDetay;
import org.example.bordro.model.Personel;

import java.util.Scanner;

public class CalismaDetayDao {
        public static Scanner scanner = new Scanner(System.in);
    public static CalismaDetay calismaBilgileriniAl(Personel p, boolean tekrarGirisMi) {

        if(tekrarGirisMi){
            System.out.println("Yanlış giriş yaptınız.");
        }
        double saatlikUcret;
        int calismaSaati;

        String personelTip;
        if (p.getRol().equals("Memur")){
            personelTip = "memuru";
        } else {
            personelTip = "yoneticisi";
        }
        System.out.print(p.getIsim() + " " + p.getSoyisim() + personelTip + " için saatlik ücreti girin: ");
        saatlikUcret = scanner.nextDouble();
        System.out.print(p.getIsim() + " " + p.getSoyisim() + personelTip + " için çalışma saatini girin: ");
        calismaSaati = scanner.nextInt();

        return new CalismaDetay(saatlikUcret, calismaSaati);
    }
}
