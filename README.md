# Maaş Bordrosu Uygulaması

Bu Java uygulaması, bir şirketteki personelin maaş bilgilerini hesaplamak ve raporlamak için kullanılır. Uygulama, JSON dosyasından personel bilgilerini okur, her personel için maaş hesaplar, ayrıntılı bir maaş raporu oluşturur ve bu bilgileri bir JSON dosyasına kaydeder.

## Kullanım

1. Öncelikle `personel.json` adında bir JSON dosyası oluşturun ve her personelin bilgilerini içeren bu dosyayı doldurun. Personel bilgileri JSON formatında şu özellikleri içermelidir:
   - İsim
   - Soyisim
   - Rol (Yönetici veya Memur)
   - Çalışma Saati 
   - Saatlik Ücret (Yönetici için)
   - Derece (Memur için)
   - Saatlik Ücret (Memur için)

   Örnek bir JSON dosyası:

   ```json
   {
     "personeller": [
       {
         "isim": "Ali",
         "soyisim": "Veli",
         "rol": "Yonetici",
         "calismaSaati": 160,
         "saatlikUcret": 50
       },
       {
         "isim": "Ayse",
         "soyisim": "Fatma",
         "rol": "Memur",
         "derece": "Lisans",
         "saatlikUcret": 30
       }
     ]
   }
   
2. Uygulamayı çalıştırın. Uygulama çalıştırıldığında, personel bilgilerini okuyacak ve her personelin maaşını hesaplayacak ve raporlayacaktır.
## Notlar
Maaş hesaplaması yapılırken, yöneticiler için bonus dikkate alınır, memurlar için ise mesai ücreti dikkate alınır.
Maaş raporu ayrıntılı olarak konsola yazdırılır ve aynı zamanda maas_bordrosu.json adında bir JSON dosyasına kaydedilir.
Personel bilgilerini JSON dosyasından okumak için JSON Simple kütüphanesi kullanılmıştır.


Bu README dosyası, proje hakkında temel bilgileri ve kullanım talimatlarını içerir. Gerçek projenize göre özelleştirebilirsiniz. 
