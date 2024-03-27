package org.example.bordro.service;

import org.example.bordro.dao.CalismaDetayDao;
import org.example.bordro.model.CalismaDetay;
import org.example.bordro.model.Personel;
import org.example.bordro.validator.CalismaBilgiValidator;

import java.util.List;

public class CalismaDetayServis {
    public static void calismaBilgileriniAl(List<Personel> personelListesi) {

        for (Personel p : personelListesi){
            CalismaDetay calismaDetay ;
            boolean tekrarGirisMi = false;
            do{
                calismaDetay = CalismaDetayDao.calismaBilgileriniAl(p, tekrarGirisMi);
                tekrarGirisMi = true;
            } while (!CalismaBilgiValidator.validateCalismaDetay(calismaDetay, p));

            p.setCalismaDetay(calismaDetay);
        }
    }
}
