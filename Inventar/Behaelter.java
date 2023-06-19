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

  public Gegenstand entnehmen(int index) {
    if (index < 0 || index >= belegt) {
      return null;
    }

    Gegenstand gegenstand = inhalt[index];
    System.arraycopy(inhalt, index + 1, inhalt, index, belegt - index);
    --belegt;

    return gegenstand;
  }
}