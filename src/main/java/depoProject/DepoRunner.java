package depoProject;

import java.util.Scanner;

public class DepoRunner {
    public static void main(String[] args) {


        start();


    }
    public static void start() {
        Depo depo = new Depo();
        Scanner input = new Scanner(System.in);

        int secim;
        do {
            depo.menuyuGoster();
            String giris = input.nextLine().trim(); // Girişi alırken baştaki ve sondaki boşlukları temizle

            if (!giris.isEmpty()) {
                try {
                    secim = Integer.parseInt(giris);
                    switch (secim) {
                        case 1:
                            depo.urunListele();
                            break;
                        case 2:
                            depo.urunTanimlama();
                            break;
                        case 3:
                            depo.urunGirisi();
                            break;
                        case 4:
                            depo.urunuRafaKoy();
                            break;
                        case 5:
                            depo.urunCikisi();
                            break;
                        case 0:
                            System.out.println("Cikis yapiliyor. Bizi tercih ettiginiz icn tesekkur ederiz...");
                            break;
                        default:
                            System.out.println("Gecersiz secim yaptiniz. Lutfen sadece menudeki rakamlari giriniz.");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Hatali giris yaptiniz. Lutfen sadece menudeki rakamlari giriniz.");
                    secim = -1;
                }
            }else {
                System.out.println("Hatali giris yaptiniz. Lutfen sadece menudeki rakamlari giriniz.-2");
                secim = -1;
            }

        } while (secim != 0);

    }



}