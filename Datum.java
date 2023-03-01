public class Datum {
    private int jahr;
    private int monat;
    private int tag;

    public Datum(int jahr, int monat, int tag){
        this.jahr = jahr;
        this.monat = monat;
        this.tag = tag;
    }

    public int getJahr(){
        return jahr;
    }
    public int getMonat(){
        return monat;
    }
    public int getTag(){
        return tag;
    }
}