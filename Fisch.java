public class Fisch extends Tier {
    private FischArt art;

    public Fisch(FischArt art, String name, int groesse, int gewicht, Datum geburtsdatum) {
        this.groesse = groesse;
        this.gewicht = gewicht;
        this.name = name;
        this.art = art;
        this.geburtsdatum = geburtsdatum;
    }

    public FischArt getArt() {
        return art;
    }
}