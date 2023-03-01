import java.util.GregorianCalendar;
import java.util.Calendar;

public abstract class Tier {
    protected String name;
    protected int groesse;
    protected int gewicht;
    protected Datum geburtsdatum;

    public String getName() {
        return name;
    }
    public int getGroesse() {
        return groesse;
    }
    public int getGewicht() {
        return gewicht;
    }
    public Datum getGeburtsdatum() {
        return geburtsdatum;
    }
    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }
    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public int getAlter() {
        Calendar kal = new GregorianCalendar();

        int atag = kal.get(Calendar.DAY_OF_MONTH);
        int amonat = kal.get(Calendar.MONTH)+1;
        int ajahr = kal.get(Calendar.YEAR);
        

        if (geburtsdatum.getMonat() < amonat){
            return ajahr-geburtsdatum.getJahr();
        }
        else if (geburtsdatum.getMonat() > amonat){
            return ajahr-geburtsdatum.getJahr() - 1;
        }
        else if (geburtsdatum.getTag() <= atag){
            return ajahr-geburtsdatum.getJahr();
        }
        else {
            return ajahr-geburtsdatum.getJahr() - 1;
        }
    }
}