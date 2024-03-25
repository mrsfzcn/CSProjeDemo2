package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DosyaOku {

    public static List<Personel> jsonDosyasindanOku(String dosyaYolu) {
        List<Personel> personelListesi = new ArrayList<>();

        try {
            FileReader reader = new FileReader(dosyaYolu);
            JSONParser jsonParser = new JSONParser();
            JSONArray personelJsonArray = (JSONArray) jsonParser.parse(reader);

            for (Object obj : personelJsonArray) {
                JSONObject personelJson = (JSONObject) obj;
                String isim = (String) personelJson.get("name");
                String soyisim = (String) personelJson.get("surname");
                String rol = (String) personelJson.get("role");

                OdemeDetay odemeDetay = new OdemeDetay();

                if (rol.equals("Yonetici")) {
                    double bonus = (Long) personelJson.get("bonus");
                    personelListesi.add(new Yonetici(isim, soyisim, odemeDetay, bonus));
                } else if (rol.equals("Memur")) {
                    Derece derece = Derece.valueOf((String) personelJson.get("derece"));
                    personelListesi.add(new Memur(isim, soyisim, odemeDetay, derece));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personelListesi;
    }
}

