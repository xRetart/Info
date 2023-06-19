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

  public Gegenstand entnehmen(int position) {
    Gegenstand gegenstand = super.entnehmen(position);
    if (gegenstand != null) {
      gewicht -= gegenstand.getGewicht();
    }

    return gegenstand;
  }

  public void ausgeben() {
    if (belegt() > 0) {
      System.out.println("Inhalt des Inventars:");

      Gegenstand[] gegenstaende = getInhalt();
      for (int i = 0; i < belegt; ++i) {
        System.out.print(" " + (i + 1) + ". ");
        gegenstaende[i].ausgeben();
        System.out.println();
      }
      System.out.println("Es sind " + belegt() + " von " + getKapazitaet() + " plätzen belegt.");
      System.out.println("Es sind " + getGewicht() + " von " + getMaxGewicht() + " gramm genutzt.");
    } else {
      System.out.println("Das Inventar ist leer.");
    }
  }
}