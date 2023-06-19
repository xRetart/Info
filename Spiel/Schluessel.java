public class Schluessel extends Gegenstand {
  private String form;

  public Schluessel(String form, int gewicht) {
    super(gewicht);
    this.form = form;
  }

  public String form() {
    return form;
  }

  public void ausgeben() {
    System.out.println("Schluessel");
  }
}