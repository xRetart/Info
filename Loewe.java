import java.util.GregorianCalendar;
import java.util.Calendar;


public class Loewe extends Tier {
    private Loewenart art;
    private Tierart lieblingsessen;
    private Tierart hassessen;

    public Loewe(int groess, int gewicht, String name, Loewenart art, Datum geburtsdatum, Tierart lieblingsessen, Tierart hassessen) {
        this.name = name;
        this.groesse = groesse;
        this.art = art;
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

    public void tierFressen(Tierart art) {
        if (art == hassessen) {
            System.out.println("Ihhh! " + art);
        }
        else if (art == lieblingsessen) {
            System.out.println("Lecker!" + art);
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