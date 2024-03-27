package org.example.bordro.validator;

import org.example.bordro.model.CalismaDetay;
import org.example.bordro.model.Memur;
import org.example.bordro.model.Personel;
import org.example.bordro.model.Yonetici;

public class CalismaBilgiValidator {

    public static boolean validateCalismaDetay(CalismaDetay calismaDetay, Personel p) {

        if (p instanceof Memur) {
            return true;
        } else if (p instanceof Yonetici) {
            if (calismaDetay.getSaatlikUcret() < 500) {
                System.out.println("\u001B[31m" + "Hata: " + p.getIsim() + " " + p.getSoyisim() + " için yöneticinin saatlik ücreti 500'den küçük olamaz." + "\u001B[0m");
                return false;
            }
        }
        return true;
    }
}
