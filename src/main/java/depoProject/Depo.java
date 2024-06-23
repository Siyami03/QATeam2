package depoProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Depo {

    public static Map<Integer, Urun> urunler = new HashMap<>(); //Urunleri saklamak icin bir Map kullandik
    public static Scanner input = new Scanner(System.in);


    public  void menuyuGoster() {
        System.out.println("<--- DEPO UYUGULAMSINA HOSGELDINIZ --->");
        System.out.println("1- Urunleri Listele");
        System.out.println("2- Urun Tanımlama");
        System.out.println("3- Urun Girisi Yap");
        System.out.println("4- Urunu Rafa Koy");
        System.out.println("5- Urun Cikisi Yap");
        System.out.println("0- Cikis");
        System.out.println("Lutfen yapmak istediginiz isleme gore bir secim yapiniz");
    }

    public void urunListele() {
        Map<Integer, Urun> siraliUrunler = new TreeMap<>(urunler);

        System.out.println("--------------------------------------------------------------");
        System.out.printf("| %-5s | %-15s | %-15s | %-7s | %-10s | %-5s |\n", "ID", "Urun Adi", "Uretici", "Miktar", "Birim", "Raf");
        System.out.println("--------------------------------------------------------------");
        for (Urun urun : siraliUrunler.values()) {
            System.out.printf("| %-5d | %-15s | %-15s | %-7d | %-10s | %-5s |\n", urun.id, urun.ad, urun.uretici,
                    urun.miktar, urun.birim, (urun.raf == null ? "null" : urun.raf));
        }
        System.out.println("--------------------------------------------------------------");
    }

    public void urunTanimlama() {
        boolean gecerli = false;
        do {
            try {
                System.out.println("Urun adini giriniz:");
                String ad = input.next();
                System.out.println("Uretici bilgisini giriniz:");
                String uretici = input.next();
                System.out.println("Birim giriniz");
                String birim = input.next();
                int id = urunler.size() + 1000; // Geçici bir ID atama
                Urun urun = new Urun(id, ad, uretici, 0, birim, null);
                urunler.put(id, urun);
                System.out.println("Urun basariyla tanimlandi");
                gecerli = true;
            } catch (Exception e) {
                System.out.println("Lutfen bilgileri dogru sekilde giriniz. "+ e.getMessage());

            }
        } while (!gecerli);

    }

    public void urunGirisi() {
        boolean gecerli = false;
        do {
            try {
                System.out.println("Lutfen ID giriniz: ");
                int id = input.nextInt();
                if (urunler.containsKey(id)) {
                    System.out.println("Giris miktarini giriniz:");
                    int miktar = input.nextInt();
                    urunler.get(id).miktar += miktar;
                    System.out.println("Giris basariyla yapildi. Yeni miktar: " + urunler.get(id).miktar);
                    gecerli = true;
                } else {
                    System.out.println("Gecersiz ID!. Lutfen tekrar giriniz.");
                }
            } catch (Exception e) {
                System.out.println("Lutfen bilgileri dogru sekilde giriniz. " + e.getMessage());
                input.nextLine();
            }
        } while (!gecerli);
    }

    public void urunuRafaKoy() {
        boolean gecerli = false;
        do {
            try {
                System.out.println("Lutfen ID giriniz: ");
                int id = input.nextInt();
                if (urunler.containsKey(id)) {
                    System.out.println("Lutfen raf bilgisi giriniz:");
                    String raf = input.next();
                    urunler.get(id).raf = raf;
                    System.out.println("Urun rafa basariyla yerlestirildi. Raf: " + urunler.get(id).raf);
                    gecerli = true;
                } else {
                    System.out.println("Gecersiz ID!. Lutfen tekrar giriniz.");
                }
            } catch (Exception e) {
                System.out.println("Lutfen bilgileri dogru sekilde giriniz. " + e.getMessage());
            }
        } while (!gecerli);
    }

    public void urunCikisi() {
        boolean gecerli = false;
        do {
            try {
                System.out.println("Lutfen ID giriniz: ");
                int id = input.nextInt();
                if (urunler.containsKey(id)) {
                    System.out.println("Cikis miktarini giriniz:");
                    int miktar = input.nextInt();
                    if (miktar <= urunler.get(id).miktar) {
                        urunler.get(id).miktar -= miktar;
                        System.out.println("Cikis basariyla yapildi. Yeni miktar: " + urunler.get(id).miktar);
                        gecerli = true;
                    } else {
                        System.out.println("Stokta belirttiginiz urunden yeterli miktarda yok");
                    }
                } else {
                    System.out.println("Gecersiz ID!. Lutfen tekrar giriniz.");
                }
            } catch (Exception e) {
                System.out.println("Lutfen bilgileri dogru sekilde giriniz. " + e.getMessage());
            }
        } while (!gecerli);
    }

}