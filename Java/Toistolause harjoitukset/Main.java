import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // For Loop Examples

        // 1.1 Print numbers from 0 to 10
        for (int i = 0; i < 11; i++) {
            System.out.println(i);
        }

        // 1.2 Print numbers from 10 to 20
        for (int i = 10; i < 21; i++) {
            System.out.println(i);
        }

        // 1.3 Print numbers from 0 to 100
        for (int i = 0; i < 101; i++) {
            System.out.println(i);
        }

        // 1.4 Print multiples of 5 up to 100
        int number = 5;
        for (int i = 0; i < 21; i++) {
            System.out.println(number * i);
        }

        // 1.5 Print odd numbers from 1 to 9
        for (int i = 1; i <= 9; i += 2) {
            System.out.println(i);
        }


        // While Loop Examples

        // 2.1 Print numbers from 0 to 20 using a while loop
        int j = 0;
        while (j <= 20) {
            System.out.println(j);
            j++;
        }

        // 2.2 Print powers of 2 starting from 1 and doubling until > 100
        int laskuri = 1;
        while (laskuri <= 100) {
            System.out.println(laskuri);
            laskuri *= 2;
        }

        // 2.3 Simulate driving until fuel (Bensa) or oil (Moottoriöljy) runs out
        double Bensa = 50.0;
        double Moottorioljy = 5.0;
        int kilometrit = 0;
        while (Bensa > 0 && Moottorioljy > 0) {
            kilometrit++;
            Bensa -= 0.5;
            Moottorioljy -= 0.05;
        }
        System.out.println("Ajettu " + kilometrit + " kilometriä");


        // List Examples

        // 3.1 Print fruit names from a list
        List<String> list = new ArrayList<String>();
        list.add("Mango");
        list.add("Omena");
        list.add("Banaani");
        list.add("Appelsiini");
        list.add("Vesimeloni");
        for (String hedelma : list)
            System.out.println(hedelma);

        // 3.2 Populate and print a list with corresponding letters
        List<String> lista = new ArrayList<>();
        lista.add("M");
        lista.add("O");
        lista.add("B");
        lista.add("A");
        lista.add("V");
        for (int i = lista.size() - 1; i >= 0; i--) {
            System.out.println(lista.get(i));
        }

        // 3.3 Determine if ages in the list are minors or adults
        List<Integer> ika = new ArrayList<>();
        ika.add(18);
        ika.add(12);
        ika.add(38);
        ika.add(85);
        ika.add(22);
        ika.add(17);
        for (int i : ika) {
            if (i < 18) {
                System.out.println(i + ":" + " Olet Alaikäinen");
            } else {
                System.out.println(i + ":" + " Olet Täysi-ikäinen");
            }
        }
    }
}
