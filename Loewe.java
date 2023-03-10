import java.util.GregorianCalendar;
import java.util.Calendar;


public class Loewe extends Tier {
    private Loewenart art;

    public Loewe(int groess, int gewicht, String name, Loewenart art, Datum geburtsdatum, Tierart lieblingsessen, Tierart hassessen) {
        this.name = name;
        this.groesse = groesse;
        this.art = (Tierart)art;
        this.gewicht = gewicht;
        this.lieblingsessen = lieblingsessen;
        this.hassessen = hassessen;
    }
    
    public Loewenart getLoewenart() {
        return art;
    }
    public Tierart getHassessen() {
        return hassessen;
    }
    public Tierart getLieblingsessen() {
        return lieblingsessen;
    }

    public boolean fressen(Tier tier) {
        if (tier instanceof Pinguin) {
            System.out.println(name + "frisst einen Pinguin.");
            return true;
        }
        else if (tier instanceof Fisch) {
            System.out.println(name + "frisst einen Fisch.");
            return true;
        }
        else {
            System.out.println("In Loewe frisst nur Pinguin");
            return false;
        }
    }
    public Loewe geburt(String name, int gewicht, int groesse, FischArt hassFisch, FischArt lieblingsFisch) {
        Calendar kalender = new GregorianCalendar();

        int tag = kalender.get(Calendar.DAY_OF_MONTH);
        int monat = kalender.get(Calendar.MONTH) + 1;
        int jahr = kalender.get(Calendar.YEAR);

        Datum geburtsdatum = new Datum(jahr, monat, tag);
        return new Loewe(groesse, gewicht, name, this.art, geburtsdatum, hassessen, lieblingsessen);
    }
}