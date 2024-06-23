package bilet;

import java.util.ArrayList;
import java.util.List;

public class Otobus {

    public String plaka;
    public List<String> koltuklar = new ArrayList<>();

    Otobus(String plaka){
        this.plaka = plaka;
        for (int i = 1; i < 33 ; i++){
            this.koltuklar.add(String.valueOf(i)); //(i + "")
        }
    }

}