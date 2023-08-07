import java.util.*;
import java.util.ArrayList;
import java.util.List;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //For-toistolause
        //1.1 Kirjoita for-toistolause, joka kirjoittaa luvut nollasta kahteenkymmeneen.
        for (int i = 0; i < 11; i++) {
            System.out.println(i);
        }

        //1.2 Kirjoita for-toistolause, joka kirjoittaa numerot kymmenestä kahteenkymmeneen.
        for (int i = 10; i < 21; i++) {
            System.out.println(i);
        }

        //1.3 Kirjoita for-toistolause, joka kirjoittaa numerot sadasta nollaan. (100, 99, 98, jne.)
        for (int i = 0; i < 101; i++) {
            System.out.println(i);
        }

        //1.4 Kirjoita for-toistolause, joka kirjoittaa viiden kertotaulun luvut kymmenen toistoon asti
        //(5,10,15……90,95,100)
        int number = 5;
        for (int i = 0; i < 21; i++) {
            System.out.println(number * i);
        }

        //1.5 Kirjoita for-toistolause, joka kirjoittaa joka toisen numeron yhdestä yhdeksään. (1,3,5,7,9)
        for (int i = 1; i <= 9; i += 2) {
            System.out.println(i);
        }


        //While-toistolause
        //2.1 Kirjoita while-toistolause, joka tulostaa luvut nollasta kahteenkymmeneen
        int j = 0;

        while (j <= 20) {
            System.out.println(j);
            j++;
        }

        //2.2 Kirjoita while-toistolause, jossa laskuri aloittaa laskemisen luvusta yksi ja tuplaantuu joka toistolla,
        //kunnes laskuri ylittää sadan. Tulosta luku jokaisella toistolla. (1,2,4,8,16,32,64,128)
        int laskuri = 1;

        while (laskuri <= 100) {
            System.out.println(laskuri);
            laskuri *= 2;
        }

        //2.3 Kirjoita ohjelma, jossa on muuttujat Bensa ja Moottoriöljy, anna niille arvot 50 ja 5. Kirjoita whiletoistolause, joka toistuu niin kauan, kun bensaa ja moottoriöljyä on jäljellä. Jokaisella toistolla kasvatetaan
        //muuttujaa kilometrit yhdellä ja vähennetään bensaa 0.5:llä ja moottoriöljyä 0.05:llä. Lopuksi tulosta ajetut
        //kilometrit seuraavan laisesti: ”Ajettu xxx kilometriä”.
        double Bensa = 50.0;
        double Moottorioljy = 5.0;
        int kilometrit = 0;

        while (Bensa > 0 && Moottorioljy > 0) {
            kilometrit++;
            Bensa -= 0.5;
            Moottorioljy -= 0.05;
        }

        System.out.println("Ajettu " + kilometrit + " kilometriä");


        //Listat
        //3.1 Kirjoita toistolause, joka kirjoittaa listassa olevien hedelmien nimiä yksi kerrallaan. Kirjoita listaan ainakin viisi hedelmää.
        List<String> list = new ArrayList<String>();
        list.add("Mango");
        list.add("Omena");
        list.add("Banaani");
        list.add("Appelsiini");
        list.add("Vesimeloni");
        for (String hedelma : list)
            System.out.println(hedelma);


        //3.2 Kirjoita toistolause, joka toistaa 10 kierrosta. Lisää tyhjään listaan jokaista kierrosta vastaava numero.
        //Lopuksi tulosta koko lista.
        List<String> lista = new ArrayList<>();
        lista.add("M");
        lista.add("O");
        lista.add("B");
        lista.add("A");
        lista.add("V");

        for (int i = lista.size() - 1; i >= 0; i--) {
            System.out.println(lista.get(i));
        }

        //3.3 Kirjoita toistolause, joka käy läpi listaa, jossa on ihmisten ikiä. Listassa tulee olla ainakin kuusi numeroa
        //väliltä 0-100. Jos luku on pienempi kuin 18, niin tulosta ”alaikäinen”, jos toisin niin tulosta ”täysi-ikäinen”.
        List<Integer> ika = new ArrayList<>();
        ika.add(18);
        ika.add(12);
        ika.add(38);
        ika.add(85);
        ika.add(22);
        ika.add(17);

        for (int i : ika) {
            if (i < 18) {
                System.out.println(i +":" +" Olet Alaikäinen");
            } else {
                System.out.println(i +":" + " Olet Täysi-ikäinen");
            }
        }
    }
}