package marton_adrienn.vetelkedo;


public class Kerdes {

  public final String kerdes;
  public final String tema;
  public final int valasz;
  public final int pont;

  public Kerdes(String kerdes, int valasz, int pont, String tema) {
    this.kerdes = kerdes;
    this.valasz = valasz;
    this.pont = pont;
    this.tema = tema;
  }

  public void Mutat() {
    System.out.println(kerdes + " - " + valasz + " - " + pont + " - " + tema);
  }

}
