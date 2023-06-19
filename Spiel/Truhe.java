public class Truhe extends Behaelter {
  private boolean verschlossen;
  private String schlossTyp;

  public Truhe(boolean verschlossen, String schlossTyp, int kapazitaet) {
    this.verschlossen = verschlossen;
    this.schlossTyp = schlossTyp;
    this.inhalt = new Gegenstand[kapazitaet];
  }

  public boolean istVerschlossen() {
    return verschlossen;
  }

  public String getSchlossTyp() {
    return schlossTyp;
  }

  public boolean uebertragen(Inventar inventar, int index) {
    Gegenstand gegenstand = entnehmen(index);
    if (gegenstand == null) {
      return true;
    }

    return inventar.lagern(gegenstand);
  }

  public void ausgeben() {
    if (belegt > 0) {
      System.out.println("Inhalt der Truhe:");

      Gegenstand[] gegenstaende = inhalt;
      for (int i = 0; i < belegt; ++i) {
        System.out.print(" " + (i + 1) + ". ");
        gegenstaende[i].ausgeben();
      }
      System.out.println("Es sind " + belegt + " von " + getKapazitaet() + " plätzen belegt.");
    } else {
      System.out.println("Die Truhe ist leer.");
    }
    System.out.println();
  }
}