import java.util.GregorianCalendar;
import java.util.Calendar;

public class Pinguin extends Tier {
    private PinguinArt art;
    private FischArt hassFisch;
    private FischArt lieblingsFisch;

    public Pinguin(int groesse, int gewicht, String name, PinguinArt art, Datum geburtsdatum, FischArt hassFisch, FischArt lieblingsFisch) {
        this.groesse = groesse;
        this.gewicht = gewicht;
        this.name = name;
        this.art = art;
        this.geburtsdatum = geburtsdatum;
        this.hassFisch = hassFisch;
        this.lieblingsFisch = lieblingsFisch;
    }

    public PinguinArt getPinguinArt() {
        return art;
    }
    public FischArt getHassFisch() {
        return hassFisch;
    }
    public FischArt getLieblingsFisch() {
        return lieblingsFisch;
    }

    public void fischFressen(Fisch fisch) {
        if (fisch.getArt() == hassFisch) {
            System.out.println("Ihhh!");
            return;
        }
        if (fisch.getArt() == lieblingsFisch) {
            System.out.println("Lecker!");
        }
        gewicht += fisch.getGewicht();
    }
    public Pinguin geburtNeuerPinguin(String name, int gewicht, int groesse, FischArt hassFisch, FischArt lieblingsFisch) {
        Calendar kalender = new GregorianCalendar();

        int tag = kalender.get(Calendar.DAY_OF_MONTH);
        int monat = kalender.get(Calendar.MONTH) + 1;
        int jahr = kalender.get(Calendar.YEAR);

        Datum geburtsdatum = new Datum(jahr, monat, tag);
        return new Pinguin(groesse, gewicht, name, this.art, geburtsdatum, hassFisch, lieblingsFisch);
    }
}
