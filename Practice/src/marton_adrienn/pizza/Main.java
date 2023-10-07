package marton_adrienn.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

  private static List<Pizza> feladatLista = new ArrayList<>();

  public static void main(String... args) {
    feltolt();
    // for (Pizza eset : feladatLista) eset.Mutat();

    System.out.println("\nA legkevesebb rendelés:");
    System.out.println(legkevesebb());

    System.out.println("\n11:40-es rendelés adatai:");
    rendeles("11:40");

    System.out.println("\nFutárok rendelései:");
    rendelesek();

    System.out.println("\nA legtöbb rendelés címe:");
    System.out.println(legtobb());
  }

  // Feltöltés
  private static void feltolt() {
    try {
      /*
        2020.12.01
        FUT_1
        1113 Petőfi 12 12:30
      */

      File file = new File("Practice\\orders.txt");
      Scanner scanner = new Scanner(file);

      String aktualis_datum = "";

      while (scanner.hasNextLine()) {
        String futar = scanner.nextLine();

        if (!futar.contains("FUT_")) {
          aktualis_datum = futar;
          futar = scanner.nextLine();
        }

        String[] adat_sor = scanner.nextLine().split(" ", 4);
        feladatLista.add(
          new Pizza(
            aktualis_datum,
            futar,
            adat_sor[0] + " " + adat_sor[1] + " " + adat_sor[2],
            // adat_sor[1],
            adat_sor[3]
          )
        );
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  // Melyik napon volt a legkevesebb rendelés?
  private static String legkevesebb() {
    Set<String> napok = new HashSet<String>();
    String min_nap = "";
    long min_darab = 1000;

    for (Pizza rend : feladatLista) napok.add(rend.datum);

    for (String nap : napok) {
      long db = feladatLista.stream().filter(n -> n.datum.equals(nap)).count();
      if (db < min_darab) {
        min_nap = nap;
        min_darab = db;
      }
    }

    return min_nap;
  }

  // Egy metódus várjon paraméterül egy dátumot, pontos időponttal és adjuk vissza a hozzá tartozó rendelést. Ha nincs ilyen akkor dobjunk kivételt.
  private static void rendeles(String ido) {
    for (Pizza rend : feladatLista) {
      if (rend.idopont.equals(ido)) rend.Mutat();
    }
  }

  // Készíts statisztikát a futárok szállításiból, futáronként add vissza, hogy mennyi rendelést teljesítettek.

  private static void rendelesek() {
    Set<String> futarok = new HashSet<String>();

    for (Pizza rend : feladatLista) futarok.add(rend.futar);

    for (String futar : futarok) {
      System.out.println(
        "Futár: " +
        futar +
        ", darab: " +
        feladatLista.stream().filter(n -> n.futar.equals(futar)).count()
      );
      // feladatLista.stream().filter(n -> n.futar.equals(futar)).forEach(n->n.Mutat());
    }
  }

  // Melyik címre szállították a legtöbb pizzát?
  private static String legtobb() {
    Set<String> cimek = new HashSet<String>();
    String max_cim = "";
    long max_darab = 0;

    for (Pizza rend : feladatLista) cimek.add(rend.cim);

    for (String cim : cimek) {
      long db = feladatLista.stream().filter(n -> n.cim.equals(cim)).count();
      if (db > max_darab) {
        max_cim = cim;
        max_darab = db;
      }
    }

    return max_cim;
  }
}
