
import java.util.Scanner;

import javafx.scene.control.Menu;

import java.util.ArrayList;

public class Spieler {
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Spieler spieler = new Spieler();

    Truhe truhe = new Truhe(false, "A", 10);
    Inventar inventar = new Inventar(40000, 10);

    while (spieler.runde(inventar, truhe)) {
    }

  }

  public boolean runde(Inventar inventar, Truhe truhe) {
    zustandAusgeben(truhe, inventar);
    return menu(inventar, truhe);
  }

  public boolean menu(Inventar inventar, Truhe truhe) {
    System.out.println("Was möchtest du machen?");
    System.out.println("[1] Gegenstand erstellen");
    System.out.println("[2] Gegenstand lagern");
    System.out.println("[3] Gegenstand entnehmnen");
    System.out.println("[4] Gegenstand nutzen");
    System.out.println("[5] Spiel beenden");
    switch (eingabe(">").toLowerCase()) {
      case "1":
      case "gegenstand erstellen":
      case "erstellen":
        Gegenstand gegenstand = gegenstaendeErstellen();
        if (gegenstand != null) {
          System.out.println("Gegenstand wurde erstellt.");
        }
        else {
          System.out.println("Das ist kein Gegenstand, wiederhole den Vorgang");
        }
        inventar.lagern(gegenstand);
        System.out.println("Gegenstand im Inventar gelagert");
        break;

      case "2":
      case "gegenstand lagern":
      case "lagern":
        if (gegenstandLagern(truhe, inventar)) {
          System.out.println("Gegenstand wurde erfolgreich gelagert.");
        }
        else {
          System.out.println("Wallah, gibt nichst");
        }
        break;

      case "3":
      case "gegenstand entnehmen":
      case "entnehmen":
        if (gegenstandEntnehmen(truhe, inventar)) {
          System.out.println("Gegenstand wurde entnommen.");
        }
        else {
          System.out.println("Der Gegenstand gibt es nicht. UwU");
        }
        break;

      case "4":
      case "gegenstand nutzen":
      case "nutzen":

      case "5":
      case "spiel beenden":
      case "beenden":
        System.out.println("Das Menu wird geschlossen.");
        return false;

      return true;
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

  public Gegenstand gegenstaendeErstellen() {
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
    return gegenstand;
  }

  public void zustandAusgeben(Truhe truhe, Inventar inventar) {
    System.out.println("aktueller Zustand:");

    System.out.println();
    inventar.ausgeben();

    System.out.println();
    truhe.ausgeben();
  }

  public void gegenstaendeUebertragen(Truhe truhe, Inventar inventar) {
    zustandAusgeben(truhe, inventar);
    String uebertragenFortsetzen = eingabe("Möchtest du einen Gegenstand übertragen? [JA/nein]");
    while (uebertragenFortsetzen.equalsIgnoreCase("ja")) {
      String behaelter = eingabe("Aus welchem Behälter möchtest du den Gegenstand nehmen? [Truhe/Inventar]");
      int position = eingabeZahl("Den wievielten Gegenstand möchtest du übertragen?") - 1;
      boolean erfolg = true;
      switch (behaelter.toLowerCase()) {
        case "truhe":
          erfolg = truhe.uebertragen(inventar, position);
          break;

        case "inventar":
          erfolg = inventar.uebertragen(truhe, position);
          break;

        default:
          System.out.println("Das ist kein definierter Behaelter. ");
      }

      if (!erfolg) {
        System.out.println("Dieser Gegenstand ist nicht gelagert.");
      }

      zustandAusgeben(truhe, inventar);
      uebertragenFortsetzen = eingabe("Möchtest du noch einen Gegenstand übertragen? [JA/nein]");
    }

  }

  public boolean gegenstandLagern(Truhe truhe, Inventar inventar) {
    int gegenstandNummer = eingabeZahl("Welchen Gegenstand willst du übertragen?");
    Gegenstand gegenstand = inventar.entnehmen(gegenstandNummer);
    if (gegenstand == null) {
      return false;
    }
    return inventar.lagern(gegenstand);
  }
  
}