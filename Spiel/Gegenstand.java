public abstract class Gegenstand {
  protected int gewicht;

  public Gegenstand(int gewicht) {
    this.gewicht = gewicht;
  }

  public int getGewicht() {
    return gewicht;
  }

  public abstract void ausgeben();
}