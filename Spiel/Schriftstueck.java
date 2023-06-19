public class Schriftstueck extends Gegenstand {
  private String inhalt;

  public Schriftstueck(String inhalt, int gewicht) {
    super(gewicht);
    this.inhalt = inhalt;
  }

  public String lesen() {
    return inhalt;
  }

  public void beschreiben(String neuerInhalt) {
    inhalt = neuerInhalt;
  }

  public void ausgeben() {
    System.out.print("Schriftstueck (inhalt: " + inhalt.length() + " Zeichen)");
  }
}