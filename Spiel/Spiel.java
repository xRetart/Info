import java.util.Scanner;

public class Spiel {
  Scanner sc = new Scanner(System.in);

  Truhe truhe;
  Spieler spieler;

  public static void main(String[] args) {
    Spiel spiel = new Spiel();

    spiel.truhe = new Truhe(false, "A", 10);
    spiel.spieler = new Spieler(40000, 10);

    while (spiel.runde()) {
    }
  }

  public boolean runde() {
    zustandAusgeben();
    return menu();
  }

  public void menu_optionen() {
    System.out.println("Was möchtest du machen?");
    System.out.println("[1] Gegenstand erstellen");
    System.out.println("[2] Gegenstand ausruesten");
    System.out.println("[3] Gegenstand lagern");
    System.out.println("[4] Gegenstand entnehmnen");
    System.out.println("[5] Gegenstand nutzen");
    System.out.println("[6] Spiel beenden");
  }

  public boolean menu() {
    menu_optionen();
    String eingabe = eingabe(">");

    switch (eingabe.toLowerCase()) {
      case "1":
      case "gegenstand erstellen":
      case "erstellen":
        gegenstaendeErstellen();
        break;

      case "2":
      case "gegenstand ausrüsten":
      case "ausrüsten":
        gegenstandAusruesten();
        break;

      case "3":
      case "gegenstand lagern":
      case "lagern":
        System.out.println("debug: " + spieler.getInventar().belegt());
        gegenstandUebertragen(spieler.getInventar(), truhe);
        System.out.println("debug: " + spieler.getInventar().belegt());
        break;

      case "4":
      case "gegenstand entnehmen":
      case "entnehmen":
        gegenstandUebertragen(truhe, spieler.getInventar());
        break;

      case "5":
      case "gegenstand nutzen":
      case "nutzen":
        gegenstandNutzen();
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

  public void zustandAusgeben() {
    System.out.println("aktueller Zustand:");

    System.out.println();
    spieler.ausgeben();

    System.out.println();
    truhe.ausgeben();
  }

  public void gegenstaendeErstellen() {
    String wahlGegenstand = eingabe("Welchen Gegenstand möchtest du anlegen? [Schluessel/Schriftstueck/Essen]");

    Gegenstand gegenstand = null;
    int gewicht;
    switch (wahlGegenstand) {
      case "schluessel":
        String art = eingabe("Welche Form hat der Schlüssel?");
        gewicht = eingabeZahl("Wie schwer ist der Schlüssel in Gramm?");

        gegenstand = new Schluessel(art, gewicht);
        break;

      case "schriftstueck":
        String inhalt = eingabe("Was soll auf dem Schriftstück stehen?");
        gewicht = eingabeZahl("Wie schwer ist das Schriftstück in Gramm?");

        gegenstand = new Schriftstueck(inhalt, gewicht);
        break;

      case "essen":
        int saettigung = eingabeZahl("Wie hoch ist der Nährwert des Essens?");
        int regeneration = eingabeZahl("Wie viel leben regeneriert des Essens?");
        int alter = eingabeZahl("Wie alt ist des Essens in Tagen?");
        gewicht = eingabeZahl("Wie schwer ist das Essen in Gramm?");

        gegenstand = new Essen(saettigung, regeneration, alter, gewicht);
        break;

      default:
        System.out.println("Den Gegenstand gibt es nicht.");
        break;
    }

    if (gegenstand != null) {
      System.out.println("Gegenstand wurde erstellt.");

      if (spieler.getInventar().lagern(gegenstand)) {
        System.out.println("Gegenstand im Inventar gelagert");
      }
    } else {
      System.out.println("Das ist kein Gegenstand, wiederhole den Vorgang");
    }
  }

  public void gegenstandUebertragen(Behaelter quelle, Behaelter ziel) {
    int gegenstandPosition = eingabeZahl("Welchen Gegenstand möchten sie übertragen?");
    if (quelle.uebertragen(ziel, gegenstandPosition)) {
      System.out.println("Gegenstand wurde entnommen.");
    } else {
      System.out.println("Der Gegenstand gibt es nicht.");
    }
    System.out.println("debug 2: " + quelle.belegt());
  }

  public void gegenstandNutzen() {
    if (!spieler.ausfuehren(truhe)) {
      System.out.println("Der gegenstand konnte nicht genutzt weden.");
    }
  }

  public void gegenstandAusruesten() {
    int inventarPosition = eingabeZahl("Aus welcher Position im Inventar soll der Gegenstand ausgerüstet werden?");
    if (spieler.ausruesten(inventarPosition)) {
      System.out.println("Gegenstand wurde ausgerüstet.");
    } else {
      System.out.println("Gegenstand [" + inventarPosition + "] ist nicht im Inventar.");
    }
  }
}