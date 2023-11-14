public abstract class Behaelter {
  protected Gegenstand[] inhalt;
  protected int belegt = 0;

  public Gegenstand[] getInhalt() {
    return inhalt;
  }

  public int getKapazitaet() {
    return inhalt.length;
  }

  public int freierPlatz() {
    return inhalt.length - belegt;
  }

  public int belegt() {
    return belegt;
  }

  public boolean lagern(Gegenstand gegenstand) {
    if (belegt >= inhalt.length) {
      return false;
    }

    inhalt[belegt] = gegenstand;
    belegt++;

    return true;
  }

  public Gegenstand entnehmen(int position) {
    if (position < 0 || position >= belegt) {
      return null;
    }

    Gegenstand gegenstand = inhalt[position];
    System.arraycopy(inhalt, position + 1, inhalt, position, belegt - position);
    --belegt;

    return gegenstand;
  }

  public boolean uebertragen(Behaelter ziel, int index) {
    Gegenstand gegenstand = entnehmen(index);
    if (gegenstand == null) {
      return false;
    }

    return ziel.lagern(gegenstand);
  }
}