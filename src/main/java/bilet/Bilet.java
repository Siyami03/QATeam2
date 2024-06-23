package bilet;

public class Bilet {

    public double mesafe;
    public int yolculukTip;
    public double fiyat;
    public String koltukNo;

    public void  biletFiyatiHesapla(int yas){

        int koltuk = Integer.parseInt(koltukNo);

        double toplam = 0;

        if(this.yolculukTip == 1){
            if (koltuk % 3 == 0){
                toplam = this.mesafe * 1.2;
            }else {
                toplam = this.mesafe * 1;
            }
            System.out.println("Toplam tutar: " + toplam);

        } else if (this.yolculukTip == 2) {
            if (koltuk % 3 == 0){
                toplam = this.mesafe * 2.4;
            }else {
                toplam = this.mesafe * 2;
            }
            System.out.println("Toplam tutar: " + toplam);

        } else {
            System.out.println("Yolculuk tipi olarak 1 ya da 2 seciniz");
        }
        //Son tutardan yas indirimi
        if (yas < 12){
            toplam = toplam * 0.5;
            System.out.println("12 yas alti indirimli tutar: " + toplam);
        } else if (yas > 65) {
            toplam = toplam * 0.7;
            System.out.println("65 yas ustu indirimli tutar: " + toplam);
        }


        this.fiyat = toplam;
    }

    public void biletiYazdir(Otobus otobus){

        System.out.println("<--- Bilet Bilgileri --->");
        System.out.println("Otobous Plaka     : " + otobus.plaka);
        System.out.println("Koltuk NO         : " + this.koltukNo);
        System.out.println("Yolculuk Tipi     : " + this.yolculukTip);
        System.out.println("Mesafe            : " + this.mesafe);
        System.out.println("Toplam Tutar      : " + this.fiyat );
        System.out.println("Keyifli yolculuklar dileriz...");

/*
       System.out.printf("<--- Bilet Bilgileri --->\n");
       System.out.printf("Otobous Plaka     : %s%n",otobus.plaka);
       System.out.printf("Koltuk NO         : %s%n",this.koltukNo);
       System.out.printf("Yolculuk Tipi     : %s%n",(this.yolculukTip == 1 ? "Tek Yon" : "Gidis-Donus"));
       System.out.printf("Mesafe            : %.2f%n",this.mesafe);
       System.out.printf("Toplam Tutar      : %.2f%n",this.fiyat);
       System.out.printf("Keyifli yolculuklar dileriz...%n");*/

    }


}