
import java.util.Scanner;
import java.util.ArrayList;

public class Spieler {
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Spieler spieler = new Spieler();

    Truhe truhe = new Truhe(false, "A", 10);
    Inventar inventar = new Inventar(40, 10);

    spieler.zustandAusgeben(truhe, inventar);
    ArrayList<Gegenstand> gegenstaende = spieler.gegenstaendeEntscheiden();
    spieler.gegenstandLagern(gegenstaende, truhe, inventar);
    spieler.gegenstaendeUebertragen(truhe, inventar);
    spieler.zustandAusgeben(truhe, inventar);
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

  public ArrayList<Gegenstand> gegenstaendeEntscheiden() {
    ArrayList<Gegenstand> gegenstaende = new ArrayList<Gegenstand>();
    String wahlFortsetzen;
    do {
      String wahlGegenstand = eingabe("Welchen Gegenstand möchtest du anlegen? [Schluessel/Schriftstueck/Essen]");

      int gewicht;
      switch (wahlGegenstand) {
        case "schluessel":
          String art = eingabe("Welche Form hat der Schlüssel?");
          gewicht = eingabeZahl("Wie schwer ist der Schlüssel in Gramm?");

          gegenstaende.add(new Schluessel(art, gewicht));
          break;

        case "schriftstueck":
          String inhalt = eingabe("Was soll auf dem Schriftstück stehen?");
          gewicht = eingabeZahl("Wie schwer ist das Schriftstück in Gramm?");

          gegenstaende.add(new Schriftstueck(inhalt, gewicht));
          break;

        case "essen":
          int saettigung = eingabeZahl("Wie hoch ist der Nährwert des Essens?");
          int regeneration = eingabeZahl("Wie viel leben regeneriert des Essens?");
          int alter = eingabeZahl("Wie alt ist des Essens in Tagen?");
          gewicht = eingabeZahl("Wie schwer ist das Essen in Gramm?");

          gegenstaende.add(new Essen(saettigung, regeneration, alter, gewicht));
          break;

        default:
          System.out.println("Den Gegenstand gibt es nicht.");
          break;
      }
      System.out.println();
      wahlFortsetzen = eingabe("Möchtest du noch einen Gegenstand anlegen? [JA/nein]");
    } while (wahlFortsetzen.equalsIgnoreCase("ja") || wahlFortsetzen.isEmpty());

    return gegenstaende;
  }

  public void gegenstandLagern(ArrayList<Gegenstand> gegenstaende, Truhe truhe, Inventar inventar) {
    String wahlBehaelter = eingabe("In welchen Behälter sollen die angelegten Gegenstände abgelegt werden?");
    switch (wahlBehaelter.toLowerCase()) {
      case "truhe":
        for (Gegenstand gegenstand : gegenstaende) {
          boolean hatGenugPlatz = truhe.lagern(gegenstand);
          if (!hatGenugPlatz) {
            System.err.println("Die Truhe hat nicht ausreichend Kapazitaet.");
          }
        }
        break;

      case "inventar":
        for (Gegenstand gegenstand : gegenstaende) {
          boolean hatGenugPlatz = inventar.lagern(gegenstand);
          if (!hatGenugPlatz) {
            System.err.println("Das Inventar hat nicht ausreichend Kapazitaet.");
          }
        }
        break;

      default:
        System.out.println("Das ist kein definierter Behälter.");
        gegenstandLagern(gegenstaende, truhe, inventar);
    }
  }

  public void gegenstandAusgeben(Gegenstand gegenstand) {
    if (gegenstand instanceof Schluessel) {
      System.out.println("Schluessel");
    } else if (gegenstand instanceof Schriftstueck) {
      System.out.println("Schriftstueck");
    } else if (gegenstand instanceof Essen) {
      System.out.println("Essen");
    } else {
      System.err.println("Gegenstandtyp nicht fuer Ausgabe implementiert.");
    }
  }

  public void inventarAusgeben(Inventar inventar) {
    if (inventar.belegt() > 0) {
      System.out.println("Inhalt des Inventars:");

      Gegenstand[] gegenstaende = inventar.getInhalt();
      for (int i = 0; i < inventar.belegt(); ++i) {
        System.out.print(" " + (i + 1) + ". ");
        gegenstandAusgeben(gegenstaende[i]);
      }
      System.out.println("Es sind " + inventar.belegt() + " von " + inventar.getKapazitaet() + " plätzen belegt.");
      System.out.println("Es sind " + inventar.getGewicht() + " von " + inventar.getMaxGewicht() + " gramm genutzt.");
    } else {
      System.out.println("Das Inventar ist leer.");
    }
  }

  public void truheAusgeben(Truhe truhe) {
    if (truhe.belegt() > 0) {
      System.out.println("Inhalt der Truhe:");

      Gegenstand[] gegenstaende = truhe.getInhalt();
      for (int i = 0; i < truhe.belegt(); ++i) {
        System.out.print(" " + (i + 1) + ". ");
        gegenstandAusgeben(gegenstaende[i]);
      }
      System.out.println("Es sind " + truhe.belegt() + " von " + truhe.getKapazitaet() + " plätzen belegt.");
    } else {
      System.out.println("Die Truhe ist leer.");
    }
  }

  public void zustandAusgeben(Truhe truhe, Inventar inventar) {
    System.out.println("aktueller Zustand:");

    System.out.println();
    inventarAusgeben(inventar);

    System.out.println();
    truheAusgeben(truhe);
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
}