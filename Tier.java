import java.util.GregorianCalendar;
import java.util.Calendar;


public abstract class Lebewesen {
    protected int groesse;
    protected int gewicht;

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
}

public abstract class Tier extends Lebewesen {
    protected String name;
    protected Tierart art;
    protected Datum geburtsdatum;
    protected Tierart lieblingsessen;

    public String getName() {
        return name;
    }
    public int getGroesse() {
        return groesse;
    }

    

    public int getAlter() {
        Calendar kal = new GregorianCalendar();

        int atag = kal.get(Calendar.DAY_OF_MONTH);
        int amonat = kal.get(Calendar.MONTH)+1;
        int ajahr = kal.get(Calendar.YEAR);
        

        if (geburtsdatum.getMonat() < amonat){
            return ajahr - geburtsdatum.getJahr();
        }
        else if (geburtsdatum.getMonat() > amonat){
            return ajahr - geburtsdatum.getJahr() - 1;
        }
        else if (geburtsdatum.getTag() <= atag){
            return ajahr - geburtsdatum.getJahr();
        }
        else {
            return ajahr - geburtsdatum.getJahr() - 1;
        }
    }
    public Tierart getArt() {
        return art;
    }
}

public abstract class Pflanze extends Lebewesen {}
public class Algen extends Pflanze {}
public class Blume extends Pflanze {}
public class Blätter extends Pflanze {}