package marton_adrienn.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

  private static List<Pizza> feladatLista = new ArrayList<>();

  public static void main(String... args) {
    feltolt();

    System.out.println("\nA legkevesebb rendelés:");
    System.out.println(legkevesebb());

    System.out.println("\n11:40-es rendelés adatai:");
    System.out.println(rendeles("11:40"));

    System.out.println("\nFutárok rendelései:");
    for (Map.Entry<String, Long> rnd : rendelesek().entrySet()) {
      System.out.println(rnd.getKey() + ": " + rnd.getValue() + " db");
    }

    System.out.println("\nA legtöbb rendelés címe:");
    System.out.println(legtobb());
  }

  // Feltöltés
  private static void feltolt() {
    try {
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
    return feladatLista
      .stream()
      .collect(Collectors.groupingBy(n -> n.datum, Collectors.counting()))
      .entrySet()
      .stream()
      .min(Map.Entry.comparingByValue())
      .get()
      .getKey();
  }

  // Egy metódus várjon paraméterül egy dátumot, pontos időponttal és adjuk vissza a hozzá tartozó rendelést. Ha nincs ilyen akkor dobjunk kivételt.
  private static String rendeles(String ido) {
    return feladatLista
      .stream()
      .filter(n -> n.idopont.equals(ido))
      .findFirst()
      .orElseThrow()
      .toString();
  }

  // Készíts statisztikát a futárok szállításiból, futáronként add vissza, hogy mennyi rendelést teljesítettek.
  private static Map<String, Long> rendelesek() {
    return feladatLista
      .stream()
      .collect(Collectors.groupingBy(n -> n.futar, Collectors.counting()));
  }

  // Melyik címre szállították a legtöbb pizzát?
  private static String legtobb() {
    return feladatLista
      .stream()
      .collect(Collectors.groupingBy(n -> n.cim, Collectors.counting()))
      .entrySet()
      .stream()
      .max(Map.Entry.comparingByValue())
      .get()
      .getKey();
  }
}
