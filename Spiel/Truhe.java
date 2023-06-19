public class Truhe extends Behaelter {
  private boolean verschlossen;
  private String schlossForm;

  public Truhe(boolean verschlossen, String schlossTyp, int kapazitaet) {
    this.verschlossen = verschlossen;
    this.schlossForm = schlossTyp;
    this.inhalt = new Gegenstand[kapazitaet];
  }

  public boolean istVerschlossen() {
    return verschlossen;
  }

  public String getSchlossForm() {
    return schlossForm;
  }

  public boolean abchliessen(Schluessel schluessel) {
    if (schlossForm != schluessel.form()) {
      return false;
    }
    verschlossen = true;
    return true;
  }

  public boolean aufschliessen(Schluessel schluessel) {
    if (schlossForm != schluessel.form()) {
      return false;
    }
    verschlossen = false;
    return true;
  }

  public Gegenstand entnehmen(int position) {
    if (verschlossen) {
      return null;
    }
    return super.entnehmen(position);
  }

  public boolean lagern(Gegenstand gegenstand) {
    if (verschlossen) {
      return false;
    }
    return super.lagern(gegenstand);
  }

  public boolean uebertragen(Inventar inventar, int index) {
    if (verschlossen) {
      return false;
    }

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