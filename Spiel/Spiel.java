import java.util.Scanner;

public class Spiel {
  Scanner sc = new Scanner(System.in);

  Truhe truhe;
  Spieler spieler;

  public Spiel() {
    Schluessel schluessel = new Schluessel("A", 25);
    truhe = new Truhe(false, "A", 10);
    truhe.lagern(new Schriftstueck("Das ist der Inhalt des Schriftstuecks.", 100));
    truhe.lagern(new Essen(10, 20, 3, 350));
    truhe.schliessen(schluessel);

    spieler = new Spieler(40000, 10, 50, 50);
    spieler.getInventar().lagern(schluessel);
  }
  public static void main(String[] args) {
    Spiel spiel = new Spiel();

    while (spiel.runde()) {
    }
  }

  public boolean runde() {
    zustandAusgeben();
    System.out.println();
    return menu();
  }

  public boolean menu() {
    menu_optionen();
    String eingabe = eingabe(">");
    return menu_eingabe_verarbeiten(eingabe);
  }
  public void menu_optionen() {
    System.out.println("Was möchten sie machen?");
    System.out.println("[1] Gegenstand ausruesten");
    System.out.println("[2] Gegenstad abrüsten");
    System.out.println("[3] Gegenstand lagern");
    System.out.println("[4] Gegenstand entnehmnen");
    System.out.println("[5] Gegenstand nutzen");
    System.out.println("[6] Spiel beenden");
  }
  public boolean menu_eingabe_verarbeiten(String eingabe) {
    switch (eingabe.toLowerCase()) {
      case "1":
      case "gegenstand ausrüsten":
      case "ausrüsten":
        gegenstandAusruesten();
        break;

      case "2":
      case "gegenstand abrüsten":
      case "abrüsten":
        spieler.abruesten();
        break;

      case "3":
      case "gegenstand lagern":
      case "lagern":
        gegenstandUebertragen(spieler.getInventar(), truhe);
        break;

      case "4":
      case "gegenstand entnehmen":
      case "entnehmen":
        gegenstandUebertragen(truhe, spieler.getInventar());
        break;

      case "5":
      case "gegenstand nutzen":
      case "nutzen":
        spieler.ausfuehren(truhe);
        break;

      case "6":
      case "spiel beenden":
      case "beenden":
        System.out.println("Das Menu wird geschlossen.");
        return false;

      default:
        System.out.println("\"" + eingabe + "\" ist keine Menuoption.");
        break;
    }

    return true;
  }

  public void zustandAusgeben() {
    spieler.ausgeben();
    System.out.println();
    truhe.ausgeben();
  }

  public void gegenstandUebertragen(Behaelter quelle, Behaelter ziel) {
    int gegenstandPosition = eingabeZahl("Welchen Gegenstand möchten sie übertragen?") - 1;
    if (quelle.uebertragen(ziel, gegenstandPosition)) {
      System.out.println("Gegenstand wurde entnommen.");
    } else {
      System.out.println("Der Gegenstand konnte nicht übertragen werden.");
    }
  }

  public void gegenstandAusruesten() {
    int inventarPosition = eingabeZahl("Aus welcher Position im Inventar soll der Gegenstand ausgerüstet werden?") - 1;
    if (spieler.ausruesten(inventarPosition)) {
      System.out.println("Gegenstand wurde ausgerüstet.");
    } else {
      System.out.println("Gegenstand [" + inventarPosition + "] ist nicht im Inventar.");
    }
  }

  public String eingabe(String prompt) {
    String PROMPT_INDIKATOR = ": ";

    System.out.print(prompt + PROMPT_INDIKATOR);
    return sc.next();
  }

  public int eingabeZahl(String prompt) {
    try {
      return Integer.parseInt(eingabe(prompt));
    } catch (NumberFormatException _e) {
      System.out.println("Das war keine Zahl. Versuche es erneut.");
      return eingabeZahl(prompt);
    }
  }
}