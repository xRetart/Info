public class Inventar extends Behaelter {
  private int maxGewicht;
  private int gewicht = 0;

  public Inventar(int maxGewicht, int kapazitaet) {
    this.maxGewicht = maxGewicht;
    this.inhalt = new Gegenstand[kapazitaet];
  }

  public int getMaxGewicht() {
    return maxGewicht;
  }

  public int getGewicht() {
    return gewicht;
  }

  public boolean lagern(Gegenstand gegenstand) {
    int neuesGewicht = gewicht + gegenstand.getGewicht();
    if (neuesGewicht > maxGewicht) {
      return false;
    }

    gewicht = neuesGewicht;
    return super.lagern(gegenstand);
  }

  public boolean uebertragen(Truhe truhe, int index) {
    Gegenstand gegenstand = entnehmen(index);
    if (gegenstand == null) {
      return true;
    }

    gewicht -= gegenstand.getGewicht();
    return truhe.lagern(gegenstand);
  }
}