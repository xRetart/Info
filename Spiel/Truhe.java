public class Truhe extends Behaelter {
  private boolean verschlossen;
  private String schlossForm;

  public Truhe(boolean verschlossen, String schlossForm, int kapazitaet) {
    this.verschlossen = verschlossen;
    this.schlossForm = schlossForm;
    this.inhalt = new Gegenstand[kapazitaet];
  }

  public boolean istVerschlossen() {
    return verschlossen;
  }

  public String getSchlossForm() {
    return schlossForm;
  }

  public boolean schliessen(Schluessel schluessel) {
    if (schlossForm != schluessel.form()) {
      return false;
    }
    verschlossen = !verschlossen;
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
    System.out.println("Truhe:");
    System.out.println("\t- hat ein Schloss der Form \"" + schlossForm + "\".");

    if (verschlossen) {
      System.out.println("\t- ist verschlossen.");
    }
    else if (belegt > 0) {
      System.out.println("\t- beinhaltet:");

      Gegenstand[] gegenstaende = inhalt;
      for (int i = 0; i < belegt; ++i) {
        System.out.print("\t\t" + (i + 1) + ". ");
        gegenstaende[i].ausgeben();
        System.out.println();
      }
      System.out.println("\t- hat " + belegt + " von " + getKapazitaet() + " plätzen belegt.");
    } else {
      System.out.println("\t- ist leer.");
    }
  }
}