package marton_adrienn.vetelkedo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

  private static List<Kerdes> kerdesekLista = new ArrayList<>();

  public static void main(String... args) {
    Set<String> hash_Set = new HashSet<String>();
    try {
      // Feltöltés
      File file = new File("Practice\\kerdesek.txt");
      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
        String kerdes_sor = scanner.nextLine();
        String[] adat_sor = scanner.nextLine().split(" ", 3);
        kerdesekLista.add(
          new Kerdes(
            kerdes_sor,
            Integer.parseInt(adat_sor[0]),
            Integer.parseInt(adat_sor[1]),
            adat_sor[2]
          )
        );
        hash_Set.add(adat_sor[2]);
      }

      //   for (Kerdes kerdes : kerdesekLista) kerdes.Mutat();
      String[] theme = hash_Set.toArray(new String[hash_Set.size()]);

      System.out.println("\nTörténelem téma kérdései:");
      kerdesek("tortenelem");

      System.out.println("\n10 darab minta kérdés:");
      feladatok(10);

      System.out.println("\nMinden feladat:");
      minden(theme);

      System.out.println("\nÖsszpontszámok:");
      osszpont(theme);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  // Írj egy metódust, melynek paramétere a téma és add vissza, az összes kérdést abban a témában. (Csak a kérdéseket)
  private static void kerdesek(String tema) {
    for (Kerdes kerdes : kerdesekLista) {
      if (kerdes.tema.equals(tema)) System.out.println(kerdes.kerdes);
    }
  }

  // Írj egy metódust, ami random sorsol ki n darab kérdést, és adja vissza annak összes adatát. (Nem lehetnek egyezőek)
  private static void feladatok(int darab) {
    Random random = new Random();
    for (int i = 0; i < darab; i++) {
      kerdesekLista.get(random.nextInt(0, kerdesekLista.size())).Mutat();
    }
  }

  // Készíts egy metódust ami rendszerezi a kérdéseket témakörönként. Visszatér egy adatszerkezetben amelyben témánként megtalálható az összes kérdés, összes adata.
  private static void minden(String[] theme) {
    for (int i = 0; i < theme.length; i++) {
      System.out.println("\n  " + theme[i]);
      for (Kerdes kerdes : kerdesekLista) {
        if (kerdes.tema.equals(theme[i])) System.out.println(
          "    " +
          kerdes.kerdes +
          " - " +
          kerdes.valasz +
          " - " +
          kerdes.pont +
          " - " +
          kerdes.tema
        );
      }
    }
  }

  // Az előző feladat segítségével határozd meg, hogy melyik téma kérdései érik a legtöbb pontot (összpontszám)!
  private static void osszpont(String[] theme) {
    for (int i = 0; i < theme.length; i++) {
      int osszpontszam = 0;
      for (Kerdes kerdes : kerdesekLista) {
        if (kerdes.tema.equals(theme[i])) osszpontszam += kerdes.pont;
      }
      System.out.println("  " + theme[i] + " " + osszpontszam + " pont");
    }
  }
}
