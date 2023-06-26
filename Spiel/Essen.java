public class Essen extends Gegenstand {
  private int saettigung;
  private int regeneration;
  private int alter;

  public Essen(int saettigung, int regeneration, int alter, int gewicht) {
    super(gewicht);
    this.saettigung = saettigung;
    this.regeneration = regeneration;
    this.alter = alter;
    this.gewicht = gewicht;
  }

  public int getSaettigung() {
    return saettigung;
  }

  public int getAlter() {
    return alter;
  }

  public int getRegeneration() {
    return regeneration;
  }

  public void ausgeben() {
    System.out
        .print("Essen (sättigung: " + saettigung + ", regenerierung: " + regeneration + ", alter: " + alter + ", gewicht: " + gewicht + ")");
  }
}