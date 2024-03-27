package org.example.bordro.model;

public abstract class Personel {

    public String isim;
    public String soyisim;
    public String rol;
    private OdemeDetay odemeDetay;
    private CalismaDetay calismaDetay;


    public Personel(String isim, String soyisim, String rol, OdemeDetay odemeDetay) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.rol = rol;
        this.odemeDetay = odemeDetay;
    }
    public CalismaDetay getCalismaDetay() {
        return calismaDetay;
    }

    public void setCalismaDetay(CalismaDetay calismaDetay) {
        this.calismaDetay = calismaDetay;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public String getRol() {
        return rol;
    }

    public OdemeDetay getOdemeDetay() {
        return odemeDetay;
    }

    public abstract void maasHesapla(Personel personel);
}
