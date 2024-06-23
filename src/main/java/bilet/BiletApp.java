package bilet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BiletApp {

       /*
project: Bilet Rezervasyon ve Bilet Fiyatı Hesaplama Uygulaması

       1-Uygulama mesafe ve kurallara göre otobüs bileti fiyatı hesaplar sonuç olarak bilet bilgisini verir
       2- Kullanıcıdan     mesafe (KM),
       yolcu yaşı ,
       yolculuk tipi (Tek Yön, Gidiş-Dönüş)
       ve koltuk no bilgilerini alınır.
       NOT: Koltuk numaraları 1-32 aralığında olmalıdır.)
       Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
       Aksi halde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

       3-Fiyat hesaplama kuralları:
       -Mesafe başına ücret:
       Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
       -Tekli Koltuk ücreti:
       Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).  -- -
       -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
       sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
       i)w
       Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
       Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

       */

    public static void main(String[] args) {

        Otobus otobus = new Otobus("27 ASD 123");

        Bilet bilet = new Bilet();

        start(otobus,bilet);

    }

    public static void start(Otobus otobus,Bilet bilet) {

        Scanner input = new Scanner(System.in);
        int secim = -1;// Hata durumunda döngüyü tekrarlamak için secim'i -1'e ayarladik
        do {
            try{
                System.out.println("Bilet Rezervasyon Uygulamasina Hosgeldiniz");
                System.out.println("Lutfen yasinizi giriniz:");
                int yas = input.nextInt();

                System.out.println("Lutfen yolculuk tipini seciniz:");
                System.out.println("1. Tek Yon");
                System.out.println("2. Gıdıs-Donus");
                int yolculukTip = input.nextInt();

                System.out.println("Lutfen gidilecek mesafe bilgisini KM olarak giriniz: ");
                double mesafe = input.nextDouble();

                System.out.println("Lutfen koltuk numarasi seciniz: ");
                System.out.println("Tekli koltuk ucreti %20 daha fazladir.");
                System.out.println(otobus.koltuklar);// Mevcut koltuk numaralarını yazdırır
                String koltuk = input.next();

                boolean rezerve = !otobus.koltuklar.contains(koltuk);

                if (rezerve){
                    System.out.println("Sectiginiz koltuk rezerve edilmistir.");
                }
                //Girilen veriler kontrol edilir
                if (yas > 0 && mesafe > 0 && (yolculukTip == 1 || yolculukTip == 2) && !rezerve){

                    // Otobüs koltuk listesinden seçilen koltuk çıkarılır
                    otobus.koltuklar.remove(koltuk);

                    // Bilet bilgileri atanır
                    bilet.mesafe = mesafe;
                    bilet.koltukNo = koltuk;
                    bilet.yolculukTip = yolculukTip;

                    //Bilet fiyatini hesaplayip yazdiralim
                    bilet.biletFiyatiHesapla(yas);
                    bilet.biletiYazdir(otobus);

                } else {
                    System.out.printf("Hatali veri girdiniz. Lutfen tekrar deneyiniz");
                }
                //Yeni bir islem yapilip yapilmayacagi kullaniciya sorulur
                System.out.println("Yeni bir islem icin bir sayi giriniz. Cikis icin 0'i basiniz.");
                secim = input.nextInt();

            }catch(InputMismatchException e){
                System.out.println("Hatali veri giridiniz. Lutfen tekrar DENEYINIZ-1");
                input.next();//Hatanin tekrarlanmasini onlemek icin temizleme islemi yaptik.
            }catch (Exception e){
                System.out.println("Hatali veri giridiniz. Lutfen tekrar DENEYINIZ-2");
                input.next();//Hatanin tekrarlanmasini onlemek icin temizleme islemi yaptik.
            }


        }while(secim != 0);

    }
}