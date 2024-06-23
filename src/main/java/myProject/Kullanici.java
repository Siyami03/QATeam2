package myProject;


/*

Project : Bir siteye uye olma ve giris yapma sayfasi tasarlayiniz.

        Menu : Kullaniciya islem secimi icin menu gosterilir.

        Uye olma (Kayit) :  - Kullanicida isim-soyisim, kullanici adi, email ve sifre bilgilerini aliniz
                            - Kullanici adi, email ve sifre birer listede tutulacak
                            - Ayni kullanici adi veya email kabul edilmez.

        Giris(login): - Kullanici adi / email ve sifre girilir.
                      - Kullanici adi veya email bulunamazsa kayitli degil, uye olun uyarisi verilmeli
                      - Kullanici adi / email ile ayni indexte kayitli sifre dogrulanirsa siteye giris yapilir.

        email sartlari :  email bosluk icermemeli
                        - @ sembolunu icermeli
                        - gmail.com, outlook.com, veya yahoo.com ile bitmeli
                        - Mailin kullanici adi kisminda (@ den once ) sadece buyuk-kucuk harf, rakam ya da
                          - . _ sembolleri olabilir.

        password sartlari :   Bosluk icermemeli
                            - en az 6 karakter olmali
                            - en az bir tane kucuk har icermeli
                            - en az bir tane buyuk harf icermeli
                            - en az bir tane rakam icermeli
                            - en az bir tane sembol icermeli

*/

public class Kullanici {

    private String isim;
    private String kullaniciAdi;
    private String email;
    private String password;


    public Kullanici(String isim, String kullaniciAdi, String email, String password) {
        this.isim = isim;
        this.kullaniciAdi = kullaniciAdi;
        this.email = email;
        this.password = password;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Kullanici{" +
                "isim='" + isim + '\'' +
                ", kullaniciAdi='" + kullaniciAdi + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
