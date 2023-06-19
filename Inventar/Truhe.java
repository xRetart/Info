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
}