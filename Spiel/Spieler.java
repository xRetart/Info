public class Spieler {
    private Gegenstand hand;
    private Inventar inventar;
    private Statuswert saettigung = new Statuswert(100, 100);
    private Statuswert leben = new Statuswert(100, 100);

    public Spieler(int inventarMaxGewicht, int inventarKapazitaet) {
        hand = null;
        inventar = new Inventar(inventarMaxGewicht, inventarKapazitaet);
    }

    public Gegenstand ausgeruested() {
        return hand;
    }

    public boolean ausruesten(int gegenstandPosition) {
        Gegenstand vorher = hand;
        Gegenstand nachher = inventar.entnehmen(gegenstandPosition);
        if (nachher == null) {
            return false;
        }
        if (vorher != null) {
            inventar.lagern(vorher);
        }
        hand = nachher;

        return true;
    }

    public Inventar getInventar() {
        return inventar;
    }

    public boolean ausfuehren(Truhe truhe) {
        if (hand == null) {
            return false;
        }

        if (hand instanceof Essen) {
            return essen((Essen)hand);
        } else if (hand instanceof Schriftstueck) {
            return lesen((Schriftstueck)hand);
        } else if (hand instanceof Schluessel) {
            return schliessen((Schluessel)hand, truhe);
        } else {
            System.out.println("Gegenstand typ ist nicht für ausführen implementiert.");
            return false;
        }
    }
    public boolean essen(Essen essen) {
        saettigung.erhoehen(((Essen) hand).getSaettigung());
        leben.erhoehen(((Essen) hand).getRegeneration());
        essen = null;
        return true;
    }
    public boolean lesen(Schriftstueck schriftstueck) {
        System.out.println(((Schriftstueck) hand).lesen());
        return true;
    }
    public boolean schliessen(Schluessel schluessel, Truhe truhe) {
        return truhe.schliessen((Schluessel) hand);
    }

    public void ausgeben() {
        System.out.println("Spieler:");
        System.out.print("\t- hat ");
        if (hand == null) {
            System.out.print("nichts");
        } else {
            hand.ausgeben();
        }
        System.out.println(" in der hand.");

        inventar.ausgeben();
    }
}
