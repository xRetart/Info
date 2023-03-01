import java.util.ArrayList;
import java.util.Scanner;


public class Eisscholle {
    ArrayList<Pinguin> pinguine = new ArrayList<Pinguin>();
    Scanner sc = new Scanner(System.in);

    public static void main(String [] args) {
        Eisscholle es = new Eisscholle();

        do {
            es.pinguinKaufen();
            System.out.println("Weiteren Pinguin hinzufügen? [j/n]");
        } while (es.sc.next().equals("j"));

        for (int i = 0; i < es.pinguine.size(); i++) {
            Pinguin pinguin = es.pinguine.get(i);
            System.out.println(
                pinguin.getName()
                + " ist " + pinguin.getAlter() + " Jahre alt, wiegt "
                + pinguin.getGewicht() + " kg, ist "
                + pinguin.getGroesse() + " cm groß und ist ein "
                + pinguin.getPinguinArt()+"."
            );
        }
    }

    public String eingabeName(String prompt) {
        System.out.print(prompt);
        return sc.next();
    }

    public int eingabeZahl(String prompt) {
        System.out.print(prompt);

        try {
            return Integer.parseInt(sc.next());
        }
        catch(NumberFormatException e) {
            System.out.println("Das ist keine Zahl.");
            return eingabeZahl(prompt);
        }
    }

    public void fischFressen(int pinguinNummer, Fisch fisch) {
        Pinguin pinguin = pinguine.get(pinguinNummer);
        pinguin.fischFressen(fisch);
    }
    public void pinguinKaufen() {
        String name = eingabeName("Name: ");
        int gewicht = eingabeZahl("Gewicht in kg: ");
        int groesse = eingabeZahl("Groesse in cm: ");

        int gjahr = eingabeZahl("Geburtsjahr: ");
        int gmonat = eingabeZahl("Geburtsmonat: ");
        int gtag = eingabeZahl("Geburtstag: ");
        Datum geburtsdatum = new Datum(gjahr, gmonat, gtag);

        PinguinArt art = PinguinArt.valueOf(eingabeName("Pinguinart: "));
        FischArt hassFisch = FischArt.valueOf(eingabeName("Hassfisch: "));
        FischArt lieblingsFisch = FischArt.valueOf(eingabeName("Lieblingsfisch: "));
    
        pinguine.add(new Pinguin(groesse, gewicht, name, art, geburtsdatum, hassFisch, lieblingsFisch));
    }
    public void pinguinGeburt(int elternNummer) {
        Pinguin eltern = pinguine.get(elternNummer);

        String name = eingabeName("Name: ");
        int gewicht = eingabeZahl("Gewicht in kg: ");
        int groesse = eingabeZahl("Groesse in cm: ");

        FischArt hassFisch = FischArt.valueOf(eingabeName("Hassfisch: "));
        FischArt lieblingsFisch = FischArt.valueOf(eingabeName("Lieblingsfisch: "));

        pinguine.add(eltern.geburtNeuerPinguin(name, gewicht, groesse, hassFisch, lieblingsFisch));
    }
}